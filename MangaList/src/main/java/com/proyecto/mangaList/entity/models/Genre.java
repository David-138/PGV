package com.proyecto.mangaList.entity.models;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="genero")
public class Genre implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID_Genero;
	private String nombre;
	@ManyToMany(mappedBy = "genre")
    @JsonIgnore
    private Set<Manga> manga;

	public long getID_Genero() {
		return ID_Genero;
	}
	public void setID_Genero(long iD_Genero) {
		ID_Genero = iD_Genero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Genre(long iD_Genero, String nombre) {
		super();
		ID_Genero = iD_Genero;
		this.nombre = nombre;
	}
	public Genre() {
		
	}
}
