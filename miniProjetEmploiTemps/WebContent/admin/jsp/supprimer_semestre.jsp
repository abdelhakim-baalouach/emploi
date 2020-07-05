<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.semestre" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idSup"));
	semestre semestre = new semestre();
	semestre.delete(id);
	response.sendRedirect( request.getContextPath() + "/admin/semestre.jsp?supprimer=ok");
%>