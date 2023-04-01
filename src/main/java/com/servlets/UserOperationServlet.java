package com.servlets;

import com.dao.UserDao;
import com.helper.FactoryProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserOperationServlet", value = "/UserOperationServlet")
public class UserOperationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if (operation.trim().equals("deleteUser")){
            // delete user

            int deleteUser = Integer.parseInt(request.getParameter("deleteUser"));
            System.out.println(deleteUser);
            // user database delete

            UserDao userDao = new UserDao((FactoryProvider.getFactory()));
            userDao.deleteUser(deleteUser);
//            System.out.println("Category save");

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("message", "Student removed successfully");
            response.sendRedirect("admin.jsp");
            return;
        }
    }
}
