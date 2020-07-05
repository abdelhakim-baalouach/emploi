<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.semestre" %> 
<%	
	int cp = Integer.parseInt(request.getParameter("cp"));
	for (int i=1; i<= cp; i++) {
		semestre semestre = new semestre(i,request.getParameter("nom"+i),request.getParameter("dateD"+i),request.getParameter("dateF"+i));
		semestre.add();
	}
	response.sendRedirect( request.getContextPath() + "/admin/semestre.jsp?ajouter=ok");
%>