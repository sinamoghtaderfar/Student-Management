<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login </title>
    <%@include file="components/comm_css_js.jsp"%>
</head>
<body>
    <%@include file="components/navbar.jsp"%>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card mt-3">
                    <div class="card-header custom-bg text-white">
                        <h3>Login here</h3>
                    </div>
                    <div class="card-body">
                        <%@include file="components/message.jsp"%>
                        <form action="LoginServlet" method="post">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Student Code</label>
                                <input type="number" name="student_Code" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter student code">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                            </div>

                            <a href="register.jsp" class="text-center d-block mb-2">if not registered click here</a>
                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary custom-bg btn border-0">Submit</button>
                                <button type="reset" class="btn btn-primary custom-bg btn border-0">Reset</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
