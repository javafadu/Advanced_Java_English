package AdvancePractice.generics.interfaces;

public class StudentRepoImpl implements Repository<Student>{

    @Override
    public void save(Student student) {
        System.out.println(student.getName()+ "has been saved successfully");
    }

    @Override
    public void get(Student student) {
        System.out.println("Student Name: "+student.getName());
    }

    @Override
    public void update(Student student) {
        System.out.println(student.getName()+ "has been updated successfully");
    }

    @Override
    public void delete(Student student) {
        System.out.println(student.getName()+ "has been deleted successfully");
    }
}
