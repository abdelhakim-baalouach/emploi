package com.miage.projet.beans;

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
@Table(name="horaire")
public class horaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHoraire;
	@Column(name = "heureDebut")
	private String heureDebut;
	@Column(name = "heureFin")
	private String heureFin; 
	@Column(name = "jour")
	private String jour;

	@OneToMany(targetEntity=seance.class, mappedBy="horaire", cascade=CascadeType.REMOVE)
	private List<seance> ListSeance;

	public horaire() {
		super();
	}
	public int getIdHoraire() {
		return idHoraire;
	}
	public void setIdHoraire(int idHoraire) {
		this.idHoraire = idHoraire;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public List<seance> getListSeance() {
		return ListSeance;
	}
	public void setListSeance(List<seance> listSeance) {
		ListSeance = listSeance;
	}
	
	
}
