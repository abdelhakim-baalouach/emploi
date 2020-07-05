<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="miniProjetEmploiTemps.connexion" %> 
<%@page import="java.sql.*"%>
<%
	HttpSession sesion = request.getSession();
	if(!sesion.getAttribute("type").equals("administrateur")) {
		response.sendRedirect( request.getContextPath() + "/admin/jsp/deconnecter.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<title>Gestion d'emploi du temps </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <link rel="shortcut icon" type="image/x-icon" href="../resources/assets/img/favicon.png">
    <link href="https://fonts.googleapis.com/css?family=Fira+Sans:400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/assets/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/assets/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/assets/css/select2.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/assets/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/assets/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/assets/plugins/morris/morris.css">
    <link rel="stylesheet" type="text/css" href="../resources/assets/css/clockpicker.css">
    <link rel="stylesheet" type="text/css" href="../resources/assets/css/style.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <!--[if lt IE 9]>
		<script src="../assets/js/html5shiv.min.js"></script>
		<script src="../assets/js/respond.min.js"></script>
	<![endif]-->
</head>