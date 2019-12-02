package com.zut.entity;

import org.springframework.stereotype.Component;

/**
 * @ClassDesc: 功能描述：(实体类Film)
 * @Author: 赖建梁
 * @Version: 1.0
 * @Date: 2019/12/1  19:54
 * @FromAPI: --
 **/
@Component
public class Film {

    private String name;
    private String type;
    private String imgurl;
    private long id;
    private String htmlurl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHtmlurl() {
        return htmlurl;
    }

    public void setHtmlurl(String htmlurl) {
        this.htmlurl = htmlurl;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", id=" + id +
                ", htmlurl='" + htmlurl + '\'' +
                '}';
    }
}
