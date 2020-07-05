package com.miage.projet.dao;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miage.projet.beans.utilisateur;

import config.HibernateUtil;

public class utilisateurDAOImp implements utilisateurDAO {
	@Override
	public utilisateur authentification(utilisateur u) {
		utilisateur user = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("FROM utilisateur WHERE login = :login and password = :pass");
			query.setParameter("login", u.getLogin());
			query.setParameter("pass", u.getPassword());
			if(!query.getResultList().isEmpty()) {
				user = (utilisateur) query.getResultList().get(0);
				session.close();
			}
		} catch (Exception e) {
			return null;
		}
		return user;
	}
	
	@Override
	public String affiche(String type) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String html ="";
			session.beginTransaction();
			Query query = session.createQuery("from utilisateur WHERE type = :x");
			query.setParameter("x", type);
			@SuppressWarnings("unchecked")
			List<utilisateur> utilisateur = query.getResultList();
			
			for(com.miage.projet.beans.utilisateur item : utilisateur){
				html += "<tr><td>"+item.getIdUser()+"</td>";
				html += "<td>"+item.getLogin()+"</td>";
				html += "<td>"+item.getNom() +" "+ item.getPrenom()+"</td>";
				html += "<td>"+item.getEmail()+"</td>";
				html += "<td>"+item.getTelephone()+"</td>";
				html += "<td>"
						+"<div class='btn-group dropdown center-block'>"
							+"<a href='javascript: void(0);' class='table-action-btn dropdown-toggle arrow-none btn btn-light btn-sm' data-toggle='dropdown' aria-expanded='false'>"
								+ "<i class='mdi mdi-dots-horizontal'></i>"
							+"</a>"
									+ "<div class='dropdown-menu dropdown-menu-right'>"
										+ "<a class='dropdown-item modifier' href='#' data-toggle='modal' data-update='"+item.getIdUser()+"' data-target='#Modifier'>"
											+ "<i class='mdi mdi-pencil mr-2 text-muted font-18 vertical-middle'></i>Modifier"
										+"</a>"
										+"<a class='dropdown-item delete' href='#'  data-delete='"+item.getIdUser()+"' data-toggle='modal' data-target='#supprimer'>" 
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
	public int ajouter(utilisateur f) {
		try {
			System.out.println("ok");
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.save(f);
			session.getTransaction().commit();
			session.close();
			return 1;
		} catch (Exception e) {
			return 0;
		}	
	}

	@Override
	public int modifier(utilisateur f) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
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
	public utilisateur find(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			utilisateur h = (utilisateur) session.get(utilisateur.class, id);
			session.getTransaction().commit();
			session.close();
			return h;
		} finally {
			session.close();
		}
	}

	@Override
	public int supprimer(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			utilisateur h = (utilisateur) session.get(utilisateur.class, id);
			session.delete(h);
			session.getTransaction().commit();
			session.close();
			return 1;
		} finally {
			session.close();
		}
	}

	@Override
	public void send(String from,String to,String Subject, String body,String p) {
		String username = from;
		String password = p;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		javax.mail.Session session = javax.mail.Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			message.setSubject(Subject); // subject line
			message.setContent(body, "text/html; charset=UTF-8");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public String validLogin(String s) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			utilisateur user = (utilisateur) 
										session.createQuery("from utilisateur WHERE login = :x")
											.setParameter("x", s)
												.uniqueResult();
			session.getTransaction().commit();
			session.close();
			if (user == null) {
				return "true";
			} else {
				return "false";
			}
		} finally {
			session.close();
		}
	}

	@Override
	public String generate(int length){
		String chars = "abcdefghijklmnopqrstuvwxyz/@#&(-_)[{}]ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    String pass = "";
	    for(int x=0;x<length;x++){
	    	int i = (int)Math.floor(Math.random() * 62);
		    pass += chars.charAt(i);
		}
		return pass;
	}

	@Override
	public String bodyCreation(utilisateur u) {
		String body = "<body style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; width: 100% !important; height: 100%; line-height: 1.6em; background-color: #f6f6f6; margin: 0;\"\r\n" + 
				"bgcolor=\"#f6f6f6\">\r\n" + 
				"\r\n" + 
				"<table class=\"body-wrap\"\r\n" + 
				"style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; width: 100%; background-color: #f6f6f6; margin: 0;\"\r\n" + 
				"bgcolor=\"#f6f6f6\">\r\n" + 
				"<tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"<td style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0;\"\r\n" + 
				"    valign=\"top\"></td>\r\n" + 
				"<td class=\"container\" width=\"600\"\r\n" + 
				"    style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; display: block !important; max-width: 600px !important; clear: both !important; margin: 0 auto;\"\r\n" + 
				"    valign=\"top\">\r\n" + 
				"    <div class=\"content\"\r\n" + 
				"         style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; max-width: 600px; display: block; margin: 0 auto; padding: 20px;\">\r\n" + 
				"        <table class=\"main\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"" + 
				"               style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; border-radius: 3px; margin: 0; border: none;\"\r\n" + 
				"               >\r\n" + 
				"            <tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"                <td class=\"content-wrap\"\r\n" + 
				"                    style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0;padding: 30px;border: 3px solid #777edd;border-radius: 7px; background-color: #fff;\"\r\n" + 
				"                    valign=\"top\">\r\n" + 
				"                    <meta itemprop=\"name\" content=\"Confirm Email\"\r\n" + 
				"                          style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\"/>\r\n" + 
				"                    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"\r\n" + 
				"                           style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"                        <tr>\r\n" + 
				"                            <td style=\"text-align: center\">\r\n" + 
				"                                <a href=\"#\" style=\"display: block;margin-bottom: 10px;\"><img src='https://www.clubs-etudiants.ma/wp-content/uploads/2018/04/IGA-couleurs-600x283.png' height=\"80\"><h2><b>IGA Emploi Du Temps</b></h2></a> <br/>\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                        <tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"                            <td class=\"content-block\"\r\n" + 
				"                                style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 0 0 20px;\"\r\n" + 
				"                                valign=\"top\">\r\n" + 
				"                                Bonjour <b>"+u.getPrenom()+" "+u.getNom()+".</b>\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                        <tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"                            <td class=\"content-block\"\r\n" + 
				"                                style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 0 0 20px;\"\r\n" + 
				"                                valign=\"top\">\r\n" + 
				"                                <p>Dans le cadre de la gestion des emploi du temps dans notre école, on a mis a votre disposition une application qui gère les emploi du temps (Etudiants, Professeurs).</p>\r\n" + 
				"                                <p>Vous trouverez ci joint votre Login et mot de passe pour y accéder.</p>\r\n" + 
				"                                <p><b><u>Login</u> : "+u.getLogin()+"</b></p>\r\n" + 
				"                                <p><b><u>Mot de passe</u> :"+u.getPassword()+"</b> </p>\r\n" + 
				"\r\n" + 
				"                                \r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                        <tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"                            <td class=\"content-block\"\r\n" + 
				"                                style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 0 0 20px;\"\r\n" + 
				"                                valign=\"top\">\r\n" + 
				"                                <p>Merci pour votre attention.</p>\r\n" + 
				"                                <p>L'administration.</p>\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                    </table>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"        </table>\r\n" + 
				"    </div>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</table>\r\n" + 
				"</body>";
		return body;
	}

	@Override
	public String bodyPassword(utilisateur u) {
		String body = "<body style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; width: 100% !important; height: 100%; line-height: 1.6em; background-color: #f6f6f6; margin: 0;\"\r\n" + 
				"bgcolor=\"#f6f6f6\">\r\n" + 
				"\r\n" + 
				"<table class=\"body-wrap\"\r\n" + 
				"style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; width: 100%; background-color: #f6f6f6; margin: 0;\"\r\n" + 
				"bgcolor=\"#f6f6f6\">\r\n" + 
				"<tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"<td style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0;\"\r\n" + 
				"    valign=\"top\"></td>\r\n" + 
				"<td class=\"container\" width=\"600\"\r\n" + 
				"    style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; display: block !important; max-width: 600px !important; clear: both !important; margin: 0 auto;\"\r\n" + 
				"    valign=\"top\">\r\n" + 
				"    <div class=\"content\"\r\n" + 
				"         style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; max-width: 600px; display: block; margin: 0 auto; padding: 20px;\">\r\n" + 
				"        <table class=\"main\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"" + 
				"               style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; border-radius: 3px; margin: 0; border: none;\"\r\n" + 
				"               >\r\n" + 
				"            <tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"                <td class=\"content-wrap\"\r\n" + 
				"                    style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0;padding: 30px;border: 3px solid #777edd;border-radius: 7px; background-color: #fff;\"\r\n" + 
				"                    valign=\"top\">\r\n" + 
				"                    <meta itemprop=\"name\" content=\"Confirm Email\"\r\n" + 
				"                          style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\"/>\r\n" + 
				"                    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"\r\n" + 
				"                           style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"                        <tr>\r\n" + 
				"                            <td style=\"text-align: center\">\r\n" + 
				"                                <a href=\"#\" style=\"display: block;margin-bottom: 10px;\"><img src='https://www.clubs-etudiants.ma/wp-content/uploads/2018/04/IGA-couleurs-600x283.png' height=\"80\"><h2><b>IGA Emploi Du Temps</b></h2></a> <br/>\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                        <tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"                            <td class=\"content-block\"\r\n" + 
				"                                style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 0 0 20px;\"\r\n" + 
				"                                valign=\"top\">\r\n" + 
				"                                Bonjour <b>"+u.getNom()+" "+u.getPrenom()+"</b>.\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                        <tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"                            <td class=\"content-block\"\r\n" + 
				"                                style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 0 0 20px;\"\r\n" + 
				"                                valign=\"top\">\r\n" + 
				"                                <p>Vous trouverez ci joint votre nouveau mot de passe pour y accéder.</p>\r\n" + 
				"                                <p><b><u>Mot de passe</u>: "+u.getPassword()+"</b></p>\r\n" + 
				"\r\n" + 
				"                                \r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                        <tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\r\n" + 
				"                            <td class=\"content-block\"\r\n" + 
				"                                style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 0 0 20px;\"\r\n" + 
				"                                valign=\"top\">\r\n" + 
				"                                <p>Merci pour votre attention.</p>\r\n" + 
				"                                <p>L'administration.</p>\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                    </table>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"        </table>\r\n" + 
				"    </div>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</table>\r\n" + 
				"</body>";
		return body;
	}

}
