package miniProjetEmploiTemps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class horaire {
	private int idHoraire;
	private String heureDebut;
	private String heureFin;
	private String jour;
	
	
	
	public horaire() {
		super();
	}

	public horaire(int idHoraire, String heureDebut, String heureFin, String jour) {
		super();
		this.idHoraire = idHoraire;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.jour = jour;
	}

	public int getIdHoraire() {
		return idHoraire;
	}

	public void setIdHoraire(int idHoraire) {
		this.idHoraire = idHoraire;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}
	
	public void add() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "INSERT INTO public.horaire(idhoraire, heurdebut, heurfin, jour) VALUES (DEFAULT, ?, ?, ?)";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, heureDebut);
			s.setString(2, heureFin);
			s.setString(3, jour);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet affiche() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT * FROM horaire";
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
		
		String sql = "SELECT idhoraire, heurdebut, heurfin, jour\r\n" + 
				"  FROM public.horaire where idhoraire =?";
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
		String sql = "UPDATE public.horaire SET heurdebut=?, heurfin=?, jour=? WHERE idhoraire=?";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, heureDebut);
			s.setString(2, heureFin);
			s.setString(3, jour);
			s.setInt(4, id);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		String sql = "DELETE FROM public.horaire WHERE idhoraire=?";
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
