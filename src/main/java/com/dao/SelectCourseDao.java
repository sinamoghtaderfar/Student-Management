package com.dao;

import com.entities.Category;
import com.entities.Course;
import com.entities.SelectCourse;
import com.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SelectCourseDao {
    private SessionFactory factory;

    public SelectCourseDao(SessionFactory factory) {
        this.factory = factory;
    }

    public boolean saveSelectCourse(SelectCourse selectCourse){
        boolean result = false;
        try{
            Session session = this.factory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(selectCourse);
            transaction.commit();
            session.close();
            result = true;
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    public Course getCourseById(int courseId){
        Course course = null;
        try{
            Session session = this.factory.openSession();
            course = session.get(Course.class, courseId);
            session.close();
        }catch (Exception error){
            error.printStackTrace();
        }
        return course;
    }

    public User getUserById(int userId){
        User user = null;
        try{
            Session session = this.factory.openSession();
            user = session.get(User.class, userId);
            session.close();
        }catch (Exception error){
            error.printStackTrace();
        }
        return user;
    }
}
