<%@page import="miniProjetEmploiTemps.emploi" %> 
<%@include file="include/head.jsp" %>
<%@include file="include/header.jsp" %>
<%@include file="include/nav.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="card-box">
             <h3 class="page-title">emploi de temps "ILTI" exemple</h3>
            <div class="tab-content">
                <div class="tab-pane active" id="solid-rounded-justified-tab1">
                    <div class="card-block">
                        <div class="card-title">
                            <div class="text-right">
                                                   
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>jour</th>
                                        <th>08:30 -- 10:15</th>
                                        <th>10:30 -- 11:45</th>
                                        <th>12:00 -- 13:30</th>
                                        <th>14:15 -- 15:45</th>
                                        <th>16:00 -- 17:30</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<%
                                		String[] jour = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"}; 
                                		String tableau = "";
                                		for(String str : jour){
                                			emploi emploi = new emploi();
	                                    	ResultSet resultat= emploi.affiche(str, 3);
	                                    	while (resultat.next()) {
	                            				tableau +="<tr><td>"+str+"</td>";
	                            				
	                            				if (resultat.getString(5).trim().equals("08:30--10:15")) {
	                            					tableau +="<td>"+resultat.getString(1)+"<br>"+resultat.getString(4)+"<br>"+resultat.getString(2)+"-"+resultat.getString(3)+"</td>";
	                            				}else {
	                            					tableau +="<td></td>";
	                            				}
	                            				
	                            				if (resultat.getString(5).trim().equals("10:30--11:45")) {
	                            					tableau +="<td>"+resultat.getString(1)+"<br>"+resultat.getString(4)+"<br>"+resultat.getString(2)+"-"+resultat.getString(3)+"</td>";
	                            				}else {
	                            					tableau +="<td></td>";
	                            				}
	                            				
	                            				if (resultat.getString(5).trim().equals("12:00--13:30")) {
	                            					tableau +="<td>"+resultat.getString(1)+"<br>"+resultat.getString(4)+"<br>"+resultat.getString(2)+"-"+resultat.getString(3)+"</td>";
	                            				}else {
	                            					tableau +="<td></td>";
	                            				}
	                            				
	                            				if (resultat.getString(5).trim().equals("14:15--15:45")) {
	                            					tableau +="<td>"+resultat.getString(1)+"<br>"+resultat.getString(4)+"<br>"+resultat.getString(2)+"-"+resultat.getString(3)+"</td>";
	                            				}else {
	                            					tableau +="<td></td>";
	                            				}
	                            				
	                            				if (resultat.getString(5).trim().equals("16:00--17:30")) {
	                            					tableau +="<td>"+resultat.getString(1)+"<br>"+resultat.getString(4)+"<br>"+resultat.getString(2)+"-"+resultat.getString(3)+"</td>";
	                            				}else {
	                            					tableau +="<td></td>";
	                            				}
	                            				tableau +="</tr>";
	                            			}
                                		}
                                		out.print(tableau);
                                	%>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>jour</th>
                                        <th>08:30 -- 10:15</th>
                                        <th>10:30 -- 11:45</th>
                                        <th>12:00 -- 13:30</th>
                                        <th>14:15 -- 15:45</th>
                                        <th>16:00 -- 17:30</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="include/footre.jsp" %>