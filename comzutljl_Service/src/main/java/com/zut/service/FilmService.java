package com.zut.service;

import com.zut.entity.Film;

import java.util.List;

public interface FilmService {

    public Film getFilmById(long id);

    public List<Film> getListFilm();

    public int addFilm(Film film);
}
