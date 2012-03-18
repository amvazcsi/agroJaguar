<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="refresh" content="0;url=publico/entrada.jsf">
		<title>Agropecuaria Jaguar | Por favor, aguarde...</title>
	</head>
	<body>
		<%
		 if(session.getAttribute("UsuarioBean") != null) {
		     response.sendRedirect(request.getContextPath() + "/restrito/xhtml/index.jsf"); 
		 } else {
		     response.sendRedirect(request.getContextPath() + "/publico/xhtml/login.jsf");
		 }
		%>
	</body>
</html>