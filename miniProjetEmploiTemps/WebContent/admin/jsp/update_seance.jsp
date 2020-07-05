<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.seance" %> 
<%	
	String text = "";
	int id = Integer.parseInt(request.getParameter("id"));
	seance seance = new seance();
	ResultSet res = seance.update(id);
	if(res.next()){
		text += res.getInt(1)+"/"+res.getInt(2)+"/"+res.getInt(3)+"/"+res.getInt(4)+"/"+res.getInt(5)+"/"+res.getInt(6);
	}
	out.println(text);
%>