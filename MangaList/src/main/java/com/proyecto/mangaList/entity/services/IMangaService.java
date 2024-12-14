package com.proyecto.mangaList.entity.services;

import java.util.List;
import com.proyecto.mangaList.entity.models.Manga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMangaService {
	public Manga get(long ID_Manga);
	public List<Manga> getAll();
	public void post(Manga manga);
	public void put(Manga manga, long ID_Manga);
	public void delete(long ID_Manga);
    Page<Manga> getAll(Pageable pageable);
}
