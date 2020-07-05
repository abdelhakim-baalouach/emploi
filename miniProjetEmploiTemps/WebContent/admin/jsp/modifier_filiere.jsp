<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.filiere" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idFiliere"));
	filiere filiere = new filiere(id,request.getParameter("nom"),request.getParameter("abrv"));
	filiere.edite(id);
	response.sendRedirect( request.getContextPath() + "/admin/filiere.jsp?modifier=ok");
%>