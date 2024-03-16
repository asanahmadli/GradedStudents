package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassroomTest {

    @Test
    public void getAverageExamScore(){

        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double actual = classroom.getAverageExamScore();
        double expected = 125;

        // Then
        Assert.assertEquals(expected,actual,0.0001);
    }

    @Test
    public  void addStudent(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents().toArray(new Student[0]);
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents().toArray(new Student[0]);

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        String expected = "[]";
        String actual = preEnrollmentAsString;
        Assert.assertEquals(expected,actual);
        List<Integer> list = new ArrayList<>();

        String expected1 = "[Student Name: Leon Hunter\n" +
                "> Average Score: 125\n" +
                "> Exam Scores:\n" +
                "Exam 1 -> 100\n" +
                "Exam 2 -> 150\n" +
                "Exam 3 -> 250\n" +
                "Exam 4 -> 0]";
        String actual1 = postEnrollmentAsString;
        Assert.assertEquals(expected1,actual1);
    }

    @Test
    public void removeStudent(){
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Classroom classroom = new Classroom();
        classroom.addStudent(student);
        int expected = 0;
        classroom.removeStudent("Leon","Hunter");
        int actual = classroom.getStudents().size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getStudentsByScore(){
        Double[] examScores1 = { 10000.0, 100.0, 250.0, 3000.0 };
        Student student1 = new Student("Leon", "Hunter", examScores1);
        Double[] examScores2 = { 100.0, 10.0, 250.0, 3.0 };
        Student student2 = new Student("Joe", "Hunter", examScores2);
        Double[] examScores3 = { 1000.0, 100.0, 250.0, 3000.0 };
        Student student3 = new Student("Andy", "Traveler", examScores3);

        Student[] s = {student1,student2,student3};
        Classroom classroom = new Classroom(s);
        //System.out.println(Arrays.toString(classroom.getStudentsByScore()));
        classroom.getStudentsByScore();


    }

}
