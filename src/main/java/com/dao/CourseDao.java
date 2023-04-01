package com.dao;

import com.entities.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDao {
    private SessionFactory factory;

    public  CourseDao (SessionFactory factory){
        this.factory = factory;
    }

    public boolean saveCurse(Course course) {
        boolean result = false;
        try{
            Session session =this.factory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            session.close();
            result = true;
        }catch (Exception error){
            error.printStackTrace();
            result = false;
        }
        return result;
    }

    public List<Course> getAllCourse(){
        Session session = this.factory.openSession();
        Query query = session.createQuery("from Course");
        List<Course> list = query.list();
        return list;
    }

    // get all course of given category
    public List<Course> getAllCoursesById(int cid){
        Session session = this.factory.openSession();
        Query query = session.createQuery("from Course as course where course.category.categoryId =: id");
        query.setParameter("id", cid);
        List<Course> list = query.list();
        return list;
    }

    public boolean deleteCourse(int cId) {
        boolean result = false;
        try{
            Session session =this.factory.openSession();
            Transaction transaction = session.beginTransaction();

            Course course = session.get(Course.class , cId);
            session.delete(course);
            transaction.commit();
            session.close();
            result = true;
        }catch (Exception error){
            error.printStackTrace();
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
//        System.out.println(category);
        return course;
    }
}
