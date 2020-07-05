package com.miage.projet.dao;

import java.util.List;

import com.miage.projet.beans.classe;
import com.miage.projet.beans.listeEtudiant;
import com.miage.projet.beans.utilisateur;

public interface listeEtudiantDAO {
	public String affiche(int id);
	public String selectListEtudiant();
	public int ajouter(List<listeEtudiant> f);
	public int supprimer(int id);
	public utilisateur findUser(int id);
	public classe findClasse(int id);
}
