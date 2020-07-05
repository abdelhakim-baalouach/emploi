<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.horaire" %> 
<%	
	String text = "";
	int id = Integer.parseInt(request.getParameter("id"));
	horaire horaire = new horaire();
	ResultSet res = horaire.update(id);
	if(res.next()){
		text += res.getInt(1)+"/"+res.getString(2)+"/"+res.getString(3)+"/"+res.getString(4);
	}
	out.println(text);
%>