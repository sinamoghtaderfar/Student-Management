package com.servlets;

import com.dao.CategoryDao;
import com.helper.FactoryProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.SessionFactory;

import java.io.IOException;

@WebServlet(name = "CategoryOperationServlet", value = "/CategoryOperationServlet")
public class CategoryOperationServlet extends HttpServlet {
    private SessionFactory factory;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if (operation.trim().equals("deleteCategory")){
            // delete user

            int deleteCategory = Integer.parseInt(request.getParameter("deleteCategory"));
            System.out.println(deleteCategory);
            // user database delete

            CategoryDao categoryDao = new CategoryDao((FactoryProvider.getFactory()));
            categoryDao.deleteCategory(deleteCategory);
//            System.out.println("Category save");

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("message", "Category removed successfully");
            response.sendRedirect("admin.jsp");
            return;
        }else if (operation.trim().equals("updateCategory")){

            String updateCategory = request.getParameter("updateCategory");
            int catId = Integer.parseInt(request.getParameter("catId"));
            System.out.println(updateCategory);
            System.out.println(catId);
            CategoryDao categoryDao = new CategoryDao((FactoryProvider.getFactory()));
            categoryDao.updateCategory(catId , updateCategory);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("message", "Category update successfully");
            response.sendRedirect("admin.jsp");
            return;
        }
    }
}
