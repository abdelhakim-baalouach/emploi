<%@page import="miniProjetEmploiTemps.horaire" %> 
<%@include file="include/head.jsp" %>
<%@include file="include/header.jsp" %>
<%@include file="include/nav.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="card-box">
             <h3 class="page-title">Liste des horaires</h3>
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
                                        <th>#</th>
                                        <th>Heure debut</th>
                                        <th>Heure fin</th>
                                        <th>jour</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<%
                                		String chaine = "";
                                		horaire horaire = new horaire();
                                		ResultSet res = horaire.affiche();
                                		while(res.next()) {
                                			chaine +="<tr><td>"+res.getInt(1)+"</td><td>"+res.getString(2)+"</td><td>"+res.getString(3)+"</td><td>"+res.getString(4)+"</td>";
                                			chaine +="<td class='text-right'> <div class='dropdown'><a href='#' class='action-icon dropdown-toggle' data-toggle='dropdown' aria-expanded='false'><i class='fa fa-ellipsis-v'></i></a>"; 
                                			chaine +="<ul class='dropdown-menu pull-right'><li><a href='#' onclick='modifier("+res.getInt(1)+")' data-toggle='modal' data-target='#modifier'><i class='fa fa-pencil m-r-5'></i>Modifier</a></li>";
                                			chaine +="<li><a href='#' onclick='supp("+res.getInt(1)+")' data-toggle='modal' data-target='#supprimer'><i class='fa fa-trash-o m-r-5'></i>Supprime</a></li></ul></div></td></tr>";
                                    	}
                                		out.print(chaine);
                                	%>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>#</th>
                                        <th>Horaire debut</th>
                                        <th>Horaire fin</th>
                                        <th>jour</th>
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
    <!-- avant -->
    <!-- model ajoute -->
    <div id="ajouter" class="modal custom-modal fade" role="dialog" style="display: none;">
        <div class="modal-dialog">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <div class="modal-content modal-lg">
                <div class="modal-header">
                    <h4 class="modal-title">Ajouter Horaire</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="POST" action="jsp/ajoute_horaire.jsp">
                        <div class="row" id="ligne">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Heure debut</label>
                                    <div class="col-lg-9">
                                        <div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
                                            <input type="text" class="form-control" id="heure" name="heureDebut" placeholder="Heure Debut" required>
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-time"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Heure fin</label>
                                    <div class="col-lg-9">
                                        <div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
                                            <input type="text" class="form-control" id="heure" name="heureFin" placeholder="Heure Fin" required>
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-time"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Jour</label>
                                    <div class="col-lg-9 unver-etab">
                                        <select class="select select2etab" name="jour" required>
                                            <option value="lundi">lundi</option>
                                            <option value="mardi">mardi</option>
                                            <option value="mercredi">mercredi</option>
                                            <option value="jeudi">jeudi</option>
                                            <option value="vendredi">vendredi</option>
                                            <option value="samedi">samedi</option>
                                            <option value="dimanche">dimanche</option>
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
    <div id="modifier" class="modal custom-modal fade" role="dialog" style="display: none;">
        <div class="modal-dialog">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <div class="modal-content modal-lg">
                <div class="modal-header">
                    <h4 class="modal-title">Modifier consultation</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="POST" action="jsp/modifier_horaire.jsp">
                         <div class="row" >
                            <div class="col-md-4">
	                        	<div class="form-group">
	                             	<label class="col-lg-3 control-label">Heure debut</label>
	                                <div class="col-lg-9">
	                                	<div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
	                                    	<input type="text" class="form-control" id="heureDebut" name="heureDebut" placeholder="Heure Debut" required>
	                                        <span class="input-group-addon">
	                                	        <span class="glyphicon glyphicon-time"></span>
	                                        </span>
	                                    </div>
	                                </div>
	                            </div>
	                       	</div>
	                        <div class="col-md-4">
	                        	<div class="form-group">
	                                    <label class="col-lg-3 control-label">Heure fin</label>
	                                    <div class="col-lg-9">
	                                        <div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
	                                            <input type="text" class="form-control" id="heureFin" name="heureFin" placeholder="Heure Fin" required>
	                                            <span class="input-group-addon">
	                                                <span class="glyphicon glyphicon-time"></span>
	                                            </span>
	                                        </div>
	                                    </div>
	                                </div>
	                        </div>
	                        <div class="col-md-4">
	                                <div class="form-group">
	                                    <label class="col-lg-3 control-label">Jour</label>
	                                    <div class="col-lg-9 unver-etab">
	                                        <select class="select select2etab" name="jour" id="jour" required>
	                                            <option value="lundi">lundi</option>
	                                            <option value="mardi">mardi</option>
	                                            <option value="mercredi">mercredi</option>
	                                            <option value="jeudi">jeudi</option>
	                                            <option value="vendredi">vendredi</option>
	                                            <option value="samedi">samedi</option>
	                                            <option value="dimanche">dimanche</option>
	                                        </select>
	                                    </div>
	                                </div>
	                            </div>

                        </div>
                        <input type="hidden" id="idHoraire" name="idHoraire">
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
                    <h4 class="modal-title">Supprimer horaire</h4>
                </div>
                <form method="POST" action="jsp/supprimer_horaire.jsp">
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

        function modifier(arg,arg1,arg2){
            $('#patient option[value="'+arg2+'"]').prop('selected', "selected");  
            $('#tarif option[value="'+arg1+'"]').prop('selected', "selected");
            $("#idCons").attr("value",arg);
        }
        function ajouterLigne(){
            var cp = $("#cp").val();
            cp++;
            var data = '<div class="col-md-4"><div class="form-group"><label class="col-lg-3 control-label">Heure debut</label> <div class="col-lg-9"> <div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true"> <input type="text" class="form-control" id="heure" name="heureDebut" placeholder="Heure Debut" required> <span class="input-group-addon"> <span class="glyphicon glyphicon-time"></span> </span> </div></div></div></div><div class="col-md-4"> <div class="form-group"> <label class="col-lg-3 control-label">Heure fin</label> <div class="col-lg-9"> <div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true"> <input type="text" class="form-control" id="heure" name="heureFin" placeholder="Heure Fin" required> <span class="input-group-addon"> <span class="glyphicon glyphicon-time"></span> </span> </div></div></div></div><div class="col-md-4"> <div class="form-group"> <label class="col-lg-3 control-label">Jour</label> <div class="col-lg-9 unver-etab"> <select class="select select2etab" name="jour" required> <option value="lundi">lundi</option> <option value="mardi">mardi</option> <option value="mercredi">mercredi</option> <option value="jeudi">jeudi</option> <option value="vendredi">vendredi</option> <option value="samedi">samedi</option> <option value="dimanche">dimanche</option> </select> </div></div></div>';
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
                url:"jsp/update_horaire.jsp",
                data:{id:arg},
                dataType:"html",
                success:function(data){
                    const d = data
                    const w = d.split('/');
                    $("#idHoraire").attr("value",w[0].trim());
                    $("#heureDebut").attr("value",w[1].trim());
                    $("#heureFin").attr("value",w[2].trim());
                    $("#jour").val(w[3].trim()).change();
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