package miniProjetEmploiTemps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class filiere {
	private int idFiliere;
	private String nom;
	private String abreviation;
	
	public filiere() {
		super();
	}

	public filiere(int idFiliere, String nom, String abreviation) {
		super();
		this.idFiliere = idFiliere;
		this.nom = nom;
		this.abreviation = abreviation;
	}

	public int getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
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
	
	public void add() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "INSERT INTO public.filiere ( idfiliere, nom, abrv) VALUES (DEFAULT, ?, ?)";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, nom);
			s.setString(2, abreviation);

			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet affiche() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT * FROM public.filiere";
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
		
		String sql = "SELECT * FROM public.filiere where idfiliere =?";
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
		String sql = "UPDATE public.filiere SET  nom=?, abrv=? WHERE idfiliere=?";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, nom);
			s.setString(2, abreviation);
			s.setInt(3, id);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		String sql = "DELETE FROM public.filiere  WHERE idfiliere=?";
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
