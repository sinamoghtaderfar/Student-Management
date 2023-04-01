package com.entities;

import javax.persistence.*;

@Entity
public class SelectCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int selectCourseId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    public SelectCourse() {
    }

    public int getSelectCourseId() {
        return selectCourseId;
    }

    public void setSelectCourseId(int selectCourseId) {
        this.selectCourseId = selectCourseId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

