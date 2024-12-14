package com.proyecto.mangaList.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.mangaList.entity.models.Manga;

public interface IMangaDao extends JpaRepository<Manga, Long>{

}
