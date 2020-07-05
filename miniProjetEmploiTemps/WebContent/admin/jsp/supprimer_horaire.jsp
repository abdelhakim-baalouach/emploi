<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.horaire" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idSup"));
	horaire horaire = new horaire();
	horaire.delete(id);
	response.sendRedirect( request.getContextPath() + "/admin/horaire.jsp?supprimer=ok");
%>