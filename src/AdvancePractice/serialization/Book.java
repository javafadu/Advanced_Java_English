package AdvancePractice.serialization;

import java.io.Serializable;

public class Book implements Serializable {

    // private fields
    private String name;
    private String author;
    private Integer publishYear;

    // constructor
    public Book(String name, String author, Integer publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    // getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }


    // toString


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }
}
