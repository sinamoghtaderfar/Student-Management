package com.dao;

import com.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class UserDao {
    private SessionFactory factory;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }
    //get user by email & password
    public User getUserByStudentCodeAndPassword(String studentCode, String password){
        User user = null;
        try{
            String query = "From User Where studentCode =: studentCode and userPassword=: password";
            Session session =this.factory.openSession();
            Query q = (Query) session.createQuery(query);
            q.setParameter("studentCode",studentCode);
            q.setParameter("password",password);
            user = (User) q.uniqueResult();
            session.close();
        }catch (Exception error){
            error.printStackTrace();
        }
        return user;
    }

    public List<User> getUsers(){
        Session session = this.factory.openSession();
        Query query = session.createQuery("from User ");
        List <User> list = query.list();
        return list;
    }

    public boolean deleteUser(int stCode) {
        boolean result = false;
        try{
            Session session =this.factory.openSession();
            Transaction transaction = session.beginTransaction();

            User user = session.get(User.class , stCode);
            session.delete(user);
            transaction.commit();
            session.close();
            result = true;
        }catch (Exception error){
            error.printStackTrace();
            result = false;
        }
        return result;
    }

}
