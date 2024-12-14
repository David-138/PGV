package com.proyecto.mangaList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;	
import com.proyecto.mangaList.entity.models.Review;
import com.proyecto.mangaList.entity.services.IReviewService;

@RestController
@CrossOrigin(origins="*")
public class ReviewController {
	@Autowired
	IReviewService reviewService;
	
	@GetMapping("/Review")
	public List<Review> getAllReviews(){
		return reviewService.getAll();
	}
	@GetMapping("/Review/{ID_Review}")
	public Review getOne(@PathVariable(value="ID_Review")long ID_Review) {
		return reviewService.get(ID_Review);
	}
	@PostMapping("/Review")
	public void post(@RequestBody Review review) {
	    reviewService.post(review);
	}

	@PutMapping("/Review/{ID_Review}")
	public void put(@RequestBody Review review, @PathVariable(value = "ID_Review") long ID_Review) {
	    reviewService.put(review, ID_Review);
	}	
	@DeleteMapping("/Review/{ID_Review}")
	public void delete(@PathVariable(value="ID_Review") long ID_Review) {
		reviewService.delete(ID_Review);
	}
}
