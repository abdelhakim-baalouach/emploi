<%@page import="miniProjetEmploiTemps.utilisateur" %> 
<%@include file="include/head.jsp" %>
<%@include file="include/header.jsp" %>
<%@include file="include/nav.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="card-box">
        	<div class="text-right" style="margin-bottom: 10px;">
	            <a href="#" data-toggle="modal" data-target="#ajouter" class="btn btn-primary rounded">
	                <i class="fa fa-plus"></i> Ajouter
	            </a>                     
	       </div>
            <ul class="nav nav-tabs nav-tabs-solid nav-tabs-rounded nav-justified">
                <li class="active"><a href="#solid-rounded-justified-tab1" data-toggle="tab">liste des etudiants</a></li>
                <li><a href="#solid-rounded-justified-tab2" data-toggle="tab">liste des professeur</a></li>
                <li><a href="#solid-rounded-justified-tab3" data-toggle="tab">liste des administrateur</a></li>
            </ul>
            <div class="tab-content ">
                <div class="tab-pane active" id="solid-rounded-justified-tab1">
                    <div class="card-block">
                        <div class="card-title">
                            <h3 class="page-title">Liste des etudiants</h3>
                        </div>
                        <div class="table-responsive">
                            <table id="dataTable" class="table table-striped table-bordered" style="width:100%">
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
                                    <%
                                		String chaine = "";
                                		utilisateur utilisateur = new utilisateur();
                                		ResultSet res = utilisateur.afficheEtudiant();
                                		while(res.next()) {
                                			chaine +="<tr><td>"+res.getInt(1)+"</td><td>"+res.getString(2)+"</td><td>"+res.getString(3)+"</td><td>"+res.getString(4)+"</td><td>"+res.getString(5)+"</td>";
                                			chaine +="<td class='text-right'> <div class='dropdown'><a href='#' class='action-icon dropdown-toggle' data-toggle='dropdown' aria-expanded='false'><i class='fa fa-ellipsis-v'></i></a>"; 
                                			chaine +="<ul class='dropdown-menu pull-right'><li><a href='#' onclick='modifier("+res.getInt(1)+")' ><i class='fa fa-pencil m-r-5'></i>Modifier mot de passe</a></li>";
                                			chaine +="<li><a href='#' onclick='supp("+res.getInt(1)+")' data-toggle='modal' data-target='#supprimer'><i class='fa fa-trash-o m-r-5'></i>Supprime</a></li></ul></div></td></tr>";
                                    	}
                                		out.print(chaine);
                                	%>
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
                <div class="tab-pane" id="solid-rounded-justified-tab2">
                    <div class="card-block">
                        <div class="card-title">
                            <h3 class="page-title">Liste des professeurs</h3>
                        </div>
                        <div class="table-responsive">
                            <table id="dataHoraire" class="table table-striped table-bordered" style="width:100%">
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
                                    <%
                                		chaine = "";
                                		utilisateur = new utilisateur();
                                		res = utilisateur.afficheProf();
                                		while(res.next()) {
                                			chaine +="<tr><td>"+res.getInt(1)+"</td><td>"+res.getString(2)+"</td><td>"+res.getString(3)+"</td><td>"+res.getString(4)+"</td><td>"+res.getString(5)+"</td>";
                                			chaine +="<td class='text-right'> <div class='dropdown'><a href='#' class='action-icon dropdown-toggle' data-toggle='dropdown' aria-expanded='false'><i class='fa fa-ellipsis-v'></i></a>"; 
                                			chaine +="<ul class='dropdown-menu pull-right'><li><a href='#' onclick='modifier("+res.getInt(1)+")' ><i class='fa fa-pencil m-r-5'></i>Modifier mot de passe</a></li>";
                                			chaine +="<li><a href='#' onclick='supp("+res.getInt(1)+")' data-toggle='modal' data-target='#supprimer'><i class='fa fa-trash-o m-r-5'></i>Supprime</a></li></ul></div></td></tr>";
                                    	}
                                		out.print(chaine);
                                	%>
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
                 <div class="tab-pane" id="solid-rounded-justified-tab3">
                    <div class="card-block">
                        <div class="card-title">
                            <h3 class="page-title">Liste des administrateur</h3>
                        </div>
                        <div class="table-responsive">
                            <table id="dataTable2" class="table table-striped table-bordered" style="width:100%">
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
                                    <%
                                		chaine = "";
                                		utilisateur = new utilisateur();
                                		res = utilisateur.afficheAdmin();
                                		while(res.next()) {
                                			chaine +="<tr><td>"+res.getInt(1)+"</td><td>"+res.getString(2)+"</td><td>"+res.getString(3)+"</td><td>"+res.getString(4)+"</td><td>"+res.getString(5)+"</td>";
                                			chaine +="<td class='text-right'> <div class='dropdown'><a href='#' class='action-icon dropdown-toggle' data-toggle='dropdown' aria-expanded='false'><i class='fa fa-ellipsis-v'></i></a>"; 
                                			chaine +="<ul class='dropdown-menu pull-right'><li><a href='#' onclick='modifier("+res.getInt(1)+")'><i class='fa fa-pencil m-r-5'></i>Modifier mot de passe</a></li>";
                                			chaine +="<li><a href='#' onclick='supp("+res.getInt(1)+")' data-toggle='modal' data-target='#supprimer'><i class='fa fa-trash-o m-r-5'></i>Supprime</a></li></ul></div></td></tr>";
                                    	}
                                		out.print(chaine);
                                	%>
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
    </div>
    <!-- model ajoute -->
    <div id="ajouter" class="modal custom-modal fade" role="dialog" style="display: none;">
        <div class="modal-dialog">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <div class="modal-content modal-lg">
                <div class="modal-header">
                    <h4 class="modal-title">Ajouter utilisateur</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="POST" action="jsp/ajoute_utilisateur.jsp">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">login</label>
	                                <div class="col-lg-9">
	                                    <input type="text" class="form-control" name="login" placeholder="Login" required>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">email</label>
	                                <div class="col-lg-9">
	                                    <input type="text" class="form-control" name="email" placeholder="Email" required>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">nom</label>
	                                <div class="col-lg-9">
	                                    <input type="text" class="form-control" name="nom" placeholder="Nom" required>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">prenom</label>
	                                <div class="col-lg-9">
	                                    <input type="text" class="form-control" name="prenom" placeholder="Prenom" required>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">telephone</label>
	                                <div class="col-lg-9">
	                                    <input type="text" class="form-control" name="telephone" placeholder="telephone" required>
	                                </div>
	                            </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
	                                <label class="col-lg-3 control-label">type</label>
	                                <div class="col-lg-9">
	                                    <select class="select select2etab" name="type" required>
	                                    	<option value="etudiant">etudiant</option>
	                                    	<option value="professeur">professeur</option>
	                                    	<option value="administrateur">administrateur</option> 
	                                    </select>
	                                </div>
	                            </div>
                            </div>
                        </div>  
                        <div class="text-right">
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
 
   <!-- model supprimer -->
    <div id="supprimer" class="modal custom-modal fade" role="dialog" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content modal-md">
                <div class="modal-header">
                    <h4 class="modal-title">Supprimer semestre</h4>
                </div>
                <form method="POST" action="jsp/supprimer_utilisateur.jsp">
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
    	
    	if(request.getParameter("supprimer")!= null && !request.getParameter("supprimer").trim().isEmpty()) 
			out.println("Success('Horaire est bien supprimé')");

    	%>

        function Success(msg){
            swal({ title: msg, icon: "success", button: "Fermer",});
        }

        function ajouterLigne(){
            var cp = $("#cp").val();
            cp++;
            var data ='<div class="col-md-4"> <div class="form-group"> <label class="col-lg-3 control-label">Nom</label> <div class="col-lg-9"> <input type="text" class="form-control" name="nom'+cp+'" placeholder="semestre" required> </div></div></div><div class="col-md-4"> <div class="form-group"> <label class="col-lg-3 control-label">Date Debut</label> <div class="col-lg-9"> <input type="text" class="form-control datetimepicker" name="dateD'+cp+'" placeholder="Date debut" required> </div></div></div><div class="col-md-4"> <div class="form-group"> <label class="col-lg-3 control-label">Date fin</label> <div class="col-lg-9"> <input type="text" class="form-control datetimepicker" name="dateF'+cp+'" placeholder="Date fin" required> </div></div></div>'; 
			$("#cp").attr("value",cp);
            $("#ligne").append(data);
            $(".select2etab").select2({
                width: "100%"
            });
            $('.datetimepicker').datetimepicker({
                format: 'DD/MM',
                defaultDate: new Date()
            });
        }
        function modifier(arg,email){
            $.ajax({
                type:"POST",
                cache: false,
                url:"jsp/update_password.jsp",
                data:{id:arg},
                dataType:"html",
                success:function(data){
                	Success('mot de passe est bien modifié')
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