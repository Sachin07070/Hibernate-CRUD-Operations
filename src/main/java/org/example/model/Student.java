package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Audited;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private int id;
    private String name;
    private double marks;



    public Student(int id, String name , double marks ){
        this.id= id;
        this.name=name;
        this.marks= marks;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
