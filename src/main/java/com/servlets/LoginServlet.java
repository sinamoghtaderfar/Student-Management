package com.servlets;

import com.dao.UserDao;
import com.entities.User;
import com.helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String studentCode = request.getParameter("student_Code");
       String password = request.getParameter("password");
//        Validations
//        authenticating user
        UserDao userDao = new UserDao(FactoryProvider.getFactory());
        User user = userDao.getUserByStudentCodeAndPassword(studentCode, password);
//        System.out.println(user);
        HttpSession httpSession = request.getSession();
        if(user == null){
            httpSession.setAttribute("message", "Invalid Details!! Try with another one");
            response.sendRedirect("login.jsp");
        }else {
            out.println("<h1>Welcome "+user.getUserName()+"</h1>");
//            login
            httpSession.setAttribute("current-user",user);
            if(user.getUserType().equals("admin"))
//          admin.jsp
                response.sendRedirect("admin.jsp");
            else if(user.getUserType().equals("normal"))
//          normal.jsp
                response.sendRedirect("normal.jsp");
            else {
                out.println("we have not identified user type");
            }
        }
    }
}
