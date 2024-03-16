package io.zipcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Classroom  {


    private List<Student> students;
    private int maxNumberOfStudents;

    public Classroom(int maxNumberOfStudents){
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.students = new ArrayList<>();
    }

    public Classroom(Student[] student){
        this.students = new ArrayList<>(List.of(student));
    }

    public Classroom(){
        Student[] students = new Student[30];
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public Double getAverageExamScore(){
        Double d1 = students.get(0).getAverageExamScore();
        Double d2 = students.get(1).getAverageExamScore();
        return (d2+d1)/students.size();
    }

  public  void addStudent(Student student){
       students.add(student);
  }

  public void removeStudent(String firstName, String lastName){
        for(int i=0; i<students.size();i++){
            Student st = students.get(i);
            if(st.getFirstName().equals(firstName)&&st.getLastName().equals(lastName)){
                students.remove(i);
                break;
            }
        }
  }

        public void getStudentsByScore() {
            //create array store score values
            double[] score = new double[students.size()];
            //create two empty array for firstname and lastname
            String[] firstName = new String[students.size()];
            String[] lastName = new String[students.size()];

            //find all average
            for (int i = 0; i < students.size(); i++) {
                score[i] = students.get(i).getAverageExamScore();
            }

            //find all firstName
            for (int i = 0; i < students.size(); i++) {
                firstName[i] = students.get(i).getFirstName();
            }

            //find all lastName
            for (int i = 0; i < students.size(); i++) {
                lastName[i] = students.get(i).getLastName();
            }


            //find descending order
            //iterate entire array
            for (int i = 0; i < score.length; i++) {

                for (int k = i; k < score.length - 1; k++) {
                    //compare array first value with all the rest of values in the array
                    if (score[i] < score[k + 1]) {
                        //create variable to store i early value
                        double temp = score[i];
                        score[i] = score[k + 1];
                        score[k + 1] = temp;
                    }
                }//inner loop

            }//outer loop

            HashMap<Double, String> hashMap = new HashMap<>();
            StringBuilder sb = new StringBuilder();
                for (int j = 0; j < score.length; j++) {
                    for(int l=0;l<score.length;l++) {
                        if (score[j]==students.get(l).getAverageExamScore()) {
                            String fullName = students.get(l).getFirstName() + " " + students.get(l).getLastName();
                            hashMap.put(score[j], fullName);
                            if(!sb.toString().contains(fullName)){
                                sb.append(fullName).append(" ").append(score[j]).append("\n");
                            }

                        }
                    }//inner loop
                }//outer loop

            System.out.println(sb.toString().trim());

        }

}
