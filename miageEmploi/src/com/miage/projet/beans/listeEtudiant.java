package com.miage.projet.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="listEtudiant")
public class listeEtudiant implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLigne;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private utilisateur user;
	
	@ManyToOne
	@JoinColumn(name="idClass")
	private classe classe;
	

	public listeEtudiant() {
		super();
	}
	
	public listeEtudiant(int idLigne, utilisateur user) {
		super();
		this.idLigne = idLigne;
		this.user = user;
	}

	public int getIdLigne() {
		return idLigne;
	}

	public utilisateur getUser() {
		return user;
	}

	public void setUser(utilisateur user) {
		this.user = user;
	}

	public classe getClasse() {
		return classe;
	}

	public void setClasse(classe classe) {
		this.classe = classe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
