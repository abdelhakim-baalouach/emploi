<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.salle" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idSup"));
	salle salle = new salle();
	salle.delete(id);
	response.sendRedirect( request.getContextPath() + "/admin/salle.jsp?supprimer=ok");
%>