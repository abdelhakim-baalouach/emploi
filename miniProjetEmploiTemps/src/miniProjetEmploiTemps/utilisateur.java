package miniProjetEmploiTemps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class utilisateur {
	private int idUser;
	private String login;
	private String password;
	private String nom; 
	private String prenom; 
	private String email; 
	private String telephone;
	private String type;
	
	
	public utilisateur() {
		super();
	}

	public utilisateur(int idUser, String login, String nom, String prenom, String email,
			String telephone, String type) {
		super();
		this.idUser = idUser;
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.type = type;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String generate(int length){
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    String pass = "";
	    for(int x=0;x<length;x++){
	    	int i = (int)Math.floor(Math.random() * 62);
		    pass += chars.charAt(i);
		}
		System.out.println(pass);
		return pass;
	}
	
	public void add() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		password = generate(10);
		System.out.println(password);
		String sql = "INSERT INTO public.utilisateur(iduser, login, password, nom, prenom, email, telephone, type) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, login);
			s.setString(2, password);
			s.setString(3, nom);
			s.setString(4, prenom);
			s.setString(5, email);
			s.setString(6, telephone);
			s.setString(7, type);
		
			String body="Bonjour,\n\n\nDans le cadre de la gestion des emploi du temps dans notre école, on a mis a votre disposition une application qui gère les emploi du temps (Etudiants, Professeurs).\n\n\nVous trouverez ci joint votre Login et mot de passe pour y accéder.\n\n\nLogin : "+login+"\n\n\nMot de passe: "+password+"\n\n\nMerci pour votre attention, L'administration.\n\n\n";
			String subject="Identifiants de votre compte IGAEmploiDuTemps"; 
			send("abdelhakim.baalouach@etud.iga.ac.ma", email, subject, body, "Gmail.com/1992");
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet afficheAdmin() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT iduser, login, concat( nom,' ' ,prenom), email, telephone  FROM utilisateur where type = 'administrateur'";
        Statement s;
        ResultSet resultat = null ;
		try {
			s = c.createStatement();
			resultat =  s.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
      
		return resultat;
	}
	public ResultSet afficheEtudiant() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT iduser, login, concat( nom,' ' ,prenom), email, telephone  FROM utilisateur where type = 'etudiant'";
        Statement s;
        ResultSet resultat = null ;
		try {
			s = c.createStatement();
			resultat =  s.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
      
		return resultat;
	}
	public ResultSet afficheProf() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT iduser, login, concat( nom,' ' ,prenom), email, telephone  FROM utilisateur where type = 'professeur'";
        Statement s;
        ResultSet resultat = null ;
		try {
			s = c.createStatement();
			resultat =  s.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
      
		return resultat;
	}
	
	public void edite(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		String to=null;
		String sql = "SELECT email FROM public.utilisateur where iduser=?";
        PreparedStatement s;
        ResultSet res ;
        try {
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			res = s.executeQuery();
			if (res.next()) {
				to = res.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		password = generate(10);
		
		String body="Bonjour,\n\n\nVous trouverez ci joint votre nouveau mot de passe pour y accéder.\n\n\nMot de passe: "+password+"\n\n\nMerci pour votre attention, L'administration.\n\n\n";
		String subject="Changement du mot de passe de votre compte IGAEmploiDuTemps"; 
		send("abdelhakim.baalouach@etud.iga.ac.ma", to, subject, body, "Gmail.com/1992");
		
		sql = "UPDATE public.utilisateur SET password=?, type=? WHERE iduser=?";
		try {
			s = c.prepareStatement(sql);
			s.setString(1, password);
			s.setInt(2, id);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		String sql = "DELETE FROM public.utilisateur WHERE iduser=?";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void send(String from,String to,String Subject, String body,String p) {
		String username = from;
		String password = p;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(Subject);
			message.setText(body);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
