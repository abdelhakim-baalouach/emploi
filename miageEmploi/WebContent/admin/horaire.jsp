<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/head.jsp" />
<jsp:include page="include/nav.jsp" />
	<div class="wrapper">
       <div class="container-fluid">
			<div class="row">
                <div class="col-12">
                	<div class="page-title-box">
                        <div class="text-right">
                        	<a href="#" class="btn btn-primary waves-effect w-md mr-2 mb-2" data-toggle="modal" data-target="#Ajouter">
                               <i class="dripicons-plus mr-1"></i> Ajouter
                        	</a>
                        </div>
                    </div>
                    <div class="card-box table-responsive">
                    	<h3 class="m-t-0 header-title">Liste des horaires</h3>
                        <table id="datatable-buttons" class="table table-hover m-0 tickets-list table-actions-bar dt-responsive nowrap" cellspacing="0" width="100%">
                            <thead>
	                            <tr>
	                                <th>#</th>
	                                <th>Heure debut</th>
	                                <th>Heure fin</th>
	                                <th>Jour</th>
	                                <th>Action</th>
	                            </tr>
                            </thead>
                            <tbody>
                            	<c:out value="${html}" escapeXml="false"/>                          
                            </tbody>
                            <tfoot>
	                            <tr>
	                                <th>#</th>
	                                <th>Heure debut</th>
	                                <th>Heure fin</th>
	                                <th>Jour</th>
	                                <th>Action</th>
	                            </tr>
	                        </tfoot>
                        </table>
                    </div>
                </div>
            </div>
       </div> <!-- end container -->
   </div>
   <!-- end wrapper -->
   <!--  Modal content for the above example -->
   <div id="Ajouter" class="modal fade" role="dialog" aria-labelledby="add" aria-hidden="true" style="display: none;">
       <div class="modal-dialog modal-lg">
           <div class="modal-content">
               <div class="modal-header">
                   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                   <h4 class="modal-title" id="add">Ajouter horaire</h4>
               </div>
               <div class="modal-body">
                   <form class="form-horizontal" method="POST" action="ajouter-horaire.html">
			         <div class="row" id="ligne">
			         	<div class="col-md-12">
			         		<h4>Heure</h4>
			         	</div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Debut</label>
                                <div class="col-lg-9">
                                    <div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
                                        <input type="text" class="form-control" name="heureDebut1" placeholder="Heure Debut" required>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-time"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Fin</label>
                                <div class="col-lg-9">
                                    <div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
                                        <input type="text" class="form-control" name="heureFin1" placeholder="Heure Fin" required>
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
                                <div class="col-lg-9">
                                    <select class="form-control select2-jour" name="jour1">
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
                    <div class="button-list text-right" style="padding-right: 50px;">
                         <button type="button" class="btn btn-facebook waves-effect waves-light" id="addLine">
                             Ajouter ligne
                         </button>

                         <button type="Submit" class="btn btn-twitter waves-effect waves-light">
                             Submit
                         </button>
                     </div>
			      </form>
               </div>
           </div><!-- /.modal-content -->
       </div><!-- /.modal-dialog -->
   </div>
   <!-- /.modal -->
      <!--  Modal content for the above example -->
   <div id="Modifier" class="modal fade" role="dialog" aria-labelledby="update" aria-hidden="true" style="display: none;">
       <div class="modal-dialog modal-lg">
           <div class="modal-content">
               <div class="modal-header">
                   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                   <h4 class="modal-title" id="update">Modifier horaire</h4>
               </div>
               <div class="modal-body">
               	 <form class="form-horizontal" method="POST" action="modifier-horaire.html">
                   <div class="row" >
                   		<div class="col-md-12">
			         		<h4>Heure</h4>
			         	</div>
                       <div class="col-md-4">
                   		<div class="form-group">
                        	<label class="col-lg-3 control-label">Debut</label>
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
                                <label class="col-lg-3 control-label">Fin</label>
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
                               <div class="col-lg-9">
                                   <select class="select select2-jour" name="jour" id="jour" required>
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
                   <div class="button-list text-right" style="padding-right: 50px;">
                         <button type="Submit" class="btn btn-twitter waves-effect waves-light">
                             Submit
                         </button>
                     </div>
                 </form>
               </div>
           </div><!-- /.modal-content -->
       </div><!-- /.modal-dialog -->
   </div>
   <!-- /.modal -->
    <!-- model supprimer -->
    <div id="supprimer" class="modal custom-modal fade" role="dialog" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content modal-md">
                <div class="modal-header">
                 	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">Supprimer Horaire</h4>
                </div>
                <form method="POST" action="delete-horaire.html">
                    <input type="hidden" id="idSup" name="idSup">
                    <div class="modal-body card-box">
                        <p>Voulez-vous vraiment supprimer ?</p>
                        <div class="m-t-20"> 
                        	<a href="#" class="btn btn-success btn-rounded waves-light waves-effect" data-dismiss="modal">Fermer</a>
                            <button type="submit" class="btn btn-danger btn-rounded waves-light waves-effect">Supprimer</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- end -->
<jsp:include page="include/footer.jsp" />
<jsp:include page="include/script.jsp" />
<script type="text/javascript">
    $(document).ready(function() {

        //Buttons examples
        var table = $('#datatable-buttons').DataTable({
       		"language": {
                 "decimal":        "",
                 "emptyTable":     "Aucune donnée disponible dans la table",
                 "infoFiltered":   "(filtré du nombre total d'entrées)",
                 "infoEmpty":      "Affiche 0 à 0 de 0 entrées",
                 "lengthMenu":     "",
                 "info": "Afficher la page _PAGE_ de _PAGES_",
                 "loadingRecords": "Chargement...",
                 "processing":     "En traitement...",
                 "search":         "Chercher :",
                 "zeroRecords":    "Aucun enregistrements correspondants trouvés",
                 "paginate": {
                     "first":      "Premier",
                     "last":       "Dernier",
                     "next":       "Suivant",
                     "previous":   "Précédent"
                 },
                 "aria": {
                     "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                     "sortDescending": ": Activer pour trier la colonne par ordre décroissant"
                 }
            },
            lengthChange: false,
            buttons: ['excel', 'pdf']
        });

        table.buttons().container()
                .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
        $(".select2-jour").select2();
        $('.clockpicker').clockpicker({});

        $( "#addLine" ).click(function() {
        	 var cp = $("#cp").val();
             cp++;
             var data = '<div class="col-md-4"><div class="form-group"><label class="col-lg-3 control-label">Debut</label> <div class="col-lg-9"> <div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true"> <input type="text" class="form-control" name="heureDebut'+cp+'" placeholder="Heure Debut" required> <span class="input-group-addon"> <span class="glyphicon glyphicon-time"></span> </span> </div></div></div></div><div class="col-md-4"> <div class="form-group"> <label class="col-lg-3 control-label">Fin</label> <div class="col-lg-9"> <div class="input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true"> <input type="text" class="form-control" name="heureFin'+cp+'" placeholder="Heure Fin" required> <span class="input-group-addon"> <span class="glyphicon glyphicon-time"></span> </span> </div></div></div></div><div class="col-md-4"> <div class="form-group"> <label class="col-lg-3 control-label">Jour</label> <div class="col-lg-9 unver-etab"> <select class="select select2-jour" name="jour'+cp+'"> <option value="lundi">lundi</option> <option value="mardi">mardi</option> <option value="mercredi">mercredi</option> <option value="jeudi">jeudi</option> <option value="vendredi">vendredi</option> <option value="samedi">samedi</option> <option value="dimanche">dimanche</option> </select> </div></div></div>';
             $("#cp").attr("value",cp);
             $("#ligne").append(data);
             $(".select2-jour").select2({
                 width: "100%"
             });
             $('.clockpicker').clockpicker({});

       	});
        
        $( ".modifier" ).click(function() {
			$.ajax({
	        	url     : 'update-horaire.html',
	        	method  : 'POST',
	        	data    : {id : this.getAttribute("data-update")},
	        	success : function(resultText){
                    const w = resultText.split('/');
	        		$("#idHoraire").attr("value",w[0].trim());
                    $("#heureDebut").attr("value",w[1].trim());
                    $("#heureFin").attr("value",w[2].trim());
                    $("#jour").val(w[3].trim()).change();
	        	},
	        	error : function(jqXHR, exception){
	        		console.log('Error occured!!');
	        	}
        	});
        });
        $( ".delete" ).click(function() {
        	document.querySelector("#idSup").setAttribute("value", this.getAttribute("data-delete"));
        });
    } );

</script>
<jsp:include page="include/fin.jsp" />