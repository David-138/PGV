package com.proyecto.mangaList.entity.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "manga")
public class Manga implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "ID_Manga")
    private long ID_Manga;

    private String titulo;
    private String sinopsis;
    private String serializacion;
    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Review> reviews;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "mangagenero",
        joinColumns = @JoinColumn(name = "ID_Manga"),
        inverseJoinColumns = @JoinColumn(name = "ID_Genero")
    )
    private Set<Genre> genre = new HashSet<>();

    public Manga(long ID_Manga, String titulo, String sinopsis, String serializacion) {
        this.ID_Manga = ID_Manga;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.serializacion = serializacion;
    }

    public Manga() {
        this.genre = new HashSet<>();
    }

    public long getID_Manga() {
        return ID_Manga;
    }

    public void setID_Manga(long ID_Manga) {
        this.ID_Manga = ID_Manga;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getSerializacion() {
        return serializacion;
    }

    public void setSerializacion(String serializacion) {
        this.serializacion = serializacion;
    }

    public Set<Genre> getGenre() {
        return genre;
    }

    public void setGenre(Set<Genre> genre) {
        this.genre = genre;
    }

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
}