package com.proyecto.mangaList.entity.models;

import java.io.Serializable;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "review")
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID_Review;
    private String Contenido;
    private int nota;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Manga", nullable = false)
    @JsonBackReference
    private Manga manga;
    @Transient
    private Long id_Manga;
    public long getID_Review() {
		return ID_Review;
	}
	public void setID_Review(long iD_Review) {
		ID_Review = iD_Review;
	}
	public String getContenido() {
		return Contenido;
	}
	public void setContenido(String contenido) {
		Contenido = contenido;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public Manga getManga() {
		return manga;
	}
	public void setManga(Manga manga) {
		this.manga = manga;
	}
	public Long getId_Manga() {
	    return this.manga != null ? this.manga.getID_Manga() : this.id_Manga;
	}
	public void setId_Manga(Long id_Manga) {
		this.id_Manga = id_Manga;
	}
	public Review() {
		
	}
	public Review(long iD_Review, String contenido, int nota, Manga manga) {
		super();
		ID_Review = iD_Review;
		Contenido = contenido;
		this.nota = nota;
		this.manga = manga;
	}
    
}
