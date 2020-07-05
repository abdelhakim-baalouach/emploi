package com.miage.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miage.projet.beans.matiere;
import com.miage.projet.beans.semestre;

import config.HibernateUtil;

public class matiereDAOImp implements matiereDAO{

	@Override
	public String affiche() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			List<matiere> matiere = session.createQuery("from matiere", matiere.class).getResultList();
			
			for(com.miage.projet.beans.matiere item : matiere){
				html += "<tr><td>"+item.getIdMatiere()+"</td>";
				html += "<td>"+item.getNom()+"</td>";
				html += "<td>"+item.getAbreviation()+"</td>";
				html += "<td>"+item.getSemestre().getNom()+"</td>";
				html += "<td>"
						+"<div class='btn-group dropdown center-block'>"
							+"<a href='javascript: void(0);' class='table-action-btn dropdown-toggle arrow-none btn btn-light btn-sm' data-toggle='dropdown' aria-expanded='false'>"
								+ "<i class='mdi mdi-dots-horizontal'></i>"
							+"</a>"
									+ "<div class='dropdown-menu dropdown-menu-right'>"
										+ "<a class='dropdown-item modifier' href='#' data-toggle='modal' data-update='"+item.getIdMatiere()+"' data-target='#Modifier'>"
											+ "<i class='mdi mdi-pencil mr-2 text-muted font-18 vertical-middle'></i>Modifier"
										+"</a>"
										+"<a class='dropdown-item delete' href='#'  data-delete='"+item.getIdMatiere()+"' data-toggle='modal' data-target='#supprimer'>" 
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
	public int ajouter(List<matiere> f) {
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
	public semestre selectSemestre(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			semestre h = session.find(semestre.class, id);
			session.getTransaction().commit();
			session.close();
			return h;
		} finally {
			session.close();
		}
	}

	@Override
	public String selectListSemestre() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			List<semestre> semestre = session.createQuery("from semestre", semestre.class).getResultList();
			
			for(com.miage.projet.beans.semestre item : semestre){
				html += "<option value=\""+item.getIdSemestre()+"\">"+item.getNom()+"</option>";
			}
			session.close();
			return html;
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
			matiere h = session.get(matiere.class, id);
			String html = h.getIdMatiere() +"/"+h.getNom() +"/"+h.getAbreviation() +"/"+h.getSemestre().getIdSemestre();
			session.close();
			return html;
		} finally {
			session.close();
		}
	}

	@Override
	public int modifier(matiere f) {
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
			matiere h = (matiere) session.get(matiere.class, id);
			session.delete(h);
			session.getTransaction().commit();
			session.close();
			return 1;
		} finally {
			session.close();
		}
	}

}
