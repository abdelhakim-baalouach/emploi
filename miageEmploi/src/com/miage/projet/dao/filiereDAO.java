package com.miage.projet.dao;

import java.util.List;
import com.miage.projet.beans.filiere;

public interface filiereDAO {
	public String affiche();
	public int ajouter(List<filiere> f);
	public String selectIdUpdate(int id);
	public int modifier(filiere f);
	public int supprimer(int id);
}
