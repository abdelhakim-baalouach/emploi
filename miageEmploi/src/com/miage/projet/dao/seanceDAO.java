package com.miage.projet.dao;

import java.util.List;

import com.miage.projet.beans.classe;
import com.miage.projet.beans.horaire;
import com.miage.projet.beans.matiere;
import com.miage.projet.beans.salle;
import com.miage.projet.beans.seance;
import com.miage.projet.beans.utilisateur;

public interface seanceDAO {
	public String affiche();
	public int ajouter(List<seance> f);
	public String selectIdUpdate(int id);
	public int modifier(seance f);
	public int supprimer(int id);
	public salle findSalle(int id);
	public utilisateur findUser(int id);
	public horaire findHoraire(int id);
	public matiere findMatiere(int id);
	public classe findClasse(int id);
	public String selectListeSalle();
	public String selectListeProff();
	public String selectListeHoraire();
	public String selectListeMatiere();
	public String selectListeFiliere();
}
