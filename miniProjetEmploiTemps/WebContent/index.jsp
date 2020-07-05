<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="miniProjetEmploiTemps.connexion" %> 
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Gestion d'emploi du temps </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0"/>
    <link rel="shortcut icon" type="image/x-icon" href="resources/assets/img/favicon.png"/>
    <link href="https://fonts.googleapis.com/css?family=Fira+Sans:400,500,600,700" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="resources/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="resources/assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="resources/assets/css/style.css"/>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<div class="main-wrapper">
        <div class="account-page">
            <div class="container">
                <h3 class="account-title">Authentification</h3>
                <div class="account-box">
                    <div class="account-wrapper">
                        <div class="account-logo">
                            <a href="#"><img src="resources/assets/img/logo2.png" alt="iga casablanca" /></a>
                        </div>
                        <form action="index.jsp" method="POST">
                            <div class="form-group form-focus">
                                <label class="control-label">Username</label>
                                 <input class="form-control floating" type="text" name="login" required>
                            </div>
                            <div class="form-group form-focus">
                                <label class="control-label">Password</label>
                                <input class="form-control floating" type="password" name="pass" required>
                            </div>
                            <div class="form-group text-center">
                            	<button class="btn btn-primary btn-block account-btn" type="submit">Login</button>
                            </div>
                         </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%
    	String msg= null;
    	int nb = 0;
		if(request.getParameter("login") != null){
			connexion cn = new connexion();
			Connection c = cn.connecter();
			
			String sql = "SELECT count(login) FROM utilisateur where login =?";
	        PreparedStatement s = c.prepareStatement(sql);
	        s.setString(1, request.getParameter("login"));
	        ResultSet res =  s.executeQuery();
	        while(res.next()) nb = res.getInt(1);
	        if(nb==1) {
	        	nb = 0;
	        	sql = "SELECT count(login),idUser, login, nom, prenom, email, telephone, type FROM utilisateur where login =? and password=? GROUP BY iduser";
	            s = c.prepareStatement(sql);
	            s.setString(1, request.getParameter("login"));
	            s.setString(2, request.getParameter("pass"));
	            res =  s.executeQuery();
	            String data2 ="null" ;
                while(res.next()) {
                	if(res.getInt(1) == 1){
                		HttpSession sesion = request.getSession();
                    	String data = res.getInt(2)+"";
                    	sesion.setAttribute("iduser"   , data);
                    	sesion.setAttribute("login"    , res.getString(3));
                    	sesion.setAttribute("nom"      , res.getString(4));
                    	sesion.setAttribute("prenom"   , res.getString(5));
                    	sesion.setAttribute("email"    , res.getString(6));
                    	sesion.setAttribute("telephone", res.getString(7));
                    	data2 = res.getString(8);

                    	sesion.setAttribute("type"     , data2);
                    	if(data2.equals("administrateur")) response.sendRedirect( request.getContextPath() + "/admin/dashboard.jsp");
                    	else response.sendRedirect( request.getContextPath() + "/emploi/dashboard.jsp");
                	}
                }
                msg = "Mot de passe incorrect";
	        }else msg = "Login n existe pas";

		}
	%>
    <script type="text/javascript" src="resources/assets/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="resources/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/assets/js/app.js"></script>
    <script >
    	<%
			if(request.getParameter("login") != null) out.print("Error('"+msg+"');");
		%>
	    function Error(msg){
	        swal({ title: msg, icon: "error", button: "Fermer",});
	    }
    </script>
	
</body>
</html>