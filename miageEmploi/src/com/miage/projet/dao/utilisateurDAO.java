package com.miage.projet.dao;

import com.miage.projet.beans.utilisateur;

public interface utilisateurDAO {
	public utilisateur authentification(utilisateur u);
	public String validLogin(String s); 
	public String affiche(String type);
	public int ajouter(utilisateur f);
	public int modifier(utilisateur id);
	public utilisateur find(int id);
	public int supprimer(int id);
	public void send(String from,String to,String Subject, String body,String p);
	public String generate(int taille);
	public String bodyCreation(utilisateur u);
	public String bodyPassword(utilisateur u);
}
