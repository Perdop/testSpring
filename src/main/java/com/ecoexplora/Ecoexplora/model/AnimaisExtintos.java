package com.ecoexplora.Ecoexplora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animaisextinstos")

public class AnimaisExtintos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String nome;
	private String sobre;
	private Integer classe;
	private Integer existentes;
	private String estado;
	private String img;
	
	public AnimaisExtintos(String nome, String sobre, Integer classe, Integer existentes, String estado, String img) {	
		this.nome = nome;
		this.sobre = sobre;
		this.classe = classe;
		this.existentes = existentes;
		this.estado = estado;
		this.img = img;
	}
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getSobre() {
		return sobre;
	}
	public Integer getClasse() {
		return classe;
	}
	public Integer getExistentes() {
		return existentes;
	}
	public String getEstado() {
		return estado;
	}
	public String getImg() {
		return img;
	}
	
	public void setNome(String user) {
		this.nome = user;
	}
	public void setSobre(String password) {
		this.sobre = password;
	}
	public void setClasse(Integer classe) {
		this.classe = classe;
	}
	public void setExistentes(Integer existentes) {
		this.existentes = existentes;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public AnimaisExtintos() {
		
	}
	
}