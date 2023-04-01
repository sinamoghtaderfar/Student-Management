<%@ page import="com.helper.FactoryProvider"%>
<%@ page import="java.util.List"%>
<%@ page import="com.dao.CategoryDao"%>
<%@ page import="com.entities.User"%>
<%@ page import="com.entities.Category"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.dao.UserDao" %>
<%@ page import="com.dao.CourseDao" %>
<%@ page import="com.entities.Course" %>
<%
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
%>
<%
    CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
    List<Category> list = categoryDao.getCategories();

    UserDao userDao = new UserDao(FactoryProvider.getFactory());
    List<User> userlist = userDao.getUsers();

    CourseDao courseDao = new CourseDao(FactoryProvider.getFactory());
    List<Course> courselist = courseDao.getAllCourse();
    //get count
//    Map<String, Long> map = Helper.getCounts(FactoryProvider.getFactory());
%>
<html>
<head>
    <title>Admin panel</title>
    <%@include file="components/comm_css_js.jsp"%>
</head>
<body>
<%@include file="components/navbar.jsp"%>
<div class="container admintemp">
    <div class="container-fluid mt-3">
        <%@include file="components/message.jsp"%>
    </div>
    <div class="row mt-3">
        <%--            first col--%>
        <div class="col-md-4">
            <%--                first box--%>
            <div class="card" data-toggle="modal" data-target="#add-allUsers-modal">
                <div class="card-body text-center">
                    <div class="container">
                        <img style="max-width: 130px;" class="img-fluid" src="img/users.png" alt="users"/>
                    </div>
                    <h4><%= userlist.size()%></h4>
                    <h5 class="text-uppercase text-muted">Users</h5>
                </div>
            </div>
        </div>
        <%--    second col--%>
        <div class="col-md-4">
            <%--                second box--%>
            <div class="card" data-toggle="modal" data-target="#add-allCategory-modal">
                <div class="card-body text-center">
                    <div class="container">
                        <img style="max-width: 130px;" class="img-fluid" src="img/list.png" alt="categories"/>
                    </div>
                    <h4><%= list.size()%></h4>
                    <h5 class="text-uppercase text-muted">Categories</h5>
                </div>
            </div>
        </div>
        <%--            third col--%>
        <div class="col-md-4">
            <%--                thied box--%>
            <div class="card" data-toggle="modal" data-target="#add-allCourse-modal">
                <div class="card-body text-center">
                    <div class="container">
                        <img style="max-width: 130px;" class="img-fluid" src="img/course.png" alt="course"/>
                    </div>
                    <h4><%= courselist.size() %></h4>
                    <h5 class="text-uppercase text-muted">Course</h5>
                </div>
            </div>
        </div>
    </div>
    <%--        second row--%>
    <div class="row mt-3">
        <div class="col-md-6">
            <div class="card" data-toggle="modal" data-target="#add-category-modal">
                <div class="card-body text-center">
                    <div class="container">
                        <img style="max-width: 130px;" class="img-fluid" src="img/keys.png" alt="users"/>
                    </div>
                    <p class="mt-2">Click here to add new Category</p>
                    <h3 class="text-uppercase text-muted">Add Category</h3>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card" data-toggle="modal" data-target="#add-course-modal">
                <div class="card-body text-center">
                    <div class="container">
                        <img style="max-width: 130px;" class="img-fluid" src="img/plus.png" alt="users"/>
                    </div>
                    <p class="mt-2">Click here to add new Course</p>
                    <h5 class="text-uppercase text-muted"> Add Course</h5>
                </div>
            </div>
        </div>
    </div>
</div>
<%--      start  add Categpry modal--%>
<!-- Modal -->
<div class="modal fade" id="add-category-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header custom-bg text-white">
                <h5 class="modal-title" id="exampleModalLabel">Fill category details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="CourseOperationServlet" method="post">
                    <input type="hidden" name="operation" value="addcategory">
                    <div class="form-group">
                        <input type="text" class="form-control" name="catTitle" placeholder="Enter category course title" required />
                    </div>
                    <div class="container text-center">
                        <button class="btn btn-outline-success"> Add Category </button>
                        <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--      End  add Categpry modal--%>

<%--      course modal         --%>
<!-- Modal -->
<div class="modal fade" id="add-course-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header custom-bg text-white">
                <h5 class="modal-title" id="exampleModalLabel1">Course details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="CourseOperationServlet" method="post">
                    <input type="hidden" name="operation" value="addCourse" />
                    <div class="form-group">
                        <input type="text" class="form-control" name="CourseName" placeholder="Enter title of course" required/>
                    </div>

                    <div class="form-group">
                        <input type="number" class="form-control" name="courseUnit" placeholder="Enter unit of course" required/>
                    </div>

                    <%
                       CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
                        List <Category> li = cdao.getCategories();
                    %>
                    <div class="form-group">
                        <select name="catId" class="form-control">
                            <%
                                try {
                                    for (Category c : li){
                            %>
                            <option value="<%= c.getCategoryId() %>"> <%= c.getCategoryTitle()%> </option>
                            <%
                                }
                                }catch (Exception e) {
                                }
                            %>
<%--                            %>--%>
                        </select>
                    </div>

                    <div class="container text-center">
                        <button class="btn btn-outline-success"> Add course </button>
                        <button type="reset" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--     end course modal         --%>
<%---------------------------------------------------------%>
<%--    get all users Modal--%>
<!-- Modal -->
<div class="modal fade" id="add-allUsers-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header custom-bg text-white">
                <h5 class="modal-title" id="exampleModalLabels">List student</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Username</th>
                        <th scope="col">Email</th>
                        <th scope="col">Student code</th>
                        <th scope="col">Role</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                        <tbody>
                        <%
                            try {
                                for (User u : userlist){
                        %>
                        <form action="UserOperationServlet" method="post">
                            <input type="hidden" name="operation" value="deleteUser"/>
                        <tr>
                            <td><%= u.getUserName()%></td>
                            <td><%= u.getUserEmail()%></td>
                            <td><%= u.getStudentCode()%></td>
                            <td><b><%= u.getUserType()%></b></td>
                            <td><input type="submit" class="btn btn-outline-danger" value="Delete"></td>
                            <td><input type="hidden" value="<%= u.getUserId()%>" name="deleteUser"></td>

                        </tr>
                        </form>
                        <%
                                }
                            }catch (Exception e) {
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%--      End  get all users--%>

<%---------------------------------------------------------%>
<%--    get category Modal--%>
<!-- Modal -->
<div class="modal fade" id="add-allCategory-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header custom-bg text-white">
                <h5 class="modal-title" id="exampleModalLabelcategory">List category</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Category title</th>
                        <th scope="col">Delete</th>
                        <th scope="col">Update</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        try {
                            for (Category listCategory : list){
                    %>

                        <tr>
                            <form action="CategoryOperationServlet" method="post">
                                <input type="hidden" name="operation" value="deleteCategory"/>
                                <td><%= listCategory.getCategoryTitle()%></td>
                                <td><input type="submit" class="btn btn-outline-danger" value="Delete"></td>
                                <td><input type="hidden" value="<%= listCategory.getCategoryId()%>" name="deleteCategory"></td>
                            </form>
                                <td>
                                    <button class="btn btn-outline-warning"><a href="CategoryUpdate.jsp?catId=<%= listCategory.getCategoryId()%>">Update</a></button>
                                </td>
                        </tr>
                    <%
                            }
                        }catch (Exception e) {
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%--   ende get category Modal--%>

<%--    get category Modal--%>
<!-- Modal -->
<div class="modal fade" id="add-allCourse-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header custom-bg text-white">
                <h5 class="modal-title">List Course</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Course name</th>
                        <th scope="col">Course unit</th>
                        <th scope="col">Course category </th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        try {
                            for (Course course : courselist){
                    %>

                    <tr>
                        <form action="CourseOperationServlet" method="post">
                            <input type="hidden" name="operation" value="deleteCourse"/>
                            <td><%= course.getCourseName()%></td>
                            <td><%= course.getCourseUit()%></td>
                            <td><%= course.getCategory().getCategoryTitle()%></td>
                            <td><input type="submit" class="btn btn-outline-danger" value="Delete"></td>
                            <td><input type="hidden" value="<%= course.getCourseId()%>" name="deleteCourse"></td>
                        </form>
                    </tr>
                    <%
                            }
                        }catch (Exception e) {
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%--   ende get category Modal--%>

</body>
</html>
