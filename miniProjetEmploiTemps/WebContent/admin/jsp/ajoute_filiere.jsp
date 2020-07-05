<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.filiere" %> 
<%	
	int cp = Integer.parseInt(request.getParameter("cp"));
	for (int i=1; i<= cp; i++) {
		filiere filiere = new filiere(i,request.getParameter("nom"+i),request.getParameter("abrv"+i));
		filiere.add();
	}
	response.sendRedirect( request.getContextPath() + "/admin/filiere.jsp?ajouter=ok");
%>