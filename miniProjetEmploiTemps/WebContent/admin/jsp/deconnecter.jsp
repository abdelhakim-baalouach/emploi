<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deconnecter</title>
</head>
<body>
	<%
		HttpSession sesion = request.getSession();
		session.invalidate();
		response.sendRedirect( request.getContextPath() + "/index.jsp");
	%>
</body>
</html>