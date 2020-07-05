<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.matiere" %> 
<%	
	int cp = Integer.parseInt(request.getParameter("cp"));
	for (int i=1; i<= cp; i++) {
		matiere matiere = new matiere(i,request.getParameter("nom"+i),request.getParameter("abrv"+i),Integer.parseInt(request.getParameter("semestre"+i)));
		matiere.add();
	}
	response.sendRedirect( request.getContextPath() + "/admin/matiere.jsp?ajouter=ok");
%>