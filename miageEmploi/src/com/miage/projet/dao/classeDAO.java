package com.miage.projet.dao;

import java.util.List;

import com.miage.projet.beans.classe;
import com.miage.projet.beans.filiere;

public interface classeDAO {
	public String affiche();
	public int ajouter(List<classe> f);
	public String selectListFiliere();
	public String selectIdUpdate(int id);
	public int modifier(classe f);
	public int supprimer(int id);
	public filiere selectFiliere(int id);
}
