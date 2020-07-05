<body>
    <div class="main-wrapper">
        <div class="header">
            <div class="header-left">
                <a href="dashboard.jsp" class="logo">
                    <img src="../resources/assets/img/logo.png" width="60" height="60" alt="logo">
                </a>
            </div>
            <div class="page-title-box pull-left">
                <h3>Emploi du temps</h3>
            </div>
            <a id="mobile_btn" class="mobile_btn pull-left" href="#sidebar"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <ul class="nav navbar-nav navbar-right user-menu pull-right">
                <li class="dropdown">
                    <a href="dashboard.jsp" class="dropdown-toggle user-link" data-toggle="dropdown" title="Admin">
                        <span class="user-img"><img class="img-circle" src="../resources/assets/img/user/avatar.jpg" width="40" alt="avatar">
                         <span class="status online"></span></span>
                         <span><%=sesion.getAttribute("nom") + " " + sesion.getAttribute("prenom")  %></span>
                         <i class="caret"></i>
                     </a>
                     <ul class="dropdown-menu">
                        <li>
                            <a href="#" data-toggle="modal" data-target="#profil" >
                                <i class="fa fa-user m-r-5"></i> Profil 
                            </a>
                        </li>
                        <li><a href="jsp/deconnecter.jsp"> <i class="fa fa-sign-out m-r-5"></i> Déconnecter</a></li>
                    </ul>
                </li>
            </ul>
            <div class="dropdown mobile-user-menu pull-right">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
                <ul class="dropdown-menu pull-right">
                    <li>
                        <a href="#" data-toggle="modal" data-target="#profil" >
                            <i class="fa fa-user m-r-5"></i> Profil 
                        </a>
                    </li>
                    <li><a href="jsp/deconnecter.jsp"> <i class="fa fa-sign-out m-r-5"></i> Déconnecter</a></li>
                </ul>
            </div>
        </div>
        <div id="profil" class="modal custom-modal fade" role="dialog" style="display: none;">
            <div class="modal-dialog">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <div class="modal-content modal-lg">
                    <div class="modal-header">
                        <div class="col-xs-7">
                            <h4 class="page-title">Mon profil</h4>
                        </div>
                    </div>
                    <div class="modal-body">
                        <div class="content container-fluid">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-lg-12">
                                        <div class="profile-widget">
                                            <div class="profile-img">
                                                <img class="avatar"src="../resources/assets/img/user/avatar.jpg" alt="profil">
                                            </div>
                                            <div class="dropdown profile-action">
                                                <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
                                                <ul class="dropdown-menu pull-right">
                                                    <li><a href="profil.jsp"><i class="fa fa-pencil m-r-5"></i> Modifié</a></li>
                                                </ul>
                                            </div>
                                            <h3 class="user-name m-t-0 m-b-0" style="padding-top: 10px">
                                            	<%=sesion.getAttribute("nom") + " " + sesion.getAttribute("prenom")  %>
                                            </h3>
                                            <div class="small text-muted"><%=sesion.getAttribute("type") %></div>

                                            <a href="profil.jsp" class="btn btn-default btn-sm m-t-10">
                                                <i class="fa fa-pencil m-r-5"></i> Modifié profil
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>