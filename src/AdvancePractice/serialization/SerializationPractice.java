package AdvancePractice.serialization;

import java.io.*;

// create Book type object and write them into the books.txt and read object from book.txt
public class SerializationPractice {
    public static void main(String[] args) {
        // writeObject();
        readObject();
    }

    public static void writeObject() {
        Book book1 = new Book("Les Misérables", "Victor Hugo", 1862);
        Book book2 = new Book("Animal Farm", "George Orwell", 1945);
        Book book3 = new Book("Anna Karenina", "Leo Tolstoy", 1878);

        try {
            FileOutputStream fos = new FileOutputStream("books.txt"); // create file
            ObjectOutputStream oos = new ObjectOutputStream(fos); // write objects
            oos.writeObject(book1);
            oos.writeObject(book2);
            oos.writeObject(book3);

            oos.close();
            fos.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void readObject() {
        try {
            FileInputStream fis = new FileInputStream("books.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Book  book1 = (Book) ois.readObject();
            Book  book2 = (Book) ois.readObject();
            Book  book3 = (Book) ois.readObject();

            System.out.println(book1);
            System.out.println(book2);
            System.out.println(book3);

            ois.close();
            fis.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }



}
