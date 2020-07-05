package com.miage.projet.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="seance")
public class seance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSeance;
	
	@ManyToOne
	@JoinColumn(name="idSalle")
	private salle salle;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private utilisateur professeur;
	
	@ManyToOne
	@JoinColumn(name="idHoraire")
	private horaire horaire;
	
	@ManyToOne
	@JoinColumn(name="idMatiere")
	private matiere matiere;
	
	@ManyToOne
	@JoinColumn(name="idClass")
	private classe classe;

	
	public seance() {
		super();
	}

	public int getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public salle getSalle() {
		return salle;
	}

	public void setSalle(salle salle) {
		this.salle = salle;
	}

	public utilisateur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(utilisateur professeur) {
		this.professeur = professeur;
	}

	public horaire getHoraire() {
		return horaire;
	}

	public void setHoraire(horaire horaire) {
		this.horaire = horaire;
	}

	public matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(matiere matiere) {
		this.matiere = matiere;
	}

	public classe getClasse() {
		return classe;
	}

	public void setClasse(classe classe) {
		this.classe = classe;
	}

}
