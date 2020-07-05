<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.utilisateur" %> 
<%	
	String text = "";
	int id = Integer.parseInt(request.getParameter("id"));
	utilisateur utilisateur = new utilisateur();
	utilisateur.edite(id);
	out.println("ok");
%>