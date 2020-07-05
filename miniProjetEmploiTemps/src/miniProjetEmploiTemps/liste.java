package miniProjetEmploiTemps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class liste {
	private int idEtudiant;
	private int idUser;
	private int idClasse;
	
	
	public liste() {
		super();
	}

	public liste(int idEtudiant, int idUser, int idClasse) {
		super();
		this.idEtudiant = idEtudiant;
		this.idUser = idUser;
		this.idClasse = idClasse;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}
	
	public void add() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "INSERT INTO public.listeetudiant(idetudiant, iduser, idclasse) VALUES (DEFAULT, ?, ?)";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setInt(1, idUser);
			s.setInt(2, idClasse);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet user() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT iduser, concat(iduser,'-',login) FROM public.utilisateur\r\n" + 
				"where type = 'etudiant'";
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
	
	public ResultSet classe() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT idclasse, nom  FROM public.classe";
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
	
	public ResultSet affiche(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT l.idetudiant, u.nom,u.prenom,u.email FROM public.listeetudiant l,utilisateur u\r\n" + 
				"where u.iduser = l.iduser and l.idclasse=?";
        PreparedStatement s;
        ResultSet resultat = null ;
		try {
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			resultat =  s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
      
		return resultat;
	}
	
	public ResultSet update(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT l.iduser, u.nom,u.prenom,u.email FROM public.listeetudiant l,utilisateur u\\r\\n\" + \r\n" + 
				"				\"where u.iduser = l.iduser and idetudiant=?";
        PreparedStatement s;
        ResultSet resultat = null ;
		try {
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			resultat =  s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	public void delete(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		String sql = "DELETE FROM public.listeetudiant\r\n" + 
				" WHERE idetudiant=?";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
