package com.miage.projet.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miage.projet.beans.classe;
import com.miage.projet.beans.seance;

import config.HibernateUtil;

public class dashboardDAOImp implements dashboardDAO {

	@Override
	public String selectClasse() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			List<classe> classe = session.createQuery("from classe", classe.class).getResultList();
			
			for(com.miage.projet.beans.classe item : classe){
				html += "<option value=\""+item.getIdClass()+"\">"+item.getAbreviation()+"</option>";
			}
			session.close();
			return html;
		} finally {
			session.close();
		}
	}

	@Override
	public String affiche(List<seance> c) {
		String html = "";
		Date date = java.sql.Date.valueOf( LocalDate.now() );
		Date min =null;
		Date max =null;
		
		String[] jour = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
		String[][] emploi = new String[6][6];
		int i = 0;
		for(String str : jour){
			emploi[i][0] = "<td>"+str.toLowerCase().trim()+"</td>";
			for (seance item : c) {
				min = item.getMatiere().getSemestre().getMoisDebut();
			    max = item.getMatiere().getSemestre().getMoisFin();
			    if (date.before(max) && date.after(min)) {
			    	if (str.toLowerCase().trim().equals(item.getHoraire().getJour().toLowerCase().trim())) {
			    		if (item.getHoraire().getHeureDebut().trim().equals("08:30") && item.getHoraire().getHeureFin().trim().equals("10:15")) {
			    			emploi[i][1] = "<td>"+item.getClasse().getAbreviation()+"<br>"+item.getMatiere().getNom()+"<br>"+item.getProfesseur().getNom()+" "+item.getProfesseur().getPrenom()+" - "+item.getSalle().getNum()+item.getSalle().getEtage()+"</td>";	
						}else if (item.getHoraire().getHeureDebut().trim().equals("10:30") && item.getHoraire().getHeureFin().trim().equals("11:45")) {
							emploi[i][2] = "<td>"+item.getClasse().getAbreviation()+"<br>"+item.getMatiere().getNom()+"<br>"+item.getProfesseur().getNom()+" "+item.getProfesseur().getPrenom()+" - "+item.getSalle().getNum()+item.getSalle().getEtage()+"</td>";	
						}else if (item.getHoraire().getHeureDebut().trim().equals("12:00") && item.getHoraire().getHeureFin().trim().equals("13:30")) {
							emploi[i][3] = "<td>"+item.getClasse().getAbreviation()+"<br>"+item.getMatiere().getNom()+"<br>"+item.getProfesseur().getNom()+" "+item.getProfesseur().getPrenom()+" - "+item.getSalle().getNum()+item.getSalle().getEtage()+"</td>";	
						}else if (item.getHoraire().getHeureDebut().trim().equals("14:15") && item.getHoraire().getHeureFin().trim().equals("15:45")) {
							emploi[i][4] = "<td>"+item.getClasse().getAbreviation()+"<br>"+item.getMatiere().getNom()+"<br>"+item.getProfesseur().getNom()+" "+item.getProfesseur().getPrenom()+" - "+item.getSalle().getNum()+item.getSalle().getEtage()+"</td>";	
						}else if (item.getHoraire().getHeureDebut().trim().equals("16:00") && item.getHoraire().getHeureFin().trim().equals("17:30")) {
							emploi[i][5] = "<td>"+item.getClasse().getAbreviation()+"<br>"+item.getMatiere().getNom()+"<br>"+item.getProfesseur().getNom()+" "+item.getProfesseur().getPrenom()+" - "+item.getSalle().getNum()+item.getSalle().getEtage()+"</td>";	
						}
					}
			    }
			}
			i++;
		}
		
		for (i = 0;i < emploi.length; i++) {
			 html +="<tr>";
	         for (int j = 0;j < emploi[i].length;j++) {
	        	if ( emploi[i][j] != null) {
	        		 html += emploi[i][j];
				}else {
					html +="<td></td>";
				}
	         }
	         html +="</tr>";
	      }
		
		
		return html;	
	}

	@Override
	public List<seance> findClasse(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			
			String hql = "from seance where idClass = :id ";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			
			@SuppressWarnings("unchecked")
			List<seance> list = query.getResultList();
			
			session.getTransaction().commit();
			session.close();
			return list;
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<seance> findSeanceProf(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			
			String hql = "select s from seance s ,utilisateur u"
					+ " WHERE s.professeur= u.idUser and u.idUser = :id";
			
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			
			@SuppressWarnings("unchecked")
			List<seance> list = query.getResultList();
			
			session.getTransaction().commit();
			session.close();
			return list;
		} finally {
			session.close();
		}
	}

	@Override
	public classe findClasseUser(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			
			String hql = "select c from classe c ,listeEtudiant l ,utilisateur u "
					+ " where c.idClass = l.classe and l.user = u.idUser and u.idUser = :id order by c.idClass ASC";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.setMaxResults(1);
			
			@SuppressWarnings("unchecked")
			classe classe = ((org.hibernate.query.Query<com.miage.projet.beans.classe>) query).uniqueResult(); ;
			session.getTransaction().commit();
			
			return classe;
		} finally {
			session.close();
		}
	}
	
	
}
