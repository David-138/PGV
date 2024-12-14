package com.proyecto.mangaList.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.mangaList.entity.dao.IMangaDao;
import com.proyecto.mangaList.entity.dao.IReviewDao;
import com.proyecto.mangaList.entity.models.Manga;
import com.proyecto.mangaList.entity.models.Review;

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	private IReviewDao reviewDao;

	@Autowired
	private IMangaDao mangaDao;

	@Override
	public Review get(long ID_Review) {
		return reviewDao.findById(ID_Review).get();
	}

	@Override
	public List<Review> getAll() {
		return (List<Review>) reviewDao.findAll();
	}

	@Override
	public void post(Review review) {
		Long mangaId = review.getId_Manga();
		if (mangaId == null) {
			throw new RuntimeException("El ID del manga es obligatorio para crear una reseña.");
		}
		Manga manga = mangaDao.findById(mangaId).orElseThrow(() -> new RuntimeException("Manga no encontrado"));
		review.setManga(manga);
		reviewDao.save(review);
	}

	@Override
	public void put(Review review, long ID_Review) {
		reviewDao.findById(ID_Review).ifPresentOrElse(existingReview -> {
			review.setID_Review(ID_Review);
			Long mangaId = review.getId_Manga();
			if (mangaId != null) {
				Manga manga = mangaDao.findById(mangaId).orElseThrow(() -> new RuntimeException("Manga no encontrado"));
				review.setManga(manga);
			} else {
				review.setManga(existingReview.getManga());
			}
			reviewDao.save(review);
		}, () -> {
			throw new RuntimeException("Review no encontrada con ID: " + ID_Review);
		});
	}

	@Override
	public void delete(long ID_Review) {
		reviewDao.deleteById(ID_Review);

	}

}
