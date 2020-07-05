<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.horaire" %> 
<%	
	horaire horaire = new horaire(1,request.getParameter("heureDebut"),request.getParameter("heureFin"),request.getParameter("jour"));
	horaire.add();
	response.sendRedirect( request.getContextPath() + "/admin/horaire.jsp?ajouter=ok");
%>