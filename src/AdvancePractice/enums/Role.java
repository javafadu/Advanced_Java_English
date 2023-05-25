package AdvancePractice.enums;

public enum Role {
    ROLE_ADMIN ("Admin"),
    ROLE_TEACHER("Teacher"),
    ROLE_STUDENT("Student");

    String name;

    // Constructor
    Role (String name) {
        this.name =name;
    }

    // Getter
    public String getName() {
        return name;
    }
}
