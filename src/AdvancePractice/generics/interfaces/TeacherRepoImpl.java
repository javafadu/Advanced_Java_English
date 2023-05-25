package AdvancePractice.generics.interfaces;

public class TeacherRepoImpl implements Repository<Teacher> {
    @Override
    public void save(Teacher teacher) {
        System.out.println(teacher.getName()+ "has been saved successfully");
    }

    @Override
    public void get(Teacher teacher) {
        System.out.println("Teacher Name: "+teacher.getName());
    }

    @Override
    public void update(Teacher teacher) {
        System.out.println(teacher.getName()+ "has been updated successfully");
    }

    @Override
    public void delete(Teacher teacher) {
        System.out.println(teacher.getName()+ "has been deleted successfully");
    }
}
