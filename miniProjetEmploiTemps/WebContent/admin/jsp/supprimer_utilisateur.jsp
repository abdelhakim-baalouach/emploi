<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.utilisateur" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idSup"));
	utilisateur utilisateur = new utilisateur();
	utilisateur.delete(id);
	response.sendRedirect( request.getContextPath() + "/admin/utilisateur.jsp?supprimer=ok");
%>