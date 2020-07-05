<%@page import="miniProjetEmploiTemps.seance" %> 
<%@include file="include/head.jsp" %>
<%@include file="include/header.jsp" %>
<%@include file="include/nav.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="card-box">
             <h3 class="page-title">Liste des seances</h3>
            <div class="tab-content">
                <div class="tab-pane active" id="solid-rounded-justified-tab1">
                    <div class="card-block">
                        <div class="card-title">
                            <div class="text-right">
                                <a href="#" data-toggle="modal" data-target="#ajouter" class="btn btn-primary rounded">
                                    <i class="fa fa-plus"></i> Ajouter
                                </a>                     
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table id="dataHoraire" class="table table-striped table-bordered" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>filiere</th>
                                        <th>professeur</th>
                                        <th>salle</th>
                                        <th>matiere</th>
                                        <th>horaire</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<%
                                		String chaine = "";
                                		seance seance = new seance();
                                		ResultSet res = seance.affiche();
                                		while(res.next()) {
                                			chaine +="<tr><td>"+res.getString(2)+"</td><td>"+res.getString(3)+"</td><td>"+res.getString(4)+"</td><td>"+res.getString(5)+"</td><td>"+res.getString(6)+"</td>";
                                			chaine +="<td class='text-right'> <div class='dropdown'><a href='#' class='action-icon dropdown-toggle' data-toggle='dropdown' aria-expanded='false'><i class='fa fa-ellipsis-v'></i></a>"; 
                                			chaine +="<ul class='dropdown-menu pull-right'><li><a href='#' onclick='modifier("+res.getInt(1)+")' data-toggle='modal' data-target='#modifier'><i class='fa fa-pencil m-r-5'></i>Modifier</a></li>";
                                			chaine +="<li><a href='#' onclick='supp("+res.getInt(1)+")' data-toggle='modal' data-target='#supprimer'><i class='fa fa-trash-o m-r-5'></i>Supprime</a></li></ul></div></td></tr>";
                                    	}
                                		out.print(chaine);
                                	%>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>filiere</th>
                                        <th>professeur</th>
                                        <th>salle</th>
                                        <th>matiere</th>
                                        <th>horaire</th>
                                        <th>Action</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- model ajoute -->
    <div id="ajouter" class="modal custom-modal fade" role="dialog" style="display: none;">
        <div class="modal-dialog">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <div class="modal-content modal-lg">
                <div class="modal-header">
                    <h4 class="modal-title">Ajouter seance</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="POST" action="jsp/ajoute_seance.jsp">
                        <div class="row" id="ligne">
                            <div class="col-md-4">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">professeur</label>
	                                <div class="col-lg-9">
	                                    <select class="select select2etab" name="professeur1" required>
	                                		<%
                                            	res.close();
	                                            chaine = "";
	                                    		res = seance.professeur();
	                                    		while(res.next()) {
	                                    			chaine +="<option value='"+res.getInt(1)+"'>"+res.getString(2)+"</option>";
	                                    		}
	                                    		out.print(chaine);
                                            %>
	                                	</select>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">salle</label>
	                                <div class="col-lg-9">
	                                	<select class="select select2etab" name="salle1" required>
	                                		<%
                                            	res.close();
	                                            chaine = "";
	                                    		res = seance.salle();
	                                    		while(res.next()) {
	                                    			chaine +="<option value='"+res.getInt(1)+"'>"+res.getString(2)+"</option>";
	                                    		}
	                                    		out.print(chaine);
                                            %>
	                                	</select>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">classe</label>
	                                <div class="col-lg-9">
	                                	 <select class="select select2etab" name="classe1" required>
	                                		<%
                                            	res.close();
	                                            chaine = "";
	                                    		res = seance.classe();
	                                    		while(res.next()) {
	                                    			chaine +="<option value='"+res.getInt(1)+"'>"+res.getString(2)+"</option>";
	                                    		}
	                                    		out.print(chaine);
                                            %>
	                                	</select>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">matiere</label>
	                                <div class="col-lg-9">
	                                     <select class="select select2etab" name="matiere1" required>
	                                		<%
                                            	res.close();
	                                            chaine = "";
	                                    		res = seance.matiere();
	                                    		while(res.next()) {
	                                    			chaine +="<option value='"+res.getInt(1)+"'>"+res.getString(2)+"</option>";
	                                    		}
	                                    		out.print(chaine);
                                            %>
	                                	</select>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">horaire</label>
	                                <div class="col-lg-9">
	                                     <select class="select select2etab" name="horaire1" required>
	                                		<%
                                            	res.close();
	                                            chaine = "";
	                                    		res = seance.horaire();
	                                    		while(res.next()) {
	                                    			chaine +="<option value='"+res.getInt(1)+"'>"+res.getString(2)+"</option>";
	                                    		}
	                                    		out.print(chaine);
                                            %>
	                                	</select>
	                                </div>
	                            </div>
                            </div>
                        </div>
                        <input type="hidden" value="1" class="form-control" name="cp" id="cp">    
                        <div class="text-right">
                             <div class="col-md-3">
                                <button type="button" class="btn btn-info form-control" onclick="ajouterLigne();">
                                    Ajouter ligne
                                </button>
                            </div>
                             <div class="col-md-3">
                                <button type="submit" class="btn btn-primary form-control">
                                    Submit
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- end -->
    <!-- end -->
    <div id="modifier" class="modal custom-modal fade" role="dialog" style="display: none;">
        <div class="modal-dialog">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <div class="modal-content modal-lg">
                <div class="modal-header">
                    <h4 class="modal-title">Modifier salle</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="POST" action="jsp/modifier_salle.jsp">
                         <div class="row" >
                           <div class="col-md-4">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">professeur</label>
	                                <div class="col-lg-9">
	                                    <select class="select select2etab" name="professeur" id="professeur" required>
	                                		<%
                                            	res.close();
	                                            chaine = "";
	                                    		res = seance.professeur();
	                                    		while(res.next()) {
	                                    			chaine +="<option value='"+res.getInt(1)+"'>"+res.getString(2)+"</option>";
	                                    		}
	                                    		out.print(chaine);
                                            %>
	                                	</select>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">salle</label>
	                                <div class="col-lg-9">
	                                	<select class="select select2etab" name="salle" id="salle" required>
	                                		<%
                                            	res.close();
	                                            chaine = "";
	                                    		res = seance.salle();
	                                    		while(res.next()) {
	                                    			chaine +="<option value='"+res.getInt(1)+"'>"+res.getString(2)+"</option>";
	                                    		}
	                                    		out.print(chaine);
                                            %>
	                                	</select>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">classe</label>
	                                <div class="col-lg-9">
	                                	 <select class="select select2etab" name="classe" id="classe" required>
	                                		<%
                                            	res.close();
	                                            chaine = "";
	                                    		res = seance.classe();
	                                    		while(res.next()) {
	                                    			chaine +="<option value='"+res.getInt(1)+"'>"+res.getString(2)+"</option>";
	                                    		}
	                                    		out.print(chaine);
                                            %>
	                                	</select>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">matiere</label>
	                                <div class="col-lg-9">
	                                     <select class="select select2etab" name="matiere" id="matiere" required>
	                                		<%
                                            	res.close();
	                                            chaine = "";
	                                    		res = seance.matiere();
	                                    		while(res.next()) {
	                                    			chaine +="<option value='"+res.getInt(1)+"'>"+res.getString(2)+"</option>";
	                                    		}
	                                    		out.print(chaine);
                                            %>
	                                	</select>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">horaire</label>
	                                <div class="col-lg-9">
	                                     <select class="select select2etab" name="horaire" id="horaire" required>
	                                		<%
                                            	res.close();
	                                            chaine = "";
	                                    		res = seance.horaire();
	                                    		while(res.next()) {
	                                    			chaine +="<option value='"+res.getInt(1)+"'>"+res.getString(2)+"</option>";
	                                    		}
	                                    		out.print(chaine);
                                            %>
	                                	</select>
	                                </div>
	                            </div>
                            </div>
                        </div>
                        <input type="hidden" id="idSeance" name="idSeance">
                        <div class="row">
                            <div class="col-md-6">
                                <button type="submit" class="btn btn-primary form-control">
                                    Submit
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- end -->
	 <!-- model supprimer -->
    <div id="supprimer" class="modal custom-modal fade" role="dialog" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content modal-md">
                <div class="modal-header">
                    <h4 class="modal-title">Supprimer etudiant</h4>
                </div>
                <form method="POST" action="jsp/supprimer_seance.jsp">
                    <input type="hidden" id="idSup" name="idSup">
                    <div class="modal-body card-box">
                        <p>Voulez-vous vraiment supprimer ?</p>
                        <div class="m-t-20"> <a href="#" class="btn btn-default" data-dismiss="modal">Fermer</a>
                            <button type="submit" class="btn btn-danger">Supprimer</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
    	<%
			if(request.getParameter("ajouter") != null && !request.getParameter("ajouter").trim().isEmpty()) 
				out.println("Success('Horaire est bien ajouté')");
			
    	if(request.getParameter("modifier")!= null && !request.getParameter("modifier").trim().isEmpty()) 
			out.println("Success('Horaire est bien modifié')");
    	
    	if(request.getParameter("supprimer")!= null && !request.getParameter("supprimer").trim().isEmpty()) 
			out.println("Success('Horaire est bien supprimé')");

    	%>

        function Success(msg){
            swal({ title: msg, icon: "success", button: "Fermer",});
        }

        function ajouterLigne(){
            var cp = $("#cp").val();
            cp++;
            var data ='<div class="col-md-4"> <div class="form-group"> <label class="col-lg-3 control-label">professeur</label> <div class="col-lg-9"> <select class="select select2etab" name="professeur'+cp+'" required>';
            data +='<% res.close(); chaine= null; res= seance.professeur(); while(res.next()){chaine +="<option value="+res.getInt(1)+">"+res.getString(2)+"</option>";}out.print(chaine); %> </select> </div></div></div>';
            
            data +='<div class="col-md-4"> <div class="form-group"> <label class="col-lg-3 control-label">salle</label> <div class="col-lg-9"> <select class="select select2etab" name="salle'+cp+'" required> ';
            data +='<% res.close(); chaine= null; res= seance.salle(); while(res.next()){chaine +="<option value="+res.getInt(1)+">"+res.getString(2)+"</option>";}out.print(chaine); %> </select> </div></div></div>';
            
            data +=' <div class="col-md-4"> <div class="form-group"> <label class="col-lg-3 control-label">classe</label> <div class="col-lg-9"> <select class="select select2etab" name="classe'+cp+'" required>';
            data +='<% res.close(); chaine= null; res= seance.classe(); while(res.next()){chaine +="<option value="+res.getInt(1)+">"+res.getString(2)+"</option>";}out.print(chaine); %> </select> </div></div></div>';
            
            data +='  <div class="col-md-6"> <div class="form-group"> <label class="col-lg-3 control-label">matiere</label> <div class="col-lg-9"> <select class="select select2etab" name="matiere'+cp+'" required>';
            data +='<% res.close(); chaine= null; res= seance.matiere(); while(res.next()){chaine +="<option value="+res.getInt(1)+">"+res.getString(2)+"</option>";}out.print(chaine); %> </select> </div></div></div>';
            
            data +='<div class="col-md-6"> <div class="form-group"> <label class="col-lg-3 control-label">horaire</label> <div class="col-lg-9"> <select class="select select2etab" name="horaire'+cp+'" required>';
            data +='<% res.close(); chaine= null; res= seance.horaire(); while(res.next()){chaine +="<option value="+res.getInt(1)+">"+res.getString(2)+"</option>";}out.print(chaine); %> </select> </div></div></div>';
            
            $("#cp").attr("value",cp);
            $("#ligne").append(data);
            $(".select2etab").select2({
                width: "100%"
            });
        }
        function modifier(arg){
            $.ajax({
                type:"POST",
                cache: false,
                url:"jsp/update_seance.jsp",
                data:{id:arg},
                dataType:"html",
                success:function(data){
                    const d = data
                    const w = d.split('/');
                    $("#idSeance").val(w[0].trim()).change();
                    $("#matiere").val(w[1].trim()).change();
                    $("#salle").val(w[2].trim()).change();
                    $("#classe").val(w[3].trim()).change();
                    $("#professeur").val(w[4].trim()).change();
                    $("#horaire").val(w[5].trim()).change();
                }
            });    
        }

        function supp(id,arg) {
            document.querySelector("#idSup").setAttribute("value", id);
        }
    </script>
</div>
</div>
</div>
</div>
<div class="sidebar-overlay" data-reff=""></div>
<%@include file="include/footre.jsp" %>