package com.miage.projet.beans;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="matiere")
public class matiere implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMatiere;
	@Column(name = "nom",nullable = false)
	private String nom;
	@Column(name = "abrv",nullable = false)
	private String abreviation;
	
	@ManyToOne
	@JoinColumn(name="idSemestre")
	private semestre semestre;
	
	@OneToMany(targetEntity=seance.class, mappedBy="matiere", cascade=CascadeType.REMOVE)
	private List<seance> ListSeance;
	
	public matiere() {
		super();
	}
	public int getIdMatiere() {
		return idMatiere;
	}
	public String getNom() {
		return nom;
	}
	public String getAbreviation() {
		return abreviation;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
	public semestre getSemestre() {
		return semestre;
	}
	public void setSemestre(semestre semestre) {
		this.semestre = semestre;
	}
	public List<seance> getListSeance() {
		return ListSeance;
	}
	public void setListSeance(List<seance> listSeance) {
		ListSeance = listSeance;
	}
}
