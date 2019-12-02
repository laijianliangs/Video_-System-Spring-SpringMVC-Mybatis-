package com.zut.service.impl;

import com.zut.dao.FilmMapper;
import com.zut.entity.Film;
import com.zut.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmMapper filmMapper;

    @Override
    public Film getFilmById(long id) {

        return filmMapper.getFilmById(id);
    }

    @Override
    public List<Film> getListFilm() {
        return filmMapper.getListFilm();
    }

    @Override
    public int addFilm(Film film) {
        filmMapper.addFilm(film);
        return 0;
    }
}
