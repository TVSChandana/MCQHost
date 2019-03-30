package com.sasmitha.gproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Question_Data")
public class QuestionData {

    @Id
    @Column(name="Question_DataID")
    private Integer QuestionDataID;

    @Column(name="UserID")
    private Integer UserID;

    public Integer getQuestionDataID() {
        return QuestionDataID;
    }

    public void setQuestionDataID(Integer questionDataID) {
        QuestionDataID = questionDataID;
    }

    @Column(name="SetID")
    private Integer SetID;

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    @Column(name="Created_Date")
    private Date CreatedDate;

    public String getTestName() {
        return TestName;
    }

    public void setTestName(String testName) {
        TestName = testName;
    }

    @Column(name="Test_Name")
    private String TestName;

    @Column(name="Number_Of_Questions")
    private Integer NumberOfQuestions;


    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getSetID() {
        return SetID;
    }

    public void setSetID(Integer setID) {
        SetID = setID;
    }

    public Integer getNumberOfQuestions() {
        return NumberOfQuestions;
    }

    public void setNumberOfQuestions(Integer numberOfQuestions) {
        NumberOfQuestions = numberOfQuestions;
    }
}
