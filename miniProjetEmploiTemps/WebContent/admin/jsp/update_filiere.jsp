<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.filiere" %> 
<%	
	String text = "";
	int id = Integer.parseInt(request.getParameter("id"));
	filiere filiere = new filiere();
	ResultSet res = filiere.update(id);
	if(res.next()){
		text += res.getInt(1)+"/"+res.getString(2)+"/"+res.getString(3);
	}
	out.println(text);
%>