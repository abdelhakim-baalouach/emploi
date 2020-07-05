<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.semestre" %> 
<%	
	String text = "";
	int id = Integer.parseInt(request.getParameter("id"));
	semestre semestre = new semestre();
	ResultSet res = semestre.update(id);
	if(res.next()){
		text += res.getInt(1)+"/"+res.getString(2)+"/"+res.getString(3)+"/"+res.getString(4);
	}
	out.println(text);
%>