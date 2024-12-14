package com.proyecto.mangaList.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.mangaList.entity.models.Genre;
import com.proyecto.mangaList.entity.services.IGenreService;

@RestController
@CrossOrigin(origins="*")
public class GenreController {
	@Autowired
	IGenreService genreService;
	
	@GetMapping("/Genres")
	public List<Genre> getAllGenres(){
		return genreService.getAll();
	}
	@GetMapping("/Genres/{ID_Genero}")
	public Genre getOne(@PathVariable(value="ID_Genero")long ID_Genero) {
		return genreService.get(ID_Genero);
	}
	@PostMapping("/Genres")
	public void post(Genre genre) {
		genreService.post(genre);
	}
	
	@PutMapping("/Genres/{ID_Genero}")
	public void put(Genre genre, @PathVariable(value="ID_Genero") long ID_Genero) {
		genreService.put(genre, ID_Genero);
	}
	
	@DeleteMapping("/Genres/{ID_Genero}")
	public void delete(@PathVariable(value="ID_Genero") long ID_Genero) {
		genreService.delete(ID_Genero);
	}
}
