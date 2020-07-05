package com.miage.projet.beans;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classe")
public class classe implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClass;
	@Column(name = "nom",nullable = false)  
	private String nom;
	@Column(name = "abrv",nullable = false)  
	private String abreviation;
	@Column(name = "niveau",nullable = false)  
	private int niveau;
	
	@ManyToOne
	@JoinColumn(name="idFiliere")
	private filiere filiere;
	
	@OneToMany(targetEntity=listeEtudiant.class, mappedBy="classe", cascade=CascadeType.REMOVE)
	private List<listeEtudiant> listeEtudiants;
	
	@OneToMany(fetch = FetchType.EAGER, targetEntity=seance.class, mappedBy="classe", cascade=CascadeType.REMOVE)
	private List<seance> ListSeance;
	
	
	public classe() {
		super();
	}
	public int getIdClass() {
		return idClass;
	}
	
	public void setIdClass(int idClass) {
		this.idClass = idClass;
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
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(filiere filiere) {
		this.filiere = filiere;
	}
	public List<listeEtudiant> getListeEtudiants() {
		return listeEtudiants;
	}
	public void setListeEtudiants(List<listeEtudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}
	public List<seance> getListSeance() {
		return ListSeance;
	}
	public void setListSeance(List<seance> listSeance) {
		ListSeance = listSeance;
	}
	
}
