package Serialization;

import java.io.*;

public class Serialization_DeSerialization {

    public static void main(String[] args) {
        // writeObject();
        readObject();
    }


    // write Object method - Serialization
    private static void writeObject() {
        System.out.println("User Object is creating");
        User user1 = new User(1L, "Name Surname", "12345678900" );
        User user2 = new User(2L, "Name2 Surname2", "12345678902" );
        User user3 = new User(3L, "Name3 Surname3", "12345678904" );

        try(FileOutputStream fos = new FileOutputStream("user.dat")){ // write a file
            try(ObjectOutputStream oos = new ObjectOutputStream(fos)){ // write an object
                oos.writeObject(user1);
                oos.writeObject(user2);
                oos.writeObject(user3);
            };

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };


    }

    // read Object method - De-Serialization
    private static void readObject() {
        // File reading -> FileInputStream
        try(FileInputStream fis = new FileInputStream("user.dat")) {
            try(ObjectInputStream ois = new ObjectInputStream(fis)){
                User user1 = (User) ois.readObject();
                User user2 = (User) ois.readObject();
                User user3 = (User) ois.readObject();

                System.out.println(user1);
                System.out.println(user2);
                System.out.println(user3);


            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

    }

}


// make transferable of User class
class User implements Serializable {

    // private fields
    private Long id;
    private String name;
    private String tcId;

    // constructor
    public User(Long id, String name, String tcId) {
        this.id = id;
        this.name = name;
        this.tcId = tcId;
    }

    // getter & setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTcId() {
        return tcId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }


    // toString


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tcId='" + tcId + '\'' +
                '}';
    }
}
