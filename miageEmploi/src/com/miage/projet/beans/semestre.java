package com.miage.projet.beans;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="semestre")
public class semestre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSemestre;
	@Column(name = "nom",nullable = false)
	private String nom;
	@Column(name = "moisDebut",nullable = false)
	private Date moisDebut;
	@Column(name = "moisFin",nullable = false)
	private Date moisFin;
	
	@OneToMany(targetEntity=matiere.class, mappedBy="semestre", cascade=CascadeType.REMOVE)
	private List<matiere> listeMatiere;
	
	public semestre() {
		super();
	}

	public semestre(int idSemestre, String nom, Date moisDebut, Date moisFin) {
		super();
		this.idSemestre = idSemestre;
		this.nom = nom;
		this.moisDebut = moisDebut;
		this.moisFin = moisFin;
	}

	public long getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(Integer idSemestre) {
		this.idSemestre = idSemestre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getMoisDebut() {
		return moisDebut;
	}

	public void setMoisDebut(Date moisDebut) {
		this.moisDebut = moisDebut;
	}

	public Date getMoisFin() {
		return moisFin;
	}

	public void setMoisFin(Date moisFin) {
		this.moisFin = moisFin;
	}

	public List<matiere> getListeMatiere() {
		return listeMatiere;
	}

	public void setListeMatiere(List<matiere> listeMatiere) {
		this.listeMatiere = listeMatiere;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}
}
