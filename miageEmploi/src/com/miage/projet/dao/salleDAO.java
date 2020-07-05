package com.miage.projet.dao;

import java.util.List;

import com.miage.projet.beans.salle;

public interface salleDAO {
	public String affiche();
	public int ajouter(List<salle> f);
	public String selectIdUpdate(int id);
	public int modifier(salle f);
	public int supprimer(int id);
}
