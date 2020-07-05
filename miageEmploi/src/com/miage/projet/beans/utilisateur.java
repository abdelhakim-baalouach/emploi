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
@Table(name="utilisateur")
public class utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	@Column(name = "login",nullable = false,unique = true)  
	private String login;
	@Column(name = "password",nullable = false)  
	private String password;
	@Column(name = "nom",nullable = false)  
	private String nom;
	@Column(name = "prenom",nullable = false)  
	private String prenom;
	@Column(name = "email",nullable = false)  
	private String email;
	@Column(name = "telephone",nullable = false)  
	private String telephone;
	@Column(name = "type",nullable = false)  
	private String type;

	@OneToMany(targetEntity=seance.class, mappedBy="professeur", cascade=CascadeType.REMOVE)
	private List<seance> ListSeance;
	
	@OneToMany(targetEntity=listeEtudiant.class, mappedBy="user", cascade=CascadeType.REMOVE)
	private List<listeEtudiant> listEtudiant;
	
	public utilisateur() {
		super();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public List<seance> getListSeance() {
		return ListSeance;
	}

	public void setListSeance(List<seance> listSeance) {
		ListSeance = listSeance;
	}

	public List<listeEtudiant> getListEtudiant() {
		return listEtudiant;
	}

	public void setListEtudiant(List<listeEtudiant> listEtudiant) {
		this.listEtudiant = listEtudiant;
	}
	
	
	
}
