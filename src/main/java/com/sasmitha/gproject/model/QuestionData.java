package com.sasmitha.gproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Question_Data")
public class QuestionData {

    @Id
    @Column(name="UserID")
    private Integer UserID;

    @Column(name="SetID")
    private Integer SetID;

    @Column(name="NumberOfQuestions")
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
