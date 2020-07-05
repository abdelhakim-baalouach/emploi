<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.classe" %> 
<%	
	int id = Integer.parseInt(request.getParameter("idSup"));
	classe classe = new classe();
	classe.delete(id);
	response.sendRedirect( request.getContextPath() + "/admin/classe.jsp?supprimer=ok");
%>