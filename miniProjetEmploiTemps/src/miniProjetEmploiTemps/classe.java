package miniProjetEmploiTemps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class classe{
	private long idClass;
	private String nom;
	private String abreviation; 
	private int niveau;
	private int idFiliere;
	
	public classe() {
		super();
	}
	public classe(long idClass, String nom, String abreviation, int niveau, int idFiliere) {
		super();
		this.idClass = idClass;
		this.nom = nom;
		this.abreviation = abreviation;
		this.niveau = niveau;
		this.idFiliere = idFiliere;
	}
	public long getIdClass() {
		return idClass;
	}
	public void setIdClass(long idClass) {
		this.idClass = idClass;
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
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public int getIdFiliere() {
		return idFiliere;
	}
	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}
	
	public void add() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "INSERT INTO public.classe(idclasse, nom, niveau, abrv, idfiliere) VALUES (DEFAULT, ?, ?, ?, ?)";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, nom);
			s.setInt(2, niveau);
			s.setString(3, abreviation);
			s.setInt(4, idFiliere);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet filiere() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT idfiliere, nom FROM public.filiere;";
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
		
		String sql = "SELECT idclasse, c.nom, niveau, c.abrv, f.nom FROM public.classe c, filiere f\r\n" + 
				"where c.idfiliere = f.idfiliere;";
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
		
		String sql = "SELECT * FROM public.classe where idclasse =?";
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
		String sql = "UPDATE public.classe SET nom=?, niveau=?, abrv=?, idfiliere=? WHERE idclasse=?";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, nom);
			s.setString(3, abreviation);
			s.setInt(2, niveau);
			s.setInt(4, idFiliere);
			s.setInt(5, id);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		String sql = "DELETE FROM public.classe WHERE idclasse=?";
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
