<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.matiere" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idSup"));
	matiere matiere = new matiere();
	matiere.delete(id);
	response.sendRedirect( request.getContextPath() + "/admin/matiere.jsp?supprimer=ok");
%>