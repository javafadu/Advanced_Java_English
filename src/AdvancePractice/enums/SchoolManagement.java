package AdvancePractice.enums;

// Task: School Management Application
/*
- delete student and teacher
- user roles (Admin, Teacher, Student) and delete authorization based on the role
- delete student -> Admin and Teacher can delete
- delete teacher -> Admin can delete
 */
public class SchoolManagement {
    public static void main(String[] args) {

        Student student = new Student("Student");
        Teacher teacher = new Teacher("Teacher");

        User user1 = new User("Jules Verne", Role.ROLE_ADMIN);
        User user2 = new User("Charles Dickens", Role.ROLE_TEACHER);
        User user3 = new User("John Steinbeck", Role.ROLE_STUDENT);

        deleteStudent(student, user2);
        deleteTeacher(teacher,user2);

    }

    // delete student method
    public static void deleteStudent(Student std, User user) {
        if(user.getRole().equals(Role.ROLE_ADMIN) || user.getRole().equals(Role.ROLE_TEACHER)) {
            System.out.println("Student deleted successfully by "+user.getRole().getName() );
        } else {
            System.out.println("Not authorized to delete by "+user.getRole().getName());
        }
    }

    // delete teacher method
    public static void deleteTeacher(Teacher tcr, User user) {
        if(user.getRole().equals(Role.ROLE_ADMIN)) {
            System.out.println("Teacher deleted successfully by "+user.getRole().getName() );
        } else {
            System.out.println("Not authorized to delete by "+user.getRole().getName());
        }
    }


}
