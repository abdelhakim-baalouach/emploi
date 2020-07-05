package com.miage.projet.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="salle")
public class salle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSalle;
	@Column(name = "num",nullable = false)  
	private String num;
	@Column(name = "etage",nullable = false)  
	private Integer etage;
	@Column(name = "type",nullable = false)  
	private String type;
	
	@OneToMany(targetEntity=seance.class, mappedBy="salle", cascade=CascadeType.REMOVE)
	private List<seance> ListSeance;

	
	public salle() {
		super();
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Integer getEtage() {
		return etage;
	}
	public void setEtage(Integer etage) {
		this.etage = etage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(Integer idSalle) {
		this.idSalle = idSalle;
	}
	public List<seance> getListSeance() {
		return ListSeance;
	}
	public void setListSeance(List<seance> listSeance) {
		ListSeance = listSeance;
	}
}
