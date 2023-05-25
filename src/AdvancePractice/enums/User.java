package AdvancePractice.enums;

public class User {

    // private fields
    private String name;
    private Role role;

    // Constructor
    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // ToString
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
