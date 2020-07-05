package com.miage.projet.dao;


import java.util.List;
import com.miage.projet.beans.horaire;

public interface horaireDAO {
	public String affiche();
	public int ajouter(List<horaire> f);
	public int modifier(horaire f);
	public String selectIdUpdate(int id);
	public int supprimer(int id);
}
