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
                    	<h3 class="m-t-0 header-title">Liste des utilisateurs</h3>
                        <ul class="nav nav-tabs tabs-bordered nav-justified">
                            <li class="nav-item">
                                <a href="#etudiant" data-toggle="tab" aria-expanded="false" class="nav-link active show">
                                    <i class="fi-head mr-2"></i> Les étudiants
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#professeur" data-toggle="tab" aria-expanded="true" class="nav-link">
                                    <i class="fi-head mr-2"></i> les professeurs 
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#administrateur" data-toggle="tab" aria-expanded="false" class="nav-link">
                                    <i class="fi-head mr-2"></i> les administrateurs
                                </a>
                            </li>
                        </ul>
                        <div class="tab-content">
                           <div class="tab-pane active show" id="etudiant">
		                       <table class="datatable table table-hover m-0 tickets-list table-actions-bar dt-responsive nowrap" cellspacing="0" width="100%">
		                           <thead>
			                            <tr>
			                                <th>#</th>
		                                    <th>login</th>
		                                    <th>Nom complet</th>
		                                    <th>email</th>
		                                    <th>telephone</th>
		                                    <th>Action</th>
			                            </tr>
		                           </thead>
		                           <tbody>
		                           		<c:out value="${etudiant}" escapeXml="false"/>                          
		                           </tbody>
			                       <tfoot>
			                            <tr>
			                                <th>#</th>
			                                <th>login</th>
			                                <th>Nom complet</th>
			                                <th>email</th>
			                                <th>telephone</th>
			                                <th>Action</th>
			                            </tr>
			                       </tfoot>
		                       </table>
                            </div>
                            <div class="tab-pane" id="professeur">
                            	<table class="datatable table table-hover m-0 tickets-list table-actions-bar dt-responsive nowrap" cellspacing="0" width="100%">
		                           <thead>
			                            <tr>
			                                <th>#</th>
		                                    <th>login</th>
		                                    <th>Nom complet</th>
		                                    <th>email</th>
		                                    <th>telephone</th>
		                                    <th>Action</th>
			                            </tr>
		                           </thead>
		                           <tbody>
		                           		<c:out value="${professeur}" escapeXml="false"/>                          
		                           </tbody>
			                       <tfoot>
			                            <tr>
			                                <th>#</th>
			                                <th>login</th>
			                                <th>Nom complet</th>
			                                <th>email</th>
			                                <th>telephone</th>
			                                <th>Action</th>
			                            </tr>
			                       </tfoot>
		                       </table>
                            </div>
                            <div class="tab-pane" id="administrateur">
                            	<table class="datatable table table-hover m-0 tickets-list table-actions-bar dt-responsive nowrap" cellspacing="0" width="100%">
		                           <thead>
			                            <tr>
			                                <th>#</th>
		                                    <th>login</th>
		                                    <th>Nom complet</th>
		                                    <th>email</th>
		                                    <th>telephone</th>
		                                    <th>Action</th>
			                            </tr>
		                           </thead>
		                           <tbody>
		                           		<c:out value="${administrateur}" escapeXml="false"/>                          
		                           </tbody>
			                       <tfoot>
			                            <tr>
			                                <th>#</th>
			                                <th>login</th>
			                                <th>Nom complet</th>
			                                <th>email</th>
			                                <th>telephone</th>
			                                <th>Action</th>
			                            </tr>
			                       </tfoot>
		                       </table>
                            </div>
                        </div>
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
                   <h4 class="modal-title" id="add">Ajouter utilisateur</h4>
               </div>
               <div class="modal-body">
                   <form class="form-horizontal" method="POST" action="ajouter-utilisateur.html">
			         <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Login</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                         <input type="text" class="form-control login-valide" name="login" placeholder="Login" required>
                                    </div>
                                    <h6 class="validation"></h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Email</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                        <input type="email" class="form-control" name="email" placeholder="exemple@etud.iga.ac.ma" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"  title="Exemple : exemple@etud.iga.ac.ma"  required>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Nom</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                         <input type="text" class="form-control" name="nom" placeholder="Nom" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Prenom</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                        <input type="text" class="form-control" name="prenom" placeholder="Prenom" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                         <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Telephone</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                         <input type="tel" pattern="[0][5-6][0-9]{8}" placeholder="0606060606" title="Exemple : 0600112233" name="telephone" maxlength="10" class="form-control" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Type</label>
                                <div class="col-lg-9">
                                    <div class="input-group" data-placement="left" data-align="top" data-autoclose="true">
                                        <select class="form-control select2-jour" name="type">
	                                        <option value="etudiant">Etudiant</option>
	                                    	<option value="professeur">Professeur</option>
	                                    	<option value="administrateur">Administrateur</option> 
	                                    </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="button-list text-right" style="padding-right: 50px;">
                         <button type="button" class="btn btn-twitter waves-effect waves-light change">
                             Submit
                         </button>
                     </div>
			      </form>
               </div>
           </div><!-- /.modal-content -->
       </div><!-- /.modal-dialog -->
   </div>
   <!-- /.modal -->

    <!-- model Modifier -->
    <div id="Modifier" class="modal custom-modal fade" role="dialog" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content modal-md">
                <div class="modal-header">
                 	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">Modifier Mot de passe</h4>
                </div>
                <form method="POST" action="modifiere-utilisateur.html">
                    <input type="hidden" id="idMod" name="idMod">
                    <div class="modal-body card-box">
                        <p>Voulez-vous vraiment modifier le mot de passe ?</p>
                        <div class="m-t-20"> 
                        	<a href="#" class="btn btn-success btn-rounded waves-light waves-effect" data-dismiss="modal">Fermer</a>
                            <button type="submit" class="btn btn-danger btn-rounded waves-light waves-effect">Modifier</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- end -->
     <!-- model supprimer -->
    <div id="supprimer" class="modal custom-modal fade" role="dialog" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content modal-md">
                <div class="modal-header">
                 	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">Supprimer utilisateur</h4>
                </div>
                <form method="POST" action="delete-utilisateur.html">
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
        var table = $('.datatable').DataTable({
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
            lengthChange: false
        });

        table.buttons().container()
                .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
        $(".select2-jour").select2();
        
        $( ".login-valide" ).keyup(function() {
        	if ($(".login-valide").val().length >= 5) {
        		$.ajax({
    	        	url     : 'valide-login.html',
    	        	method  : 'POST',
    	        	data    : {login : $(".login-valide").val()},
    	        	success : function(resultText){
    	        		if ( resultText=="true") {
    	        			$('.change').attr("type","submit");
    	        			$(".validation").html('<span class="text-success"><i class="mdi mdi-checkbox-marked-circle-outline">Login valid</i></span>');
    	     			}else {
    	     				$('.change').attr("type","button");
    	     				$(".validation").html('<span class="text-danger"> <i class="mdi mdi-close-circle-outline">non valide</i> </span>');
    	    			}
    	        	},
    	        	error : function(jqXHR, exception){
    	        		console.log('Error occured!!');
    	        	}
            	});
			}else {
				$('.change').attr("type","button");
 				$(".validation").html('<span class="text-danger"> <i class="mdi mdi-close-circle-outline">non valide</i> </span>');
			}      	
        });
        
        $( ".modifier" ).click(function() {
        	$("#idMod").attr("value", this.getAttribute("data-update"));
        });
        $( ".delete" ).click(function() {
        	$("#idSup").attr("value", this.getAttribute("data-delete"));
        });
    } );

</script>
<jsp:include page="include/fin.jsp" />