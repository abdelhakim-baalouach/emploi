package com.miage.projet.web;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miage.projet.beans.classe;
import com.miage.projet.beans.filiere;
import com.miage.projet.beans.horaire;
import com.miage.projet.beans.listeEtudiant;
import com.miage.projet.beans.matiere;
import com.miage.projet.beans.salle;
import com.miage.projet.beans.seance;
import com.miage.projet.beans.semestre;
import com.miage.projet.beans.utilisateur;
import com.miage.projet.dao.classeDAOImp;
import com.miage.projet.dao.dashboardDAOImp;
import com.miage.projet.dao.filiereDAOImp;
import com.miage.projet.dao.horaireDAOImp;
import com.miage.projet.dao.listEtudiantDAOImp;
import com.miage.projet.dao.matiereDAOImp;
import com.miage.projet.dao.salleDAOImp;
import com.miage.projet.dao.seanceDAOImp;
import com.miage.projet.dao.semestreDAOImp;
import com.miage.projet.dao.utilisateurDAOImp;

/**
 * Servlet implementation class authentification
 */
@WebServlet("/authentification")
public class authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		/**
		 * authentification
		 */
		
		if(path.equals("/index.html")){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		/**
		 * dashboard.html
		 */
		
		if (path.equals("/admin/dashboard.html")) {
			dashboardDAOImp dao = new dashboardDAOImp();
			request.getSession().setAttribute("select", dao.selectClasse());
			request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
		} else if (path.equals("/admin/index.html")) {
			dashboardDAOImp dao = new dashboardDAOImp();
			request.getSession().setAttribute("select", dao.selectClasse());
			request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
		}else if (path.equals("/user/dashboard.html")) {
			
			HttpSession session = request.getSession();
	        utilisateur user = (utilisateur) session.getAttribute( "user" );
	        
	        dashboardDAOImp dao = new dashboardDAOImp();
	        classe c = dao.findClasseUser((int) user.getIdUser());
	        System.out.println(c.getAbreviation());
	        List<seance> se = dao.findClasse(c.getIdClass());
			
	        request.getSession().setAttribute("emploi", dao.affiche(se));
			request.getRequestDispatcher("/user/dashboard.jsp").forward(request, response);
		} else if (path.equals("/user/index.html")) {
			HttpSession session = request.getSession();
	        utilisateur user = (utilisateur) session.getAttribute( "user" );
	        
	        dashboardDAOImp dao = new dashboardDAOImp();
	        classe c = dao.findClasseUser((int) user.getIdUser());
	        List<seance> se = dao.findClasse(c.getIdClass());
			
	        request.getSession().setAttribute("emploi", dao.affiche(se));
			request.getRequestDispatcher("/user/dashboard.jsp").forward(request, response);
			
		}else if (path.equals("/professeur/dashboard.html")) {
			
			HttpSession session = request.getSession();
	        utilisateur user = (utilisateur) session.getAttribute( "user" );
	        dashboardDAOImp dao = new dashboardDAOImp();
	        List<seance> list = dao.findSeanceProf(user.getIdUser());
	        
	        request.getSession().setAttribute("emploi", dao.affiche(list));
			request.getRequestDispatcher("/professeur/dashboard.jsp").forward(request, response);
		}else if (path.equals("/professeur/index.html")) {
			
			HttpSession session = request.getSession();
	        utilisateur user = (utilisateur) session.getAttribute( "user" );
	        dashboardDAOImp dao = new dashboardDAOImp();
	        List<seance> list = dao.findSeanceProf(user.getIdUser());
	        
	        request.getSession().setAttribute("emploi", dao.affiche(list));
			request.getRequestDispatcher("/professeur/dashboard.jsp").forward(request, response);
		}
		
		/**
		 * deconnecter.html
		 */
		
		
		if (path.equals("/admin/deconnecter.html")) {
			response.sendRedirect("/miageEmploi/");
		}
		if (path.equals("/user/deconnecter.html")) {
			response.sendRedirect("/miageEmploi/");
		}
		if (path.equals("/professeur/deconnecter.html")) {
			response.sendRedirect("/miageEmploi/");
		}
		
		/**
		 * utilisateur.html
		 */
		
		if (path.equals("/admin/utilisateur.html")) {
			utilisateurDAOImp utilisateur = new utilisateurDAOImp();	
			request.getSession().setAttribute("administrateur", utilisateur.affiche("administrateur"));
			request.getSession().setAttribute("etudiant", utilisateur.affiche("etudiant"));
			request.getSession().setAttribute("professeur", utilisateur.affiche("professeur"));
			request.getRequestDispatcher("/admin/utilisateur.jsp").forward(request, response);
		}
		
		/**
		 * horaire.html
		 */
		
		if (path.equals("/admin/horaire.html")) {
			horaireDAOImp horaire = new horaireDAOImp();	
			request.getSession().setAttribute("html", horaire.affiche());
			request.getRequestDispatcher("/admin/horaire.jsp").forward(request, response);
		}
		
		/**
		 * salle.html
		 */
		
		if (path.equals("/admin/salle.html")) {
			salleDAOImp salle = new salleDAOImp();
			request.getSession().setAttribute("html", salle.affiche());
			request.getRequestDispatcher("/admin/salle.jsp").forward(request, response);
		}
		
		/**
		 * semestre.html
		 */
		
		if (path.equals("/admin/semestre.html")) {
			semestreDAOImp semestre = new semestreDAOImp();
			request.getSession().setAttribute("html", semestre.affiche());
			request.getRequestDispatcher("/admin/semestre.jsp").forward(request, response);
		}
		
		/**
		 * filiere.html
		 */
		
		if (path.equals("/admin/filiere.html")) {
			filiereDAOImp filiere = new filiereDAOImp();
			request.getSession().setAttribute("html", filiere.affiche());
			request.getRequestDispatcher("/admin/filiere.jsp").forward(request, response);
		}
		
		/**
		 * classe.html
		 */
		
		if (path.equals("/admin/classe.html")) {
			classeDAOImp classe = new classeDAOImp();
			request.getSession().setAttribute("html", classe.affiche());
			request.getSession().setAttribute("filiere", classe.selectListFiliere());
			request.getRequestDispatcher("/admin/classe.jsp").forward(request, response);
		}
		
		/**
		 * liste-classe.html
		 */
		
		if (path.equals("/admin/liste-etudiant.html")) {
			listEtudiantDAOImp listeEtudiant = new listEtudiantDAOImp();
			request.getSession().setAttribute("html", listeEtudiant.affiche(Integer.parseInt(request.getParameter("id"))));
			request.getSession().setAttribute("etudiant", listeEtudiant.selectListEtudiant());
			request.getRequestDispatcher("/admin/liste-etudiant.jsp").forward(request, response);
		}
		
		/**
		 * matiere.html
		 */
		
		if (path.equals("/admin/matiere.html")) {
			matiereDAOImp matiere = new matiereDAOImp();
			request.getSession().setAttribute("html", matiere.affiche());
			request.getSession().setAttribute("semestre", matiere.selectListSemestre());
			request.getRequestDispatcher("/admin/matiere.jsp").forward(request, response);
		}
		
		/**
		 * seance.html
		 */
		
		if (path.equals("/admin/seance.html")) {
			seanceDAOImp seance = new seanceDAOImp();
			request.getSession().setAttribute("html", seance.affiche());
			request.getSession().setAttribute("professeur", seance.selectListeProff());
			request.getSession().setAttribute("salle", seance.selectListeSalle());
			request.getSession().setAttribute("classe", seance.selectListeFiliere());
			request.getSession().setAttribute("matiere", seance.selectListeMatiere());
			request.getSession().setAttribute("horaire", seance.selectListeHoraire());
			request.getRequestDispatcher("/admin/seance.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();

		/**
		 * authentification
		 */
		
		if(path.equals("/login.html")){
			utilisateur user = new utilisateur();
			user.setLogin(request.getParameter("login"));
			user.setPassword(request.getParameter("pass"));
			utilisateurDAOImp us = new utilisateurDAOImp();
			user = us.authentification(user);
			if(user != null) {
				HttpSession s = request.getSession(true);
				s.setAttribute("user", user);
				if(user.getType().equals("administrateur")) {
					response.sendRedirect("admin/dashboard.html");
				} else if(user.getType().equals("etudiant")){
					response.sendRedirect("user/dashboard.html");
				} else if(user.getType().equals("professeur")){
					System.out.println("ok");
					response.sendRedirect("professeur/dashboard.html");
				}
				
			}else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		
		/**
		 * dashboard.html
		 */
		
		if (path.equals("/admin/afficher-emploi.html")) {
			dashboardDAOImp dao = new dashboardDAOImp();
			List<seance> c = dao.findClasse(Integer.parseInt(request.getParameter("id")));
			response.getWriter().print( dao.affiche(c));
		}

		/**
		 * horaire.html
		 */
		
		if(path.equals("/admin/ajouter-horaire.html")) {
			int cp = Integer.parseInt(request.getParameter("cp"));
			List<horaire> list = new ArrayList<horaire>();
			for(int i = 1; i <= cp; i++){
			  if (!request.getParameter("heureDebut"+i).equals(null) && !request.getParameter("heureFin"+i).equals(null) &&
					  !request.getParameter("jour"+i).equals(null)) {
				  	horaire h = new horaire();
				  	h.setHeureDebut(request.getParameter("heureDebut"+i));
				  	h.setHeureFin(request.getParameter("heureFin"+i));
				  	h.setJour(request.getParameter("jour"+i));
				  	list.add(h);
			  }
			}
			
			horaireDAOImp horaire = new horaireDAOImp();
			int etat = horaire.ajouter(list);
			if (etat == 1) {
				response.sendRedirect("horaire.html");
			} else {
				response.sendRedirect("horaire.html");
			}
		} else if(path.equals("/admin/update-horaire.html")) {
			horaireDAOImp horaire = new horaireDAOImp();
			response.getWriter().print( horaire.selectIdUpdate(Integer.parseInt(request.getParameter("id"))));
		} else if(path.equals("/admin/modifier-horaire.html")) {
			horaire hr = new horaire();
			hr.setIdHoraire(Integer.parseInt(request.getParameter("idHoraire")));
			hr.setHeureDebut(request.getParameter("heureDebut"));
			hr.setHeureFin(request.getParameter("heureFin"));
			hr.setJour(request.getParameter("jour"));
			
			horaireDAOImp horaire = new horaireDAOImp();
			int etat = horaire.modifier(hr);
			if (etat == 1) {
				response.sendRedirect("horaire.html");
			} else {
				response.sendRedirect("horaire.html");
			}
		}else if(path.equals("/admin/delete-horaire.html")) {
			horaireDAOImp horaire = new horaireDAOImp();
			int etat = horaire.supprimer(Integer.parseInt(request.getParameter("idSup")));
			if (etat == 1) {
				response.sendRedirect("horaire.html");
			} else {
				response.sendRedirect("horaire.html");
			}
		}
		
		/**
		 * salle.html
		 */
		
		if(path.equals("/admin/ajouter-salle.html")) {
			int cp = Integer.parseInt(request.getParameter("cp"));
			List<salle> list = new ArrayList<salle>();
			for(int i = 1; i <= cp; i++){
				  if (request.getParameter("num"+i) != null && !request.getParameter("etage"+i).equals(null) &&
						  !request.getParameter("type"+i).equals(null)) {
					  	salle s = new salle();
					  	s.setNum(request.getParameter("num"+i));
					  	s.setEtage(Integer.parseInt(request.getParameter("etage"+i)));
					  	s.setType(request.getParameter("type"+i));
					  	System.out.println("add");
					  	list.add(s);
				  }else {
					  System.out.println("error");
				  }
			}
			salleDAOImp salle = new salleDAOImp();
			int etat = salle.ajouter(list);
			if (etat == 1) {
				response.sendRedirect("salle.html");
			} else {
				response.sendRedirect("salle.html");
			}
		}else if(path.equals("/admin/update-salle.html")) {
			salleDAOImp salle = new salleDAOImp();
			response.getWriter().print( salle.selectIdUpdate(Integer.parseInt(request.getParameter("id"))));
		} else if(path.equals("/admin/modifier-salle.html")) {
			
			salle sl = new salle();
			sl.setIdSalle(Integer.parseInt(request.getParameter("idSalle")));
			sl.setNum(request.getParameter("num"));
			sl.setEtage(Integer.parseInt(request.getParameter("etage")));
			sl.setType(request.getParameter("type"));
			
			salleDAOImp salle = new salleDAOImp();
			int etat = salle.modifier(sl); 
			
			if (etat == 1) {
				response.sendRedirect("salle.html");
			} else {
				response.sendRedirect("salle.html");
			}
		} else if(path.equals("/admin/delete-salle.html")) {
			salleDAOImp salle = new salleDAOImp();
			int etat = salle.supprimer(Integer.parseInt(request.getParameter("idSup")));
			if (etat == 1) {
				response.sendRedirect("salle.html");
			} else {
				response.sendRedirect("salle.html");
			}
		}
		
		/**
		 * semestre.html
		 */
		
		if(path.equals("/admin/ajouter-semestre.html")) {
			int cp = Integer.parseInt(request.getParameter("cp"));
			List<semestre> list = new ArrayList<semestre>();
			for(int i = 1; i <= cp; i++){
				  if (!request.getParameter("nom"+i).equals(null) && !request.getParameter("debut"+i).equals(null) &&
						  !request.getParameter("fin"+i).equals(null)) {
					  semestre s = new semestre();
					  s.setNom(request.getParameter("nom"+i));

					  Date dateDebut =Date.valueOf(request.getParameter("debut"+i));
					  s.setMoisDebut(dateDebut);
					  
					  Date dateFin = Date.valueOf(request.getParameter("fin"+i));
					  s.setMoisFin(dateFin);
					  list.add(s);
				  }else {
					  System.out.println("error");
				  }
			}
			semestreDAOImp semestre = new semestreDAOImp();
			int etat = semestre.ajouter(list);;
			if (etat == 1) {
				response.sendRedirect("semestre.html");
			} else {
				response.sendRedirect("semestre.html");
			}
		} else if(path.equals("/admin/update-semestre.html")) {
			semestreDAOImp semestre = new semestreDAOImp();
			response.getWriter().print( semestre.selectIdUpdate(Integer.parseInt(request.getParameter("id"))));
		} else if(path.equals("/admin/modifier-semestre.html")) {
			
			semestre s = new semestre();
			s.setIdSemestre(Integer.parseInt(request.getParameter("idSemestre")));
			s.setNom(request.getParameter("nom"));
			
			Date dateDebut = Date.valueOf(request.getParameter("debut"));
			s.setMoisDebut(dateDebut);
			  
			Date dateFin = Date.valueOf(request.getParameter("fin"));
			s.setMoisFin(dateFin);
		
			semestreDAOImp semestre = new semestreDAOImp();
			int etat = semestre.modifier(s);
			
			if (etat == 1) {
				response.sendRedirect("semestre.html");
			} else {
				response.sendRedirect("semestre.html");
			}
		} else if(path.equals("/admin/delete-semestre.html")) {
			semestreDAOImp semestre = new semestreDAOImp();
			int etat = semestre.supprimer(Integer.parseInt(request.getParameter("idSup")));
			if (etat == 1) {
				response.sendRedirect("semestre.html");
			} else {
				response.sendRedirect("semestre.html");
			}
		}
		
		/**
		 * filiere.html
		 */
		
		if(path.equals("/admin/ajouter-filiere.html")) {
			int cp = Integer.parseInt(request.getParameter("cp"));
			List<filiere> list = new ArrayList<filiere>();
			for(int i = 1; i <= cp; i++){
				  if (!request.getParameter("nom"+i).equals(null) && !request.getParameter("abrv"+i).equals(null)) {
					  filiere s = new filiere();
					  s.setNom(request.getParameter("nom"+i));
					  s.setAbreviation(request.getParameter("abrv"+i));
					  
					  list.add(s);
				  }else {
					  System.out.println("error");
				  }
			}
			filiereDAOImp filiere = new filiereDAOImp();
			int etat = filiere.ajouter(list);;
			if (etat == 1) {
				response.sendRedirect("filiere.html");
			} else {
				response.sendRedirect("filiere.html");
			}
		} else if(path.equals("/admin/update-filiere.html")) {
			filiereDAOImp filiere = new filiereDAOImp();
			response.getWriter().print( filiere.selectIdUpdate(Integer.parseInt(request.getParameter("id"))));
		} else if(path.equals("/admin/modifier-filiere.html")) {
			filiere s = new filiere();
			s.setIdFiliere(Integer.parseInt(request.getParameter("idFiliere")));
			s.setNom(request.getParameter("nom"));
		  	s.setAbreviation(request.getParameter("abrv"));
		  	
		  	filiereDAOImp filiere = new filiereDAOImp();
			int etat = filiere.modifier(s);
			if (etat == 1) {
				response.sendRedirect("filiere.html");
			} else {
				response.sendRedirect("filiere.html");
			}
		} else if(path.equals("/admin/delete-filiere.html")) {
			filiereDAOImp filiere = new filiereDAOImp();
			int etat = filiere.supprimer(Integer.parseInt(request.getParameter("idSup")));
			if (etat == 1) {
				response.sendRedirect("filiere.html");
			} else {
				response.sendRedirect("filiere.html");
			}
		}
		
		/**
		 * classe.html
		 */
		
		if(path.equals("/admin/ajouter-classe.html")) {
			int cp = Integer.parseInt(request.getParameter("cp"));
			List<classe> list = new ArrayList<classe>();
			classeDAOImp classe = new classeDAOImp();
			for(int i = 1; i <= cp; i++){
				  classe s = new classe();
					  s.setNom(request.getParameter("nom"+i));
					  s.setAbreviation(request.getParameter("abrv"+i));
					  s.setNiveau(Integer.parseInt(request.getParameter("niveau"+i)));
					  filiere f = classe.selectFiliere(Integer.parseInt(request.getParameter("filiere"+i)));
					  s.setFiliere(f);
					  list.add(s);
			}
			int etat = classe.ajouter(list);;
			if (etat == 1) {
				response.sendRedirect("classe.html");
			} else {
				response.sendRedirect("classe.html");
			}
		} else if(path.equals("/admin/update-classe.html")) {
			classeDAOImp classe = new classeDAOImp();
			response.getWriter().print( classe.selectIdUpdate(Integer.parseInt(request.getParameter("id"))));
		} else if(path.equals("/admin/modifier-classe.html")) {
			classeDAOImp classe = new classeDAOImp();
			classe s = new classe();
			s.setIdClass(Integer.parseInt(request.getParameter("idClasse")));
			s.setNom(request.getParameter("nom"));
			s.setAbreviation(request.getParameter("abrv"));
			s.setNiveau(Integer.parseInt(request.getParameter("niveau")));
			filiere f = classe.selectFiliere(Integer.parseInt(request.getParameter("filiere")));
			s.setFiliere(f);
			
			int etat = classe.modifier(s);
			if (etat == 1) {
				response.sendRedirect("classe.html");
			} else {
				response.sendRedirect("classe.html");
			}
		} else if(path.equals("/admin/delete-classe.html")) {
			classeDAOImp classe = new classeDAOImp();
			int etat = classe.supprimer(Integer.parseInt(request.getParameter("idSup")));
			if (etat == 1) {
				response.sendRedirect("classe.html");
			} else {
				response.sendRedirect("classe.html");
			}
		}
		
		/**
		 * matiere.html
		 */
		
		if(path.equals("/admin/ajouter-matiere.html")) {
			int cp = Integer.parseInt(request.getParameter("cp"));
			List<matiere> list = new ArrayList<matiere>();
			matiereDAOImp matiere = new matiereDAOImp();

			for(int i = 1; i <= cp; i++){
				matiere s = new matiere();
				s.setNom(request.getParameter("matiere"+i));
				s.setAbreviation(request.getParameter("abrv"+i));
				
				semestre f = matiere.selectSemestre(Integer.parseInt(request.getParameter("semestre"+i)));
				s.setSemestre(f);
				list.add(s);
			}
			int etat = matiere.ajouter(list);;
			if (etat == 1) {
				response.sendRedirect("matiere.html");
			} else {
				response.sendRedirect("matiere.html");
			}
		} else if(path.equals("/admin/update-matiere.html")) {
			matiereDAOImp matiere = new matiereDAOImp();
			response.getWriter().print( matiere.selectIdUpdate(Integer.parseInt(request.getParameter("id"))));
		} else if(path.equals("/admin/modifier-matiere.html")) {
			matiereDAOImp matiere = new matiereDAOImp();
			matiere s = new matiere();
			s.setIdMatiere(Integer.parseInt(request.getParameter("idMatiere")));
			s.setNom(request.getParameter("matiere"));
			s.setAbreviation(request.getParameter("abrv"));
			
			semestre f = matiere.selectSemestre(Integer.parseInt(request.getParameter("semestre")));
			s.setSemestre(f);
			
			int etat = matiere.modifier(s);
			if (etat == 1) {
				response.sendRedirect("matiere.html");
			} else {
				response.sendRedirect("matiere.html");
			}
		} else if(path.equals("/admin/delete-matiere.html")) {
			matiereDAOImp matiere = new matiereDAOImp();
			int etat = matiere.supprimer(Integer.parseInt(request.getParameter("idSup")));
			if (etat == 1) {
				response.sendRedirect("matiere.html");
			} else {
				response.sendRedirect("matiere.html");
			}
		} 
		
		/**
		 * utilisateur.html
		 */
		
		if(path.equals("/admin/valide-login.html")) {
			utilisateurDAOImp user = new utilisateurDAOImp();
			response.getWriter().print( user.validLogin(request.getParameter("login")));
		
		} else if(path.equals("/admin/ajouter-utilisateur.html")) {
			utilisateurDAOImp user = new utilisateurDAOImp();
			utilisateur u = new utilisateur();
			
			u.setLogin(request.getParameter("login"));
			u.setNom(request.getParameter("nom"));
			u.setPrenom(request.getParameter("prenom"));
			u.setEmail(request.getParameter("email"));
			u.setTelephone(request.getParameter("telephone"));
			u.setType(request.getParameter("type"));
			String pass= user.generate(10);
			u.setPassword(pass);
			int etat = user.ajouter(u);
			if (etat == 1) {
				String body = user.bodyCreation(u);
				String subject="Identifiants de votre compte IGAEmploiDuTemps"; 
				user.send("jee.miage@gmail.com", u.getEmail(), subject, body, "aze123rty");
				response.sendRedirect("utilisateur.html");
			} else {
				response.sendRedirect("utilisateur.html");
			}
		
		} else if(path.equals("/admin/modifiere-utilisateur.html")) {
			utilisateurDAOImp user = new utilisateurDAOImp();
			utilisateur u = user.find(Integer.parseInt(request.getParameter("idMod")));
			u.setPassword(user.generate(10));
			int etat = user.modifier(u);
			if (etat == 1) {
				String body = user.bodyPassword(u);
				String subject="Changement du mot de passe de votre compte IGAEmploiDuTemps"; 
				user.send("jee.miage@gmail.com", u.getEmail(), subject, body, "aze123rty");
				response.sendRedirect("utilisateur.html");
			} else {
				response.sendRedirect("utilisateur.html");
			}
		} else if(path.equals("/admin/delete-utilisateur.html")) {
			utilisateurDAOImp user = new utilisateurDAOImp();
			int etat = user.supprimer(Integer.parseInt(request.getParameter("idSup")));
			if (etat == 1) {
				response.sendRedirect("utilisateur.html");
			} else {
				response.sendRedirect("utilisateur.html");
			}
		} 
		
		/**
		 * liste-classe.html
		 */
		if(path.equals("/admin/ajouter-liste.html")) {
			int cp = Integer.parseInt(request.getParameter("cp"));
			List<listeEtudiant> list = new ArrayList<listeEtudiant>();
			listEtudiantDAOImp listeEtudiant = new listEtudiantDAOImp();
			classe classe = listeEtudiant.findClasse(Integer.parseInt(request.getParameter("idClass")));
			for(int i = 1; i <= cp; i++){
				listeEtudiant s = new listeEtudiant();
				utilisateur user = listeEtudiant.findUser(Integer.parseInt(request.getParameter("etudiant"+i)));
				s.setUser(user);
				s.setClasse(classe);
				list.add(s);
			}
			int etat = listeEtudiant.ajouter(list);
			if (etat == 1) {
				response.sendRedirect("liste-etudiant.html?id="+request.getParameter("idClass"));
			} else {
				response.sendRedirect("liste-etudiant.html?id="+request.getParameter("idClass"));
			}
		} else if(path.equals("/admin/delete-liste.html")) {
			listEtudiantDAOImp listeEtudiant = new listEtudiantDAOImp();
			int etat = listeEtudiant.supprimer(Integer.parseInt(request.getParameter("idSup")));
			if (etat == 1) {
				response.sendRedirect("liste-etudiant.html?id="+request.getParameter("idClass"));
			} else {
				response.sendRedirect("liste-etudiant.html?id="+request.getParameter("idClass"));
			}
		} 
		
		/**
		 *  seance.html
		 */
		
		if(path.equals("/admin/ajouter-seance.html")) {
			int cp = Integer.parseInt(request.getParameter("cp"));
			List<seance> list = new ArrayList<seance>();
			seanceDAOImp dao = new seanceDAOImp();
			
			for(int i = 1; i <= cp; i++){
				seance s = new seance();
				s.setProfesseur(dao.findUser(Integer.parseInt(request.getParameter("professeur"+i))));
				s.setClasse(dao.findClasse(Integer.parseInt(request.getParameter("classe"+i))));
				s.setSalle(dao.findSalle(Integer.parseInt(request.getParameter("salle"+i))));
				s.setMatiere(dao.findMatiere(Integer.parseInt(request.getParameter("matiere"+i))));
				s.setHoraire(dao.findHoraire(Integer.parseInt(request.getParameter("horaire"+i))));

				list.add(s);
			}
			int etat = dao.ajouter(list);
			if (etat == 1) {
				response.sendRedirect("seance.html");
			} else {
				response.sendRedirect("seance.html");
			}
		}  else if(path.equals("/admin/update-seance.html")) {
			seanceDAOImp dao = new seanceDAOImp();
			response.getWriter().print( dao.selectIdUpdate(Integer.parseInt(request.getParameter("id"))));
		} else if(path.equals("/admin/modifier-seance.html")) {
			seanceDAOImp dao = new seanceDAOImp();
			seance s = new seance();
			s.setIdSeance(Integer.parseInt(request.getParameter("idSeance")));
			s.setProfesseur(dao.findUser(Integer.parseInt(request.getParameter("professeur"))));
			s.setClasse(dao.findClasse(Integer.parseInt(request.getParameter("classe"))));
			s.setSalle(dao.findSalle(Integer.parseInt(request.getParameter("salle"))));
			s.setMatiere(dao.findMatiere(Integer.parseInt(request.getParameter("matiere"))));
			s.setHoraire(dao.findHoraire(Integer.parseInt(request.getParameter("horaire"))));
			
			int etat = dao.modifier(s);
			if (etat == 1) {
				response.sendRedirect("seance.html");
			} else {
				response.sendRedirect("seance.html");
			}
		} else if(path.equals("/admin/delete-seance.html")) {
			seanceDAOImp dao = new seanceDAOImp();
			int etat = dao.supprimer(Integer.parseInt(request.getParameter("idSup")));
			if (etat == 1) {
				response.sendRedirect("seance.html");
			} else {
				response.sendRedirect("seance.html");
			}
		} 
		
		
		//-------------------------------------------------------------------------------------------------//
	}

}
