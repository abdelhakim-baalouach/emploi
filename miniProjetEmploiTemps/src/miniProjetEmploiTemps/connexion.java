package miniProjetEmploiTemps;

import java.sql.*;

public class connexion {
	private String url ="jdbc:postgresql://localhost:5432/gestionEmploi";
	private String user = "postgres";
	private String password = "root";
	private Connection connection;
	
	
	public connexion() {
		super();
	}

	public Connection connecter() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url,user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void deconnecter() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
