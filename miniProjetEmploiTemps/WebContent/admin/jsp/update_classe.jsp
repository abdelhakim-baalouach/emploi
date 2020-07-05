<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.classe" %> 
<%	
	String text = "";
	int id = Integer.parseInt(request.getParameter("id"));
	classe classe = new classe();
	ResultSet res = classe.update(id);
	if(res.next()){
		text += res.getInt(1)+"/"+res.getString(2)+"/"+res.getInt(3)+"/"+res.getString(4)+"/"+res.getInt(5);
	}
	out.println(text);
%>