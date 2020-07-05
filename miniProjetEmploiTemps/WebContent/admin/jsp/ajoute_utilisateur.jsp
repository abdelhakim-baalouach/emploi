<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.utilisateur" %> 
<%	
	utilisateur utilisateur = new utilisateur(0,request.getParameter("login"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("email"),request.getParameter("telephone"),request.getParameter("type"));
	utilisateur.add();
	response.sendRedirect( request.getContextPath() + "/admin/utilisateur.jsp?ajouter=ok");
%>