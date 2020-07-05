<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.classe" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idClasse"));
	classe classe = new classe(id,request.getParameter("nom"),request.getParameter("abrv"),Integer.parseInt(request.getParameter("niveau")),Integer.parseInt(request.getParameter("filiere")));		
	classe.edite(id);
	response.sendRedirect( request.getContextPath() + "/admin/classe.jsp?modifier=ok");
%>