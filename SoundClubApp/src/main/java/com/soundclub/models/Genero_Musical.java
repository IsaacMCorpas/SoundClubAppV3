package com.soundclub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="musical_genre")
public class Genero_Musical {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mid")
	private int mid;
	
	@Column(name="name")
	private String nombre;

	public Genero_Musical(){
		
	}
	
	public Genero_Musical(int mid, String nombre) {
		super();
		this.mid = mid;
		this.nombre = nombre;
	}

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
