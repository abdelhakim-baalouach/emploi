package miniProjetEmploiTemps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class matiere {
	private int idMatiere;
	private String nom;
	private String abreviation;
	private int idSemestre;

	public matiere() {
		super();
	}
	
	public matiere(int idMatiere, String nom, String abreviation, int idSemestre) {
		super();
		this.idMatiere = idMatiere;
		this.nom = nom;
		this.abreviation = abreviation;
		this.idSemestre = idSemestre;
	}
	
	public int getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAbreviation() {
		return abreviation;
	}
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
	public int getIdSemestre() {
		return idSemestre;
	}
	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}
	
	public void add() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "INSERT INTO public.matiere(idmatiere, nom, abrv, idsemestre) VALUES (DEFAULT, ?, ?, ?);";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, nom);
			s.setString(2, abreviation);
			s.setInt(3, idSemestre);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet semestre() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT idsemestre, nom FROM public.semestre;";
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
	
	public ResultSet affiche() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT idmatiere, m.nom, abrv, s.nom FROM matiere m,semestre s\r\n" + 
				"where s.idsemestre = m.idsemestre";
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
	public ResultSet update(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT * FROM public.matiere where idMatiere =?";
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
	
	public void edite(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		String sql = "UPDATE public.matiere SET  nom=?, abrv=?, idsemestre=? WHERE idmatiere=?";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, nom);
			s.setString(2, abreviation);
			s.setInt(3, idSemestre);
			s.setInt(4, id);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		String sql = "DELETE FROM public.matiere WHERE idmatiere=?";
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
