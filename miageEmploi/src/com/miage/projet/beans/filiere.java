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
@Table(name="filiere")
public class filiere implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFiliere;
	@Column(name = "nom",nullable = false)  
	private String nom;
	@Column(name = "abrv",nullable = false) 
	private String abreviation;
	
	@OneToMany(targetEntity=classe.class, mappedBy="filiere", cascade=CascadeType.REMOVE)
	private List<classe> listeClass;
	
	public filiere() {
		super();
	}


	public int getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	public List<classe> getListeClass() {
		return listeClass;
	}

	public void setListeClass(List<classe> listeClass) {
		this.listeClass = listeClass;
	}
	
	
	
	
}
