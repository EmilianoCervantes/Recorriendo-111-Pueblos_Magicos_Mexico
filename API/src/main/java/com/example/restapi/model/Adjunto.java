package com.example.restapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Adjunto")
public class Adjunto {
	@Id
	private String id;
	private String distancia;
	private String pueblo_id_1;
	private String pueblo_id_2;
	
	
	
	public Adjunto() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDistancia() {
		return distancia;
	}
	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	public String getPueblo_id_1() {
		return pueblo_id_1;
	}
	public void setPueblo_id_1(String pueblo_id_1) {
		this.pueblo_id_1 = pueblo_id_1;
	}
	public String getPueblo_id_2() {
		return pueblo_id_2;
	}
	public void setPueblo_id_2(String pueblo_id_2) {
		this.pueblo_id_2 = pueblo_id_2;
	}
	
	
}
