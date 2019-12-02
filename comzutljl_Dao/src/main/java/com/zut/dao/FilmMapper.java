package com.zut.dao;

import com.zut.entity.Film;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassDesc: 功能描述：(dao层)
 * @Author: 赖建梁
 * @Version: 1.0
 * @Date: 2019/12/1  19:54
 * @FromAPI: --
 **/

public interface FilmMapper {

    public int addFilm(Film film);

    public Film getFilmById(long id);

    public List<Film> getListFilm();
}
