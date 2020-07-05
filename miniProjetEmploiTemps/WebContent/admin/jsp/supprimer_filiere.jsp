<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.filiere" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idSup"));
	filiere filiere = new filiere();
	filiere.delete(id);
	response.sendRedirect( request.getContextPath() + "/admin/filiere.jsp?supprimer=ok");
%>