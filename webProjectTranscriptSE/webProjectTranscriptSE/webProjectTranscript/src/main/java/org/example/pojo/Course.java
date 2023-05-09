package org.example.pojo;

public class Course {

    String title;
    String number;
    String utdsem;
    String transfer;
    String grade;

    String points;

public Course() {

}

    public Course(String title, String number, String utdsem, String transfer, String grade, String points) {
        this.title = title;
        this.number = number;
        this.utdsem = utdsem;
        this.transfer = transfer;
        this.grade = grade;
        this.points = points;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUtdsem() {
        return utdsem;
    }

    public void setUtdsem(String utdsem) {
        this.utdsem = utdsem;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
