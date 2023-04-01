package com.servlets;

import com.dao.CategoryDao;
import com.dao.CourseDao;
import com.entities.Category;
import com.entities.Course;
import com.helper.FactoryProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CourseOperationServlet", value = "/CourseOperationServlet")
public class CourseOperationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // add category
        String operation = request.getParameter("operation");
        if (operation.trim().equals("addcategory")){
            // add Category
            String title = request.getParameter("catTitle");

            Category category = new Category(FactoryProvider.getFactory());
            category.setCategoryTitle(title);


            // category database save
            CategoryDao categoryDao = new CategoryDao((FactoryProvider.getFactory()));
            int catI = categoryDao.saveCategory(category);
//            System.out.println("Category save");

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("message", "Category added successfully");
            response.sendRedirect("admin.jsp");
            return;

        }else if(operation.trim().equals("addCourse")){
            // add course

            String CourseName = request.getParameter("CourseName");
            int courseUnit = Integer.parseInt(request.getParameter("courseUnit"));
            int catId = Integer.parseInt(request.getParameter("catId"));

            Course course = new Course();

            course.setCourseName(CourseName);
            course.setCourseUit(courseUnit);


            // get Category by Id
            CategoryDao categoryDao = new CategoryDao((FactoryProvider.getFactory()));
            Category category = categoryDao.getCategoryById(catId);
            course.setCategory(category);

            //course save
            CourseDao courseDao = new CourseDao(FactoryProvider.getFactory());
            courseDao.saveCurse(course);


            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("message", "Course is added successfully :)");
            response.sendRedirect("admin.jsp");
            return;
        }else if(operation.trim().equals("deleteCourse")){
            int deleteCourse = Integer.parseInt(request.getParameter("deleteCourse"));

            CourseDao courseDao = new CourseDao((FactoryProvider.getFactory()));
            courseDao.deleteCourse(deleteCourse);

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("message", "Course removed successfully");
            response.sendRedirect("admin.jsp");
            return;
        }

    }
}
