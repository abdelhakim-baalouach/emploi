package miniProjetEmploiTemps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class salle {
	private Integer idSalle;
	private String num; 
	private Integer etage;
	private String type;
	
	public salle() {
		super();
	}
	
	public salle(Integer idSalle, String num, Integer etage, String type) {
		super();
		this.idSalle = idSalle;
		this.num = num;
		this.etage = etage;
		this.type = type;
	}
	
	public Integer getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(Integer idSalle) {
		this.idSalle = idSalle;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Integer getEtage() {
		return etage;
	}
	public void setEtage(Integer etage) {
		this.etage = etage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void add() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "INSERT INTO public.salle(idsalle, num, etage, type) VALUES (DEFAULT, ?, ?, ?)";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, num);
			s.setInt(2, etage);
			s.setString(3, type);

			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet affiche() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT * FROM public.salle";
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
		
		String sql = "SELECT * FROM public.salle where idsalle =?";
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
		String sql = "UPDATE public.salle SET  num=?, etage=?, type=? WHERE idsalle=?";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, num);
			s.setInt(2, etage);
			s.setString(3, type);
			s.setInt(4, id);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		String sql = "DELETE FROM public.salle  WHERE idsalle=?";
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
