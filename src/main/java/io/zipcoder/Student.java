package io.zipcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private List<Double> examScore;

    public Student(){

    };
    public Student(String firstName, String lastName, Double[] examScore){

        this.firstName = firstName;
        this.lastName = lastName;
        this.examScore = new ArrayList<>(List.of(examScore));

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Double> getExamScore() {
        return examScore;
    }

    public int getNumberOfExamsTaken(){
        return examScore.size();
    }

    public String getExamScores(){

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(Double d:examScore){
            i++;
            String str =  "Exam "+i+" -> "+ d.intValue();
            sb.append(str).append("\n");
        }
        return sb.toString().trim();
    }



    public void addExamScore(double score){
        examScore.add(score);
    }


    public void setExamScore(int number,double value){

        try {
            examScore.set(number,value);
        }
        catch (Exception e){
            System.out.println("Array list doesn't have that index number " +e.getMessage());
        }

    }

    public Double getAverageExamScore(){
        double sum = 0;
        for(Double d:examScore){
            sum+=d;
        }
        return sum/examScore.size();
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String studentName = getFirstName();
        String lastName = getLastName();
        int averageScore = getAverageExamScore().intValue();

        String examsSore = getExamScores();
        sb.append("Student Name: ").append(studentName+" ").append(lastName+"\n").
                append("> Average Score: ").append(averageScore).append("\n")
                .append("> Exam Scores:"+"\n").append(examsSore);

        return sb.toString();
    }





}
