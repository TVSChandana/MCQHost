package com.sasmitha.gproject.model;

import javax.persistence.*;

@Entity
@Table(name = "Question")
public class Question {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "Question_ID")
        private Integer Question_ID;


        @Column(name = "Question_Data_Id")
        private Integer Question_Data_Id;


        @Column(name = "Question")
        private String Quest;

        @Column(name = "Ans_1")
        private String Ans_1;

        @Column(name = "Ans_2")
        private String Ans_2;

        @Column(name = "Ans_3")
        private String Ans_3;

        @Column(name = "Ans_4")
        private String Ans_4;

        @Column(name = "Correct_Ans")
        private Integer Correct_Ans;

    public Integer getCorr_Ans_1() {
        return Corr_Ans_1;
    }

    public void setCorr_Ans_1(Integer corr_Ans_1) {
        Corr_Ans_1 = corr_Ans_1;
    }

    public Integer getCorr_Ans_2() {
        return Corr_Ans_2;
    }

    public void setCorr_Ans_2(Integer corr_Ans_2) {
        Corr_Ans_2 = corr_Ans_2;
    }

    public Integer getCorr_Ans_3() {
        return Corr_Ans_3;
    }

    public void setCorr_Ans_3(Integer corr_Ans_3) {
        Corr_Ans_3 = corr_Ans_3;
    }

    public Integer getCorr_Ans_4() {
        return Corr_Ans_4;
    }

    public Integer getQuestion_ID() {
        return Question_ID;
    }

    public void setQuestion_ID(Integer question_ID) {
        Question_ID = question_ID;
    }

    public Integer getQuestion_Data_Id() {
        return Question_Data_Id;
    }

    public void setQuestion_Data_Id(Integer question_Data_Id) {
        Question_Data_Id = question_Data_Id;
    }

    public void setCorr_Ans_4(Integer corr_Ans_4) {
        Corr_Ans_4 = corr_Ans_4;
    }

        @Column(name = "Mark")
        private Integer Mark;

        @Column(name = "Corr_Ans_1")
        private Integer Corr_Ans_1;

        @Column(name = "Corr_Ans_2")
        private Integer Corr_Ans_2;

        @Column(name = "Corr_Ans_3")
        private Integer Corr_Ans_3;

    public Integer getQuestion_Number() {
        return Question_Number;
    }

    public void setQuestion_Number(Integer question_Number) {
        Question_Number = question_Number;
    }

    @Column(name = "Corr_Ans_4")
        private Integer Corr_Ans_4;

        @Column(name="Question_Number")
        private Integer Question_Number;

    public String getQuest() {
        return Quest;
    }

    public void setQuest(String quest) {
        Quest = quest;
    }





    public String getAns_1() {
        return Ans_1;
    }

    public void setAns_1(String ans_1) {
        Ans_1 = ans_1;
    }

    public String getAns_2() {
        return Ans_2;
    }

    public void setAns_2(String ans_2) {
        Ans_2 = ans_2;
    }

    public String getAns_3() {
        return Ans_3;
    }

    public void setAns_3(String ans_3) {
        Ans_3 = ans_3;
    }

    public String getAns_4() {
        return Ans_4;
    }

    public void setAns_4(String ans_4) {
        Ans_4 = ans_4;
    }

    public Integer getCorrect_Ans() {
        return Correct_Ans;
    }

    public void setCorrect_Ans(Integer correct_Ans) {
        Correct_Ans = correct_Ans;
    }

    public Integer getMark() {
        return Mark;
    }

    public void setMark(Integer mark) {
        Mark = mark;
    }
}

