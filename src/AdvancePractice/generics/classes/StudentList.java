package AdvancePractice.generics.classes;

import java.util.ArrayList;
import java.util.List;

// TASK:
/*
    1-) Write a code, to list students together with students' name, students' exam note, students' final note
    2-) Write a code, to list students together with students' name, school no, email address
 */
public class StudentList {

    public static void main(String[] args) {

        Student<String, Double, Double> std1 = new Student<>("Vilma",44.5,67.2);
        Student<String, Double, Double> std2 = new Student<>("Betty",88.7,77.2);
        Student<String, Double, Double> std3 = new Student<>("Brad",55.3,82.2);


        List<Student> stdList = new ArrayList<>();
        stdList.add(std1);
        stdList.add(std2);
        stdList.add(std3);

        System.out.println("***** STUDENT EXAM INFO *****");
        listExam(stdList);


        Student<String, Integer, String> stdLib1 = new Student<>("Vilma",123,"email1@mail.com");
        Student<String, Integer, String> stdLib2 = new Student<>("Betty",124,"email2@mail.com");
        Student<String, Integer, String> stdLib3 = new Student<>("Brad",125,"email3@mail.com");

        List<Student> stdLibList = new ArrayList<>();
        stdLibList.add(stdLib1);
        stdLibList.add(stdLib2);
        stdLibList.add(stdLib3);

        System.out.println("");

        System.out.println("***** STUDENT LIBRARY INFO *****");
        listLibrary(stdLibList);

    }

    // student visa information method
    public static void listExam(List<Student> stdList) {

        System.out.printf("%-10s || %4s || %4s %n","Student","Visa","Final");

        stdList.forEach((s)-> System.out.printf("%-10s || %4s || %4s %n",s.getS(),s.getU(),s.getV()));

    }

    public static void listLibrary(List<Student> stdLibList) {
        System.out.printf("%-10s || %4s || %4s %n","Student","L-No","Mail");

        stdLibList.forEach((s)-> System.out.printf("%-10s || %4d || %-20s %n",s.getS(),s.getU(),s.getV()));
    }


}
