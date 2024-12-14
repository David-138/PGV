package com.proyecto.mangaList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.mangaList.entity.models.Manga;
import com.proyecto.mangaList.entity.services.IMangaService;

@RestController
@CrossOrigin(origins="*")
public class MangaController {
	@Autowired
	IMangaService mangaService;
	
	@GetMapping("/Manga")
	public Page<Manga> getAllMangas(@RequestParam(defaultValue = "0") int page,
	                                @RequestParam(defaultValue = "20") int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    return mangaService.getAll(pageable);
	}
	
	@GetMapping("/Manga/{ID_Manga}")
	public Manga getOne(@PathVariable(value="ID_Manga")long ID_Manga) {
		return mangaService.get(ID_Manga);
	}
	
	@PostMapping("/Manga")
	public void post(Manga manga) {
		mangaService.post(manga);
	}
	
	@PutMapping("/Manga/{ID_Manga}")
	public void put(Manga manga, @PathVariable(value="ID_Manga") long ID_Manga) {
		mangaService.put(manga, ID_Manga);
	}
	
	@DeleteMapping("/Manga/{ID_Manga}")
	public void delete(@PathVariable(value="ID_Manga") long ID_Manga) {
		mangaService.delete(ID_Manga);
	}
}
