<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.salle" %> 
<%	
	int cp = Integer.parseInt(request.getParameter("cp"));
	for (int i=1; i<= cp; i++) {
		salle salle = new salle(i,request.getParameter("num"+i),Integer.parseInt(request.getParameter("etage"+i)),request.getParameter("type"+i));
		salle.add();
	}
	response.sendRedirect( request.getContextPath() + "/admin/salle.jsp?ajouter=ok");
%>