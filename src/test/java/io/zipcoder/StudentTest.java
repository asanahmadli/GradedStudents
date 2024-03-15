package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StudentTest {

    @Test

    public void getExamScores() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);
        String expected = "" +
                "Exam 1 -> 100\n" +
                "Exam 2 -> 95\n" +
                "Exam 3 -> 123\n" +
                "Exam 4 -> 96";

        String actual = student.getExamScores();
        Assert.assertEquals(expected,actual);
    }


   @Test
    public void addExamScore(){

       // : Given
       String firstName = "Leon";
       String lastName = "Hunter";
       Double[] examScores = { };
       Student student = new Student(firstName, lastName, examScores);

// When
       student.addExamScore(100.0);
       String expected = "Exam 1 -> 100";
       String actual = student.getExamScores();

// Then
       Assert.assertEquals(expected,actual);

   }

    @Test
    public void setExamScore(){

        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores);

// When

        student.setExamScore(0, 150.0);
        String actual = student.getExamScores();
        String expected = "Exam 1 -> 150";

// Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getAverageExamScore(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        Double actual = student.getAverageExamScore();
        Double expected = 125.0;
        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void stringToString(){

        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String actual = student.toString();
        String expected = "Student Name: Leon Hunter\n" +
                "> Average Score: 125\n" +
                "> Exam Scores:\n" +
                "Exam 1 -> 100\n" +
                "Exam 2 -> 150\n" +
                "Exam 3 -> 250\n" +
                "Exam 4 -> 0";

        // Then
        Assert.assertEquals(expected,actual);


    }

}