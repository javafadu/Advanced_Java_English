package AdvancePractice.generics.interfaces;

import AdvancePractice.generics.classes.StudentList;

// TASK:
/*

    Create a program
    - create student and teacher
    - list students and teachers
    - update students and teachers
    - delete students and teachers

 */
public class SchoolManagement {

    public static void main(String[] args) {
        Student student = new Student("Tolstoy");
        Teacher teacher = new Teacher("Balzac");

        StudentRepoImpl studentRepo = new StudentRepoImpl();
        TeacherRepoImpl teacherRepo = new TeacherRepoImpl();

        studentRepo.save(student);
        studentRepo.get(student);
        studentRepo.update(student);
        studentRepo.delete(student);


        teacherRepo.save(teacher);
        teacherRepo.get(teacher);
        teacherRepo.update(teacher);
        teacherRepo.delete(teacher);

    }




}
