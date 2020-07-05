<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.liste" %> 
<%	
	int cp = Integer.parseInt(request.getParameter("cp"));
	int id = Integer.parseInt(request.getParameter("id"));
	for (int i=1; i<= cp; i++) {
		liste liste = new liste(i,Integer.parseInt(request.getParameter("etudiant"+i)),Integer.parseInt(request.getParameter("id")));		
		liste.add();
	}
	response.sendRedirect( request.getContextPath() + "/admin/listeClasse.jsp?ajouter=ok&id="+id);
%>