<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.salle" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idSalle"));
	salle salle = new salle(id,request.getParameter("num"),Integer.parseInt(request.getParameter("etage")),request.getParameter("type"));
	salle.edite(id);
	response.sendRedirect( request.getContextPath() + "/admin/salle.jsp?modifier=ok");
%>