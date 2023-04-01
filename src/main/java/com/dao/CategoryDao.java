package com.dao;

import com.entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDao {
    private SessionFactory factory;

    public CategoryDao(SessionFactory factory) {
        this.factory = factory;
    }
    // save category to database
    public int saveCategory(Category cat){
        Session session = this.factory.openSession();
        Transaction transaction = session.beginTransaction();
        int catId = (int)session.save(cat);
        transaction.commit();
        session.close();
        return catId;
    }
    public List<Category> getCategories(){
        Session session = this.factory.openSession();
        Query query = session.createQuery("from Category ");
        List <Category> list = query.list();
        return list;
    }
    public Category getCategoryById(int categoryId){
        Category category = null;
        try{
            Session session = this.factory.openSession();
            category = session.get(Category.class, categoryId);
            session.close();
        }catch (Exception error){
            error.printStackTrace();
        }
//        System.out.println(category);
        return category;
    }

    public boolean deleteCategory(int cId) {
        boolean result = false;
        try{
            Session session =this.factory.openSession();
            Transaction transaction = session.beginTransaction();

            Category category = session.get(Category.class , cId);
            session.delete(category);
            transaction.commit();
            session.close();
            result = true;
        }catch (Exception error){
            error.printStackTrace();
            result = false;
        }
        return result;
    }

    public Category updateCategory(int catId , String updateCategory) {
        Category category = null;
        try {
            Session session = this.factory.openSession();
            Transaction transaction = session.beginTransaction();

            category = session.get(Category.class, catId);
            category.setCategoryTitle(updateCategory);
            session.saveOrUpdate(category);
            transaction.commit();
            session.close();

        } catch (Exception error) {
            error.printStackTrace();
        }
//        System.out.println(category);
        return category;
    }

}
