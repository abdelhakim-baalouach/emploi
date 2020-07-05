package com.miage.projet.dao;

import java.util.List;

import com.miage.projet.beans.classe;
import com.miage.projet.beans.seance;

public interface dashboardDAO {
	public String selectClasse();
	public String affiche(List<seance> c);
	public List<seance> findClasse(int id);
	public classe findClasseUser(int id);
	public List<seance> findSeanceProf(int id);
}
