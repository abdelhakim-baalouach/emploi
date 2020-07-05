package miniProjetEmploiTemps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class seance {
	private int idSeance;
	private int idHoraire;
	private int idMatiere;
	private int idSalle;
	private int idProf;
	private int idClasse;
	
	public seance() {
		super();
	}
	
	public seance(int idSeance, int idHoraire, int idMatiere, int idSalle, int idProf, int idClasse) {
		super();
		this.idSeance = idSeance;
		this.idHoraire = idHoraire;
		this.idMatiere = idMatiere;
		this.idSalle = idSalle;
		this.idProf = idProf;
		this.idClasse = idClasse;
	}

	public int getIdHoraire() {
		return idHoraire;
	}
	public void setIdHoraire(int idHoraire) {
		this.idHoraire = idHoraire;
	}
	public int getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public int getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}
	public int getIdProf() {
		return idProf;
	}
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	public int getIdClasse() {
		return idClasse;
	}
	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}
	
	public int getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public ResultSet affiche() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql ="SELECT idseance,CONCAT(f.abrv,'-',c.abrv),CONCAT(u.nom ,' ',u.prenom),CONCAT(sa.etage,sa.num),m.nom,CONCAT(h.heurdebut ,'--',h.heurfin ,' - ' ,h.jour)\r\n" + 
				"	FROM seance s,matiere m,classe c,filiere f,utilisateur u,salle sa,horaire h\r\n" + 
				"		WHERE u.iduser = s.iduser AND u.type='professeur'\r\n" + 
				"			AND s.idclasse = c.idclasse AND c.idfiliere = f.idfiliere\r\n" + 
				"			AND s.idsalle = sa.idsalle\r\n" + 
				"			AND s.idmatiere = m.idmatiere\r\n" + 
				"			AND s.idhoraire = h.idhoraire";
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
	
	public ResultSet professeur() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT iduser, concat(nom,' ',prenom) FROM public.utilisateur\r\n" + 
				"where type = 'professeur'";
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
	
	public ResultSet salle() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT idsalle, CONCAT(num,etage) FROM public.salle";
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
		
		String sql = "SELECT idclasse, CONCAT(f.abrv,'-',c.abrv)  FROM public.classe c,filiere f WHERE f.idfiliere = c.idfiliere";
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
	public ResultSet matiere() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT idmatiere, abrv FROM public.matiere";
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
	public ResultSet horaire() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT idhoraire, CONCAT(heurdebut,'-->', heurfin,' - ' ,jour)  FROM public.horaire";
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
	public void add() {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "INSERT INTO public.seance(idseance, idmatiere, idsalle, idclasse, iduser, idhoraire) VALUES (DEFAULT, ?, ?, ?, ?, ?)";
        PreparedStatement s;
		try {
			s = c.prepareStatement(sql);
			s.setInt(1, idMatiere);
			s.setInt(2, idSalle);
			s.setInt(3, idClasse);
			s.setInt(4, idProf);
			s.setInt(5, idHoraire);
			s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet update(int id) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT * FROM public.seance where idseance =?";
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
		String sql = "DELETE FROM public.seance WHERE idseance=?";
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
