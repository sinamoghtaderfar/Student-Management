package com.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, name = "user_id")
    private int userId;
    @Column(length = 100, name = "user_name")
    private String userName;
    @Column(length = 100, name = "user_email")
    private String userEmail;
    @Column(length = 100, name = "user_Password")
    private String userPassword;
    @Column(length = 15, name = "student_Code")
    private String studentCode;
    @Column(name = "user_type")
    private String userType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<SelectCourse> selectCourses = new HashSet<>();

    public Set<SelectCourse> getSelectCourses() {
        return selectCourses;
    }

    public void setSelectCourses(Set<SelectCourse> selectCourses) {
        this.selectCourses = selectCourses;
    }

    public User(String userId, String userName, String userEmail, String userPassword, String studentCode, String userType) {
        this.userId = Integer.parseInt(userId);
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.studentCode = studentCode;
        this.userType = userType;
    }
    public User(String userName, String userEmail, String userPassword, String studentCode, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.studentCode = studentCode;
        this.userType = userType;
    }
    public User(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return studentCode;
    }

    public void setUserPhone(String userPhone) {
        this.studentCode = userPhone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + studentCode + '\'' +
                '}';
    }
}
