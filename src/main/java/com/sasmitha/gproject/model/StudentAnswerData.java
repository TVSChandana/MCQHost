package com.sasmitha.gproject.model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

@Entity
@Table(name ="Student_Answer_Table")
public class StudentAnswerData {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO )
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "Student_Name")
    private String StudentName;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public Integer getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(Integer numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public Integer getUnAnsweredQuestions() {
        return unAnsweredQuestions;
    }

    public void setUnAnsweredQuestions(Integer unAnsweredQuestions) {
        this.unAnsweredQuestions = unAnsweredQuestions;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Integer getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(Integer studentMarks) {
        this.studentMarks = studentMarks;
    }

    @Column(name = "numberOfQuestions")
    private Integer numberOfQuestions;

    @Column(name = "unAnsweredQuestions")
    private Integer unAnsweredQuestions;

    @Column(name = "totalMarks")
    private Integer totalMarks;

    @Column(name = "studentMarks")
    private Integer studentMarks;

    public Integer getQuestionDataId() {
        return questionDataId;
    }

    public void setQuestionDataId(Integer questionDataId) {
        this.questionDataId = questionDataId;
    }

    @Column(name = "questionDataId")
    private Integer questionDataId;


}
