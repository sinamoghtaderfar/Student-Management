package com.servlets;

import com.entities.User;
import com.helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String userName = request.getParameter("user_name");
            String userEmail = request.getParameter("user_email");
            String userPassword = request.getParameter("user_password");
            String studentCode = request.getParameter("student_code");
//            validations

            String [] str = studentCode.split("");
            if(str.length < 11){
                System.out.println(str.length);
                HttpSession httpSession =request.getSession();
                httpSession.setAttribute("message","The student code is 11 characters long !");
                response.sendRedirect("register.jsp");
            }else {
                // creating User OBJ
                User user = new User(userName, userEmail, userPassword, studentCode , "normal");

                Session hibernateSession = FactoryProvider.getFactory().openSession();
                Transaction transaction = hibernateSession.beginTransaction();

                int userId = (int) hibernateSession.save(user);
                transaction.commit();
                hibernateSession.close();

                HttpSession httpSession =request.getSession();
                httpSession.setAttribute("message","Registration Successful !");
                response.sendRedirect("register.jsp");
                return;

            }

        }catch(Exception error){
            error.printStackTrace();
        }
    }
}
