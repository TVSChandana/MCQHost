package com.sasmitha.gproject.model;


import javax.persistence.*;

@Entity
@Table(name = "Request_Table")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "Request_Id")
    private Integer Request_Id;

    @Column(name = "Student_Id")
    private Integer Student_Id;

    @Column(name = "Admin_Id")
    private Integer Admin_Id;

    @Column(name = "Request_status")
    private Integer Request_status;

    public Integer getRequest_Id() {
        return Request_Id;
    }

    public void setRequest_Id(Integer request_Id) {
        Request_Id = request_Id;
    }

    public Integer getStudent_Id() {
        return Student_Id;
    }

    public void setStudent_Id(Integer student_Id) {
        Student_Id = student_Id;
    }

    public Integer getAdmin_Id() {
        return Admin_Id;
    }

    public void setAdmin_Id(Integer admin_Id) {
        Admin_Id = admin_Id;
    }

    public Integer getRequest_status() {
        return Request_status;
    }

    public void setRequest_status(Integer request_status) {
        Request_status = request_status;
    }
}
