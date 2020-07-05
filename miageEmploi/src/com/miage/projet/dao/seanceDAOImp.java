package com.miage.projet.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miage.projet.beans.classe;
import com.miage.projet.beans.horaire;
import com.miage.projet.beans.matiere;
import com.miage.projet.beans.salle;
import com.miage.projet.beans.seance;
import com.miage.projet.beans.utilisateur;

import config.HibernateUtil;

public class seanceDAOImp implements seanceDAO {

	@Override
	public String affiche() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			List<seance> seance = session.createQuery("from seance", seance.class).getResultList();
			
			for(com.miage.projet.beans.seance item : seance){
				html += "<tr><td>"+item.getIdSeance()+"</td>";
				html += "<td>"+item.getClasse().getFiliere().getAbreviation() +"-"+item.getClasse().getAbreviation()+"</td>";
				html += "<td>"+item.getProfesseur().getNom() +" "+item.getProfesseur().getPrenom()+"</td>";
				html += "<td>"+item.getSalle().getEtage()+item.getSalle().getNum()+"-"+item.getSalle().getType()+"</td>";
				html += "<td>"+item.getMatiere().getNom()+"</td>";
				html += "<td>"+item.getHoraire().getHeureDebut()+"-"+item.getHoraire().getHeureFin()+" "+item.getHoraire().getJour() +"</td>";
				html += "<td>"
						+"<div class='btn-group dropdown center-block'>"
							+"<a href='javascript: void(0);' class='table-action-btn dropdown-toggle arrow-none btn btn-light btn-sm' data-toggle='dropdown' aria-expanded='false'>"
								+ "<i class='mdi mdi-dots-horizontal'></i>"
							+"</a>"
									+ "<div class='dropdown-menu dropdown-menu-right'>"
										+ "<a class='dropdown-item modifier' href='#' data-toggle='modal' data-update='"+item.getIdSeance()+"' data-target='#Modifier'>"
											+ "<i class='mdi mdi-pencil mr-2 text-muted font-18 vertical-middle'></i>Modifier"
										+"</a>"
										+"<a class='dropdown-item delete' href='#'  data-delete='"+item.getIdSeance()+"' data-toggle='modal' data-target='#supprimer'>" 
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
	public int ajouter(List<seance> f) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			for(int i = 0; i < f.size(); i++) {
				session.beginTransaction();
				session.save(f.get(i));
				session.getTransaction().commit();
			}
		
			return 1;
		} catch (Exception e) {
			return 0;
		} finally {
			session.close();
		}
	}
	
	

	@Override
	public String selectIdUpdate(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			seance h = session.get(seance.class, id);
			String html = h.getIdSeance() +"/"+h.getProfesseur().getIdUser() +"/"+h.getSalle().getIdSalle() +"/"
				+h.getClasse().getIdClass()+"/"+h.getMatiere().getIdMatiere() +"/"+ h.getHoraire().getIdHoraire();
			session.close();
			return html;
		} finally {
			session.close();
		}
	}

	@Override
	public int modifier(seance f) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.merge(f);
			session.getTransaction().commit();
			session.close();
		
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
			seance h = (seance) session.get(seance.class, id);
			session.delete(h);
			session.getTransaction().commit();
			session.close();
			return 1;
		} finally {
			session.close();
		}
	}

	@Override
	public salle findSalle(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			salle h = session.find(salle.class, id);
			session.getTransaction().commit();
			session.close();
			return h;
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
		} finally {
			session.close();
		}
	}

	@Override
	public horaire findHoraire(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			horaire h = session.find(horaire.class, id);
			session.getTransaction().commit();
			session.close();
			return h;
		} finally {
			session.close();
		}
	}

	@Override
	public matiere findMatiere(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			matiere h = session.find(matiere.class, id);
			session.getTransaction().commit();
			session.close();
			return h;
		} finally {
			session.close();
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
		} finally {
			session.close();
		}
	}

	@Override
	public String selectListeSalle() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			List<salle> salle = session.createQuery("from salle", salle.class).getResultList();
			
			for(com.miage.projet.beans.salle item : salle){
				html += "<option value='"+item.getIdSalle()+"'>"+item.getEtage()+item.getNum()+"-"+item.getType()+"</option>";
			}
			session.close();
			return html;
		} finally {
			session.close();
		}
	}

	@Override
	public String selectListeProff() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			Query query = session.createQuery("from utilisateur WHERE type = :x");
			query.setParameter("x", "professeur");

			@SuppressWarnings("unchecked")
			List<utilisateur> user = query.getResultList();
			
			for(com.miage.projet.beans.utilisateur item : user){
				html += "<option value='"+item.getIdUser()+"'>"+item.getNom()+" "+item.getPrenom()+"</option>";
			}
			session.close();
			return html;
		} finally {
			session.close();
		}
	}

	@Override
	public String selectListeHoraire() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			List<horaire> horaire = session.createQuery("from horaire", horaire.class).getResultList();
			
			for(com.miage.projet.beans.horaire item : horaire){
				html += "<option value='"+item.getIdHoraire()+"'>"+item.getHeureDebut()+" "+item.getHeureFin()+"-"+item.getJour()+"</option>";
			}
			session.close();
			return html;
		} finally {
			session.close();
		}
	}

	@Override
	public String selectListeMatiere() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			List<matiere> matiere = session.createQuery("from matiere", matiere.class).getResultList();
			
			for(com.miage.projet.beans.matiere item : matiere){
				html += "<option value='"+item.getIdMatiere()+"'>"+item.getNom()+"</option>";
			}
			session.close();
			return html;
		} finally {
			session.close();
		}
	}

	@Override
	public String selectListeFiliere() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			List<classe> classe = session.createQuery("from classe", classe.class).getResultList();
			
			for(com.miage.projet.beans.classe item : classe){
				html += "<option value='"+item.getIdClass()+"'>"+item.getAbreviation()+"</option>";
			}
			session.close();
			return html;
		} finally {
			session.close();
		}
	}
	
	

}
