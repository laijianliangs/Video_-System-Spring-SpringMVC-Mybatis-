package com.zut.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zut.entity.Film;
import com.zut.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class ManagerController {

    @Autowired
    private FilmService filmService;

    /**
     *
     *@ClassDesc:  功能描述：(一般把请求返回的变量放在前面，保证代码的简洁性和可读性)
     *@Author:     赖建梁
     *@Version:    1.0
     *@Date: 2019/12/1  19:57
     *@FromAPI: --
     *
     **/
    private static final String MANAGER = "manager";
    private static final String GETFILM = "film";
    private static final String ADDFILM = "addfilm";
    private static final String SAVEFILM = "savefilm";

    //跳到显示所有film的页面
    @RequestMapping("/manager")
    public String managerPage(HttpServletRequest request, Integer indexPage) {
        if (indexPage == null) {  //做分页时，一定要判断indexpage非空，当第一次点击时indexpag是为空的
            indexPage = 1;        //不然会报空指针异常
        }
        Page page = PageHelper.startPage(indexPage, 2);  //调用Pagehelper，括号中的第一个参数为开始的页数，第二个参数是每页的记录数
        request.setAttribute("listfilm", filmService.getListFilm());
        request.setAttribute("pages", page.getPages());  //page.getPages()取出的是分出的总页数
        return MANAGER;
    }

    //调到每个film的播放界面
    @RequestMapping("/film")
    public String getFilm(HttpServletRequest request, Integer id) {

        request.setAttribute("film", filmService.getFilmById(id));
        return GETFILM;
    }

    //转到添加视频的界面
    @RequestMapping("/addfilm")
    public String addFilm(HttpServletRequest request) {
        request.setAttribute("listfilm", filmService.getListFilm());
        return ADDFILM;
    }

    //处理由form表单提交的数据，保存添加的视频
    @RequestMapping("/savefilm")
    public String saveFilm(@RequestParam(value = "file", required = false) MultipartFile file, Film film, HttpServletRequest request) {

        String imgName = System.currentTimeMillis() + ".png";  //设置图片的名字，为了保证不重复。利用时间戳
        String path = request.getSession().getServletContext().getRealPath("/static/imags");//得到保存的图片的实际物理地址
        File targetfile = new File(path, imgName);
        if (!targetfile.exists()) {
            targetfile.mkdirs();//如果文件不存在，就创建文件夹
        }

        try {
            file.transferTo(targetfile);
        } catch (IOException e) {
            System.out.println("file faild");
            return ADDFILM;
        }
        try {
            film.setImgurl(imgName);
            filmService.addFilm(film);//一般在操作数据时都要获取异常，所以要用try catch
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/manager";  //重定向为管理页面
    }
}
