<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.matiere" %> 
<%	
	String text = "";
	int id = Integer.parseInt(request.getParameter("id"));
	matiere matiere = new matiere();
	ResultSet res = matiere.update(id);
	if(res.next()){
		text += res.getInt(1)+"/"+res.getString(2)+"/"+res.getString(3)+"/"+res.getInt(4);
	}
	out.println(text);
%>