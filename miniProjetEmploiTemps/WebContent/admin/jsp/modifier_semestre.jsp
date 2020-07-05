<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.semestre" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idSemestre"));
	semestre semestre = new semestre(id,request.getParameter("nom"),request.getParameter("dateD"),request.getParameter("dateF"));
	semestre.edite(id);
	response.sendRedirect( request.getContextPath() + "/admin/semestre.jsp?modifier=ok");
%>