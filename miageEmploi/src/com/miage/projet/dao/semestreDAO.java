package com.miage.projet.dao;

import java.util.List;

import com.miage.projet.beans.semestre;

public interface semestreDAO {
	public String affiche();
	public int ajouter(List<semestre> f);
	public String selectIdUpdate(int id);
	public int modifier(semestre f);
	public int supprimer(int id);
}
