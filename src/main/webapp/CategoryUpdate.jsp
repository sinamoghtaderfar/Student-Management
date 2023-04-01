<%@ page import="com.entities.User" %>
<%@ page import="com.dao.CategoryDao" %>
<%@ page import="com.helper.FactoryProvider" %><%
    User user = (User)session.getAttribute("current-user");
    if(user == null){
        session.setAttribute("message","You are not logged in!! Login first");
        response.sendRedirect("login.jsp");
        return;
    }else {
        if(user.getUserType().equals("normal")){
            session.setAttribute("message","You are not admin!! Do not access this page");
            response.sendRedirect("login.jsp");
            return;
        }
    }

    int catId = Integer.parseInt(request.getParameter("catId"));
    System.out.println(catId);
    CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
//    categoryDao.getCategoryById(catId).getCategoryTitle();

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Page</title>
    <%@include file="components/comm_css_js.jsp"%>

</head>
<body>
<%@include file="components/navbar.jsp"%>
        <div class="container">
            <div class="container-fluid mt-3">
                <%@include file="components/message.jsp"%>
            </div>
                <h1>Update Category page</h1>
            <form action="CategoryOperationServlet" method="post">
                <input type="hidden" name="operation" value="updateCategory"/>
                <div class="form-group">
                    <input type="text" class="form-control" name="updateCategory" value="<%=categoryDao.getCategoryById(catId).getCategoryTitle()%>" placeholder="Update category course title" required />
                    <input type="hidden" class="form-control" name="catId" value="<%=categoryDao.getCategoryById(catId).getCategoryId()%>" required />
                </div>

                <div class="container text-center">
                    <button type="submit" class="btn btn-success btn border-0">Save</button>
                    <button type="reset" class="btn btn-warning btn border-0">Reset</button>
                </div>
            </form>
        </div>
</body>
</html>
