<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.liste" %> 
<%	
	int idSup = Integer.parseInt(request.getParameter("idSup"));
	int id = Integer.parseInt(request.getParameter("id"));
	liste liste = new liste();
	liste.delete(idSup);
	response.sendRedirect( request.getContextPath() + "/admin/listeClasse.jsp?supprimer=ok&id="+id);
%>