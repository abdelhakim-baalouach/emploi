<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.classe" %> 
<%	
	int cp = Integer.parseInt(request.getParameter("cp"));
	for (int i=1; i<= cp; i++) {
		classe classe = new classe(i,request.getParameter("nom"+i),request.getParameter("abrv"+i),Integer.parseInt(request.getParameter("niveau"+i)),Integer.parseInt(request.getParameter("filiere"+i)));		
		classe.add();
	}
	response.sendRedirect( request.getContextPath() + "/admin/classe.jsp?ajouter=ok");
%>