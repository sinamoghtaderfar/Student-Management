package com.entities;

import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String categoryTitle;

    @OneToMany(mappedBy = "category")
    private List<Course> courses = new ArrayList<>();

    public Category(SessionFactory factory) {
    }

    public Category(int categoryId, String categoryTitle) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
    }

    public Category(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Category() {

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryTitle='" + categoryTitle + '\'' +
                '}';
    }
}
