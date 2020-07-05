<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.horaire" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idHoraire"));
	horaire horaire = new horaire(id,request.getParameter("heureDebut"),request.getParameter("heureFin"),request.getParameter("jour"));
	horaire.edite(id);
	response.sendRedirect( request.getContextPath() + "/admin/horaire.jsp?modifier=ok");
%>