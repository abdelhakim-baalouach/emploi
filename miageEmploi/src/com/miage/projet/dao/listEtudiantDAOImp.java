package com.miage.projet.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miage.projet.beans.classe;
import com.miage.projet.beans.listeEtudiant;
import com.miage.projet.beans.utilisateur;

import config.HibernateUtil;

public class listEtudiantDAOImp implements listeEtudiantDAO {

	@Override
	public String affiche(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			Query query = session.createQuery("from listeEtudiant WHERE idClass = :x");
			query.setParameter("x", id);
			@SuppressWarnings("unchecked")
			List<listeEtudiant> liste = query.getResultList();
			
			for(com.miage.projet.beans.listeEtudiant item : liste){
				html += "<tr><td>"+item.getIdLigne()+"</td>";
				html += "<td>"+item.getUser().getNom()+"</td>";
				html += "<td>"+item.getUser().getPrenom()+"</td>";
				html += "<td>"+item.getUser().getEmail()+"</td>";
				html += "<td>"
						+"<div class='btn-group dropdown center-block'>"
							+"<a href='javascript: void(0);' class='table-action-btn dropdown-toggle arrow-none btn btn-light btn-sm' data-toggle='dropdown' aria-expanded='false'>"
								+ "<i class='mdi mdi-dots-horizontal'></i>"
							+"</a>"
									+ "<div class='dropdown-menu dropdown-menu-right'>"
										+"<a class='dropdown-item delete' href='#'  data-delete='"+item.getIdLigne()+"' data-toggle='modal' data-target='#supprimer'>" 
											+"<i class='mdi mdi-delete mr-2 text-muted font-18 vertical-middle'></i>Supprimer"
										+"</a>"
									+ "</div>"
							+ "</div>"
						+ "</td>"
					+ "</tr>";
			}
			session.close();
			return html;
		} finally {
			session.close();
		}
	}

	
	@Override
	public String selectListEtudiant() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();							
			Query query = session.createQuery("from utilisateur WHERE type = :x");
			query.setParameter("x", "etudiant");
			@SuppressWarnings("unchecked")
			List<utilisateur> liste = query.getResultList();
			
			for(com.miage.projet.beans.utilisateur item : liste){
				html += "<option value=\""+item.getIdUser()+"\">"+item.getNom()+" "+item.getPrenom()+"</option>";
			}
			session.close();
			return html;
		} finally {
			session.close();
		}
	}


	@Override
	public int ajouter(List<listeEtudiant> f) {
		try {
			for(int i = 0; i < f.size(); i++) {
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				
				session.save(f.get(i));
				session.getTransaction().commit();
				session.close();
			}
		
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}


	@Override
	public int supprimer(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			listeEtudiant h = (listeEtudiant) session.get(listeEtudiant.class, id);
			session.delete(h);
			session.getTransaction().commit();
			session.close();
			return 1;
		} finally {
			session.close();
		}
	}


	@Override
	public utilisateur findUser(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			utilisateur h = session.find(utilisateur.class, id);
			session.getTransaction().commit();
			session.close();
			return h;
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public classe findClasse(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			classe h = session.find(classe.class, id);
			session.getTransaction().commit();
			session.close();
			return h;
		} catch (Exception e) {
			return null;
		}
	}
	
	

}
