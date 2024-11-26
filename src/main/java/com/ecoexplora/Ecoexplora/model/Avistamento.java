package com.ecoexplora.Ecoexplora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "avistamentos")

public class Avistamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String user;
	private String local;
	private String data;
	
	public Avistamento(String user, String local, String data) {	
		this.user = user;
		this.local = local;
		this.data = data;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Avistamento() {
		
	}
	
}