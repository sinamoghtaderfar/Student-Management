<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User</title>
  <%@include file="components/comm_css_js.jsp"%>
</head>
<body>
    <%@include file="components/navbar.jsp"%>
    <div class="container-fluid">
        <div class="row mt-3">
            <div class="col-md-4 offset-md-4">

                <div class="card">
                    <%@include file="components/message.jsp"%>
                    <div class="card-body px-5">
                        <div class="container text-center">
                            <img src="img/membership.png" alt="" style="max-width: 100px;" class="img-fluid">
                        </div>
                        <h3 class="text-center my-3">Sign up here !</h3>
                        <form action="RegisterServlet" method="post">
                            <div class="form-group">
                                <label for="name">User Name</label>
                                <input type="text" name="user_name" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter here" required>
                            </div>
                            <div class="form-group">
                                <label for="email">User Email</label>
                                <input type="email" name="user_email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter here" required>
                            </div>
                            <div class="form-group">
                                <label for="password">User password</label>
                                <input type="password" name="user_password" class="form-control" id="password" aria-describedby="emailHelp" placeholder="Enter here" required>
                            </div>
                            <div class="form-group">
                                <label for="phone">Student code</label>
                                <input type="number" name="student_code" class="form-control" id="phone" aria-describedby="emailHelp" placeholder="Enter here" required>
                            </div>

                            <div class="container text-center">
                                <button class="btn btn-outline-success" type="submit">Register</button>
                                <button class="btn btn-outline-warning" type="reset">Reset</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
