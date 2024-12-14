package com.proyecto.mangaList.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.mangaList.entity.models.Review;

public interface IReviewDao  extends JpaRepository<Review, Long>{

}
