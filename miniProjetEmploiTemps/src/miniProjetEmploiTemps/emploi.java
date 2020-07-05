package miniProjetEmploiTemps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class emploi {
	private int id;
	
	
	public emploi() {
		super();
	}


	public ResultSet affiche(String jour,int filiere) {
		connexion cn = new connexion();
		Connection c = cn.connecter();
		
		String sql = "SELECT CONCAT(f.abrv,'-',c.abrv),CONCAT(u.nom ,' ',u.prenom),CONCAT(sa.etage,sa.num),m.nom,CONCAT(h.heurdebut ,'--',h.heurfin ),h.jour\r\n" + 
				"	FROM seance s,matiere m,classe c,filiere f,utilisateur u,salle sa,horaire h\r\n" + 
				"	WHERE u.iduser = s.iduser AND u.type='professeur'\r\n" + 
				"	AND s.idclasse = c.idclasse AND c.idfiliere = f.idfiliere AND s.idClasse=?\r\n" + 
				"	AND s.idsalle = sa.idsalle\r\n" + 
				"	AND s.idmatiere = m.idmatiere\r\n" + 
				"	AND s.idhoraire = h.idhoraire\r\n" + 
				"	AND h.jour =? ";
        PreparedStatement s;
        ResultSet resultat = null ;
		try {
			s = c.prepareStatement(sql);
			s.setInt(1, filiere);
			s.setString(2, jour);
			resultat =  s.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
      
		return resultat;
	}
}
