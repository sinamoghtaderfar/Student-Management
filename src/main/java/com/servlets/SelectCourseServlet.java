package com.servlets;

import com.dao.SelectCourseDao;
import com.entities.Course;
import com.entities.SelectCourse;
import com.entities.User;
import com.helper.FactoryProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SelectCourseServlet", value = "/SelectCourseServlet")
public class SelectCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println(courseId + "and" + userId);

        SelectCourseDao selectCourseDao = new SelectCourseDao((FactoryProvider.getFactory()));
        Course selectCourse = selectCourseDao.getCourseById(courseId);
        SelectCourse course = new SelectCourse();
        course.setCourse(selectCourse);

        User select = selectCourseDao.getUserById(userId);
        course.setUser(select);

        selectCourseDao.saveSelectCourse(course);

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("message", "Course is added your profile :)");
        response.sendRedirect("normal.jsp");
        return;
    }
}
