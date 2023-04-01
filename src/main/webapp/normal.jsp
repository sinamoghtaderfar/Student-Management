<%@ page import="com.helper.FactoryProvider" %>
<%@ page import="com.dao.CourseDao" %>
<%@ page import="com.entities.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.entities.User" %><%
    User user = (User)session.getAttribute("current-user");
    System.out.println(user);
%>
<!DOCTYPE html>
<html>
<head>
    <title> Home </title>
    <%@include file="components/comm_css_js.jsp"%>
</head>
<body>
<%@include file="components/navbar.jsp"%>
<%@include file="components/message.jsp"%>

<div class="row mx-3">
    <%
        CourseDao courseDao = new CourseDao(FactoryProvider.getFactory());
        List<Course> list = courseDao.getAllCourse();

    %>
    <%--        show course--%>

    <div class="col-md-9">
        <div class="row mt-4">
            <div class="col-md-12">
                <div class="card-columns">
                    <%
                        for(Course c:list){
                    %>
                    <%--                        course cart--%>
                    <form action="SelectCourseServlet" method="post">
                        <div class="card course-card">
                            <div class="card-body">
                                <h6 class="card-title">Course name :<%= c.getCourseName()%></h6>
                                <p class="cart-text">Unit: <%= c.getCourseUit()%></p>
                                <p class="cart-text">Category: <%= c.getCategory().getCategoryTitle()%></p>
                            </div>
                            <div class="card-footer text-center">
                                <button type="submit" class="btn btn-success"> Select</button>
                                <input type="hidden" name="courseId" value="<%= c.getCourseId()%>">
                                <input type="hidden" name="userId" value="<%= user.getUserId()%>">
                            </div>
                        </div>
                    </form>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>