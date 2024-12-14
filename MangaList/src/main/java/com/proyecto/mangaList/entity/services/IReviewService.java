package com.proyecto.mangaList.entity.services;

import java.util.List;

import com.proyecto.mangaList.entity.models.Review;

public interface IReviewService {
	public Review get(long ID_Review);
	public List<Review> getAll();
	public void post(Review review);
	public void put(Review review, long ID_Review);
	public void delete(long ID_Review);
}
