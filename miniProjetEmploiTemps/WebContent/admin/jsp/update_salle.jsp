<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.salle" %> 
<%	
	String text = "";
	int id = Integer.parseInt(request.getParameter("id"));
	salle salle = new salle();
	ResultSet res = salle.update(id);
	if(res.next()){
		text += res.getInt(1)+"/"+res.getString(2)+"/"+res.getInt(3)+"/"+res.getString(4);
	}
	out.println(text);
%>