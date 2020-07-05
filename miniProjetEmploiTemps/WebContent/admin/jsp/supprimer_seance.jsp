<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.seance" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idSup"));
	seance seance = new seance();
	seance.delete(id);
	response.sendRedirect( request.getContextPath() + "/admin/seance.jsp?supprimer=ok");
%>