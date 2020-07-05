package com.miage.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.miage.projet.beans.salle;

import config.HibernateUtil;

public class salleDAOImp implements salleDAO {

	@Override
	public String affiche() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			List<salle> salle = session.createQuery("from salle", salle.class).getResultList();
			
			for(com.miage.projet.beans.salle item : salle){
				html += "<tr><td>"+item.getIdSalle()+"</td>";
				html += "<td>"+item.getNum()+"</td>";
				html += "<td>"+item.getEtage()+"</td>";
				html += "<td>"+item.getType()+"</td>";
				html += "<td>"
						+"<div class='btn-group dropdown center-block'>"
							+"<a href='javascript: void(0);' class='table-action-btn dropdown-toggle arrow-none btn btn-light btn-sm' data-toggle='dropdown' aria-expanded='false'>"
								+ "<i class='mdi mdi-dots-horizontal'></i>"
							+"</a>"
									+ "<div class='dropdown-menu dropdown-menu-right'>"
										+ "<a class='dropdown-item modifier' href='#' data-toggle='modal' data-update='"+item.getIdSalle()+"' data-target='#Modifier'>"
											+ "<i class='mdi mdi-pencil mr-2 text-muted font-18 vertical-middle'></i>Modifier"
										+"</a>"
										+"<a class='dropdown-item delete' href='#'  data-delete='"+item.getIdSalle()+"' data-toggle='modal' data-target='#supprimer'>" 
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
	public int ajouter(List<salle> f) {
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
	public String selectIdUpdate(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			salle s = session.get(salle.class, id);
			String html = s.getIdSalle()+"/"+s.getNum()+"/"+s.getEtage()+"/"+s.getType();
			session.close();
			return html;
		} finally {
			session.close();
		}
	}

	@Override
	public int modifier(salle f) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(f);
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
			salle s = (salle) session.get(salle.class, id);
			session.delete(s);
			session.getTransaction().commit();
			session.close();
			return 1;
		} finally {
			session.close();
		}
	}

}
