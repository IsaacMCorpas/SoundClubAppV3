package com.soundclub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instrument")
public class Instrumento {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="iid")
	private int iid;
	@Column(name="name")
	private String nombre;
	public Instrumento(int iid, String instrumento) {
		super();
		this.iid = iid;
		nombre = instrumento;
	}
	
	public Instrumento() {
		
	}
	
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
