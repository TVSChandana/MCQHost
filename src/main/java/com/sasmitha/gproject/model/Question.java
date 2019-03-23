package com.sasmitha.gproject.model;

import javax.persistence.*;

@Entity
@Table(name = "Question")
public class Question {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "Set_ID")
        private Integer Set_ID;


        @Column(name = "Question_No")
        private Integer Question_No;


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

        @Column(name = "Mark")
        private Integer Mark;


    public String getQuest() {
        return Quest;
    }

    public void setQuest(String quest) {
        Quest = quest;
    }

    public Integer getSet_ID() {
        return Set_ID;
    }

    public void setSet_ID(Integer set_ID) {
        Set_ID = set_ID;
    }

    public Integer getQuestion_No() {
        return Question_No;
    }

    public void setQuestion_No(Integer question_No) {
        Question_No = question_No;
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

