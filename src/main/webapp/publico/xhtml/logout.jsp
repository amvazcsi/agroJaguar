<% session.invalidate(); 
   response.sendRedirect(request.getContextPath() + "/publico/xhtml/login.jsf"); 
%>