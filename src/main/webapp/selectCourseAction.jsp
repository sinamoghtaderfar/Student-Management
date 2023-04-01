<%@ page import="com.entities.User" %><%
    User user = (User)session.getAttribute("current-user");
    if(user == null){
        session.setAttribute("message","You are not logged in!! Login first");
        response.sendRedirect("login.jsp");
        return;
    }else {
        if(user.getUserType().equals("normal")){
            session.setAttribute("message","Do not access this page");
            response.sendRedirect("login.jsp");
            return;
        }
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="components/comm_css_js.jsp"%>
</head>
<body>
    <%@include file="components/navbar.jsp"%>
</body>
</html>
