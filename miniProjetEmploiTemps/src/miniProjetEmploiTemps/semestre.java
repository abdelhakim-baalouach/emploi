package miniProjetEmploiTemps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class semestre {
	private long idSemestre;
	private String nom;
	private String moisDebut;
	private String moisFin;
	
	public semestre() {
		super();
	}
	
	public semestre(long idSemestre, String nom, String moisDebut, String moisFin) {
		super();
		this.idSemestre = idSemestre;
		this.nom = nom;
		this.moisDebut = moisDebut;
		this.moisFin = moisFin;
	}
	
	public long getIdSemestre() {
		return idSemestre;
	}
	public void setIdSemestre(long idSemestre) {
		this.idSemestre = idSemestre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMoisDebut() {
		return moisDebut;
	}
	public void setMoisDebut(String moisDebut) {
		this.moisDebut = moisDebut;
	}
	public String getMoisFin() {
		return moisFin;
	}
	public void setMoisFin(String moisFin) {
		this.moisFin = moisFin;
	}
	
	public void add() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "INSERT INTO public.semestre(idsemestre, nom, moisdebut, moisfin) VALUES (DEFAULT, ?, ?, ?)";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, nom);
			s.setString(2, moisDebut);
			s.setString(3, moisFin);

			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet affiche() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT * FROM public.semestre";
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
		
		String sql = "SELECT * FROM public.semestre where idsemestre =?";
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
		String sql = "UPDATE public.semestre SET nom=?, moisdebut=?, moisfin=? WHERE idsemestre=?";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, nom);
			s.setString(2, moisDebut);
			s.setString(3, moisFin);
			s.setInt(4, id);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		String sql = "DELETE FROM public.semestre  WHERE idsemestre=?";
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