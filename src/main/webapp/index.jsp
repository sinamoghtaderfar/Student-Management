<%@ page import="com.helper.FactoryProvider" %>
<%@ page import="com.dao.CourseDao" %>
<%@ page import="com.entities.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title> Home </title>
    <%@include file="components/comm_css_js.jsp"%>
</head>
    <body>
        <%@include file="components/navbar.jsp"%>
        <div class="row mt-3 mx-2 container">
            <%
                CourseDao courseDao = new CourseDao(FactoryProvider.getFactory());
                List<Course> list = courseDao.getAllCourse();

            %>
                <%--        show course--%>
                <div class="col-md-12">
                    <div class="row mt-4">
                        <div class="col-md-12">
                            <div class="card-columns">
                                <%
                                    for(Course c:list){
                                %>
                                <%--                        course cart--%>
                                <div class="card course-card">
                                    <div class="card-body">
                                        <h6 class="card-title">Course name :<%= c.getCourseName()%></h6>
                                        <p class="cart-text">Unit: <%= c.getCourseUit()%></p>
                                        <p class="cart-text">Category: <%= c.getCategory().getCategoryTitle()%></p>
                                    </div>
                                    <div class="card-footer text-center">
                                        <a href="selectCourseAction.jsp" class="btn btn-outline-primary">Select course</a>
                                    </div>
                                </div>
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