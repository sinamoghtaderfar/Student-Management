package com.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private int courseUnit;

    @ManyToOne
    private Category category;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "course")
    private Set<SelectCourse> selectCourses=new HashSet<>();
    public Course(){
    }
    public Set<SelectCourse> getSelectCourses() {
        return selectCourses;
    }

    public void setSelectCourses(Set<SelectCourse> selectCourses) {
        this.selectCourses = selectCourses;
    }
    public Course(String courseName, int courseUit, Category category) {
        this.courseName = courseName;
        this.courseUnit = courseUit;
        this.category = category;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseUit() {
        return courseUnit;
    }

    public void setCourseUit(int courseUit) {
        this.courseUnit = courseUit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseUnit=" + courseUnit +
                '}';
    }
}
