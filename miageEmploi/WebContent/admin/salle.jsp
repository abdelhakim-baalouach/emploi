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
                    	<h3 class="m-t-0 header-title">Liste des salles</h3>
                        <table id="datatable-buttons" class="table table-hover m-0 tickets-list table-actions-bar dt-responsive nowrap" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>num</th>
                                    <th>etage</th>
                                    <th>type</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:out value="${html}" escapeXml="false"/>                          
                            </tbody>
                            <tfoot>
	                           <tr>
                                    <th>#</th>
                                    <th>num</th>
                                    <th>etage</th>
                                    <th>type</th>
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
                   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
                   <h4 class="modal-title" id="add">Ajouter salle</h4>
               </div>
               <div class="modal-body">
                   <form class="form-horizontal" method="POST" action="ajouter-salle.html">
			         <div class="row" id="ligne">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Numero</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                        <input type="text" class="form-control" name="num1" placeholder="Num salle" required>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-time"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Etage</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                        <input type="number" value="1" min="1" max="10" step="1" class="form-control" name="etage1" required>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-time"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Type salle</label>
                                <div class="col-lg-9">
                                    <textarea class="form-control" maxlength="225" rows="3" name="type1" placeholder="Type salle"></textarea>
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
                   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
                   <h4 class="modal-title" id="update">Modifier salle</h4>
               </div>
               <div class="modal-body">
               	 <form class="form-horizontal" method="POST" action="modifier-salle.html">
                    <div class="row" >
                           <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">Numero</label>
	                                <div class="col-lg-9">
	                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
	                                        <input type="text" class="form-control" id="num" name="num" placeholder="Num salle" required>
	                                        <span class="input-group-addon">
	                                            <span class="glyphicon glyphicon-time"></span>
	                                        </span>
	                                    </div>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">Etage</label>
	                                <div class="col-lg-9">
	                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
	                                        <input type="number" value="1" min="1" max="10" step="1" class="form-control" id="etage" name="etage" required>
	                                        <span class="input-group-addon">
	                                            <span class="glyphicon glyphicon-time"></span>
	                                        </span>
	                                    </div>
	                                </div>
	                            </div>
                            </div>
                           	<div class="col-md-12">
                            	<div class="form-group">
	                                <label class="col-lg-3 control-label">Type salle</label>
	                                <div class="col-lg-9">
	                                    <textarea class="form-control" maxlength="225" rows="3" id="type" name="type" placeholder="Type salle"></textarea>
	                                </div>
	                            </div>
	                        </div>
                        </div>
                        <input type="hidden" id="idSalle" name="idSalle">
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
                 	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
                    <h4 class="modal-title">Supprimer Horaire</h4>
                </div>
                <form method="POST" action="delete-salle.html">
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
                 "emptyTable":     "Aucune donn�e disponible dans la table",
                 "infoFiltered":   "(filtr� du nombre total d'entr�es)",
                 "infoEmpty":      "Affiche 0 � 0 de 0 entr�es",
                 "lengthMenu":     "",
                 "info": "Afficher la page _PAGE_ de _PAGES_",
                 "loadingRecords": "Chargement...",
                 "processing":     "En traitement...",
                 "search":         "Chercher :",
                 "zeroRecords":    "Aucun enregistrements correspondants trouv�s",
                 "paginate": {
                     "first":      "Premier",
                     "last":       "Dernier",
                     "next":       "Suivant",
                     "previous":   "Pr�c�dent"
                 },
                 "aria": {
                     "sortAscending":  ": Activer pour trier la colonne par ordre croissant",
                     "sortDescending": ": Activer pour trier la colonne par ordre d�croissant"
                 }
            },
            lengthChange: false,
            buttons: ['excel', 'pdf']
        });

        table.buttons().container()
                .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');

        $( "#addLine" ).click(function() {
        	 var cp = $("#cp").val();
             cp++;
             var data = '<div class="col-md-6"> <div class="form-group"> <label class="col-lg-3 control-label">Numero</label> <div class="col-lg-9"> <div class="input-group" data-placement="left" data-align="top" data-autoclose="true"> <input type="text" class="form-control" name="num'+cp+'" placeholder="Num salle" required> <span class="input-group-addon"> <span class="glyphicon glyphicon-time"></span> </span> </div> </div> </div> </div> <div class="col-md-6"> <div class="form-group"> <label class="col-lg-3 control-label">Etage</label> <div class="col-lg-9"> <div class="input-group" data-placement="left" data-align="top" data-autoclose="true"> <input type="number" value="1" min="1" max="10" step="1" class="form-control" name="etage'+cp+'" required> <span class="input-group-addon"> <span class="glyphicon glyphicon-time"></span> </span> </div> </div> </div> </div> <div class="col-md-12"> <div class="form-group"> <label class="col-lg-3 control-label">Type salle</label> <div class="col-lg-9"> <textarea class="form-control" maxlength="225" rows="3" name="type'+cp+'" placeholder="Type salle"></textarea> </div> </div> </div>';
             $("#cp").attr("value",cp);
             $("#ligne").append(data);

       	});
        
        $( ".modifier" ).click(function() {
			$.ajax({
	        	url     : 'update-salle.html',
	        	method  : 'POST',
	        	data    : {id : this.getAttribute("data-update")},
	        	success : function(resultText){
                    const w = resultText.split('/');
	        		$("#idSalle").attr("value",w[0].trim());
                    $("#num").attr("value",w[1].trim());
                    $("#etage").attr("value",w[2].trim());
                    $("#type").val(w[3].trim());
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