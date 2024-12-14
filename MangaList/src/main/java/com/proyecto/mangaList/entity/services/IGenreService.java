package com.proyecto.mangaList.entity.services;

import java.util.List;
import com.proyecto.mangaList.entity.models.Genre;

public interface IGenreService {
	public Genre get(long ID_Genre);
	public List<Genre> getAll();
	public void post(Genre genre);
	public void put(Genre genre, long ID_Genre);
	public void delete(long ID_Genre);
}
