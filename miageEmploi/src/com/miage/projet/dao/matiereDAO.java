package com.miage.projet.dao;

import java.util.List;
import com.miage.projet.beans.matiere;
import com.miage.projet.beans.semestre;

public interface matiereDAO {
	public String affiche();
	public int ajouter(List<matiere> f);
	public semestre selectSemestre(int id);
	public String selectIdUpdate(int id);
	public String selectListSemestre();
	public int modifier(matiere f);
	public int supprimer(int id);
}
