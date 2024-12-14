package com.proyecto.mangaList.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.mangaList.entity.dao.IGenreDao;
import com.proyecto.mangaList.entity.models.Genre;

@Service
public class GenreServiceImpl implements IGenreService{

	@Autowired
	private IGenreDao genreDao;
	

	@Override
	public Genre get(long ID_Genero) {
		return genreDao.findById(ID_Genero).get();
	}
	
	@Override
	public List<Genre> getAll() {
		return (List<Genre>) genreDao.findAll();
	}

	@Override
	public void post(Genre genre) {
		genreDao.save(genre);
	}

	@Override
	public void put(Genre genre, long ID_Genero) {
		genreDao.findById(ID_Genero).ifPresent((x)->{
			genre.setID_Genero(ID_Genero);
			genreDao.save(genre);
		});
	}

	@Override
	public void delete(long ID_Genero) {
		genreDao.deleteById(ID_Genero);		
	}

}
