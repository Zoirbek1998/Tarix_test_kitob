package com.example.tarix.Model;

public class QuestionModel {

    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    int correcticAns;

    public QuestionModel(String question, String optionA, String optionB, String optionC, String optionD, int correcticAns) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correcticAns = correcticAns;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public int getCorrecticAns() {
        return correcticAns;
    }

    public void setCorrecticAns(int correcticAns) {
        this.correcticAns = correcticAns;
    }
}
