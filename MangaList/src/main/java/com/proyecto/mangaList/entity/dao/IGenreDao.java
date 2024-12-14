package com.proyecto.mangaList.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.mangaList.entity.models.Genre;

public interface IGenreDao extends JpaRepository<Genre, Long>{

}
