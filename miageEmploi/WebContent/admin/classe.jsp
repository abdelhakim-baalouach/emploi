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
                    	<h3 class="m-t-0 header-title">Liste des classes</h3>
                        <table id="datatable-buttons" class="table table-hover m-0 tickets-list table-actions-bar dt-responsive nowrap" cellspacing="0" width="100%">
                            <thead>
	                            <tr>
	                                <th>#</th>
                                    <th>filiere</th>
                                    <th>nom</th>
                                    <th>niveau</th>
                                    <th>abreviation</th>
                                    <th>Action</th>
	                            </tr>
                            </thead>
                            <tbody>
                            	<c:out value="${html}" escapeXml="false"/>                          
                            </tbody>
                            <tfoot>
	                            <th>#</th>
                                <th>filiere</th>
                                <th>nom</th>
                                <th>niveau</th>
                                <th>abreviation</th>
                                <th>Action</th>
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
                   <h4 class="modal-title" id="add">Ajouter classe</h4>
               </div>
               <div class="modal-body">
                   <form class="form-horizontal" method="POST" action="ajouter-classe.html">
			         <div class="row" id="ligne">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Nom</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                        <input type="text" class="form-control" name="nom1" placeholder="Nom classe" required>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-time"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Abreviation</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                        <input type="text" class="form-control" name="abrv1" placeholder="L'abreviation" required>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-time"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Niveau</label>
                                <div class="col-lg-9">
                                    <select class="form-control select2-jour" name="niveau1">
                                        <option value="1">1er année</option>
                                		<option value="2">2ème année</option>
                                		<option value="3">3ème année</option>
                                		<option value="4">4ème année</option>
                                		<option value="5">5ème année</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Filiere</label>
                                <div class="col-lg-9">
                                    <select class="form-control select2-jour" name="filiere1">
                                        <c:out value="${filiere}" escapeXml="false"/>     
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
                   <h4 class="modal-title" id="update">Modifier classe</h4>
               </div>
               <div class="modal-body">
               	 <form class="form-horizontal" method="POST" action="modifier-classe.html">
                   <div class="row" >
                   		<div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Nom</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                        <input type="text" class="form-control" name="nom" id="nom" placeholder="Nom classe" required>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-time"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Abreviation</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                        <input type="text" class="form-control" name="abrv" id="abrv" placeholder="L'abreviation" required>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-time"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Niveau</label>
                                <div class="col-lg-9">
                                    <select class="form-control select2-jour" name="niveau" id="niveau">
                                        <option value="1">1er année</option>
                                		<option value="2">2ème année</option>
                                		<option value="3">3ème année</option>
                                		<option value="4">4ème année</option>
                                		<option value="5">5ème année</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Filiere</label>
                                <div class="col-lg-9">
                                    <select class="form-control select2-jour" name="filiere" id="filiere">
                                        <c:out value="${filiere}" escapeXml="false"/>     
                                    </select>
                                </div>
                            </div>
                        </div> 
                   </div>
                   <input type="hidden" id="idClasse" name="idClasse">
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
                    <h4 class="modal-title">Supprimer classe</h4>
                </div>
                <form method="POST" action="delete-classe.html">
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

        $( "#addLine" ).click(function() {
        	 var cp = $("#cp").val();
             cp++;
             var data = '<div class="col-md-6"> <div class="form-group"> <label class="col-lg-3 control-label">Nom</label> <div class="col-lg-9"> <div class="input-group" data-placement="left" data-align="top" data-autoclose="true"> <input type="text" class="form-control" name="nom'+cp+'" placeholder="Nom classe" required> <span class="input-group-addon"> <span class="glyphicon glyphicon-time"></span> </span> </div> </div> </div> </div> <div class="col-md-6"> <div class="form-group"> <label class="col-lg-3 control-label">Abreviation</label> <div class="col-lg-9"> <div class="input-group" data-placement="left" data-align="top" data-autoclose="true"> <input type="text" class="form-control" name="abrv'+cp+'" placeholder="L\'abreviation" required> <span class="input-group-addon"> <span class="glyphicon glyphicon-time"></span> </span> </div> </div> </div> </div> <div class="col-md-6"> <div class="form-group"> <label class="col-lg-3 control-label">Niveau</label> <div class="col-lg-9"> <select class="form-control select2-jour" name="niveau'+cp+'"> <option value="1">1er année</option> <option value="2">2ème année</option> <option value="3">3ème année</option> <option value="4">4ème année</option> <option value="5">5ème année</option> </select> </div> </div> </div> <div class="col-md-6"> <div class="form-group"> <label class="col-lg-3 control-label">Filiere</label> <div class="col-lg-9"> <select class="form-control select2-jour" name="filiere'+cp+'"> <c:out value="${filiere}" escapeXml="false"/> </select> </div> </div> </div> ';
           	 $("#cp").attr("value",cp);
             $("#ligne").append(data);
             $(".select2-jour").select2({
                 width: "100%"
             });

       	});
        
        $( ".modifier" ).click(function() {
			$.ajax({
	        	url     : 'update-classe.html',
	        	method  : 'POST',
	        	data    : {id : this.getAttribute("data-update")},
	        	success : function(resultText){
                    const w = resultText.split('/');
	        		$("#idClasse").attr("value",w[0].trim());
                    $("#nom").attr("value",w[1].trim());
                    $("#abrv").attr("value",w[2].trim());
                    $("#niveau").val(w[3].trim()).change();
                    $("#filiere").val(w[4].trim()).change();
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