<%@page import="java.sql.*"%>
<%@page import="miniProjetEmploiTemps.seance" %> 
<%	
	int cp = Integer.parseInt(request.getParameter("cp"));
	for (int i=1; i<= cp; i++) {
		int idHoraire= Integer.parseInt(request.getParameter("horaire"+i));
		int idMatiere= Integer.parseInt(request.getParameter("matiere"+i));
		int idSalle  = Integer.parseInt(request.getParameter("salle"+i));
		int idProf   = Integer.parseInt(request.getParameter("professeur"+i));
		int idClasse = Integer.parseInt(request.getParameter("classe"+i));
		
		seance seance = new seance(i,idHoraire,idMatiere,idSalle,idProf,idClasse);
		seance.add();
	}
	response.sendRedirect( request.getContextPath() + "/admin/seance.jsp?ajouter=ok");
%>