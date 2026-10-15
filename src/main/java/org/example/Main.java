package org.example;

import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibrnate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = new Student(105, "shubham", 78.90);

        session.persist(student);
        transaction.commit();

// update operation
        System.out.println("Student Saved Successfully");

        Transaction updateTransaction = session.beginTransaction();
        Student student1 = session.find(Student.class, 101);

        if (student1 != null) {
            student1.setName("sahil");
            student1.setMarks(85.50);
        }

        updateTransaction.commit();
        System.out.println("student update succefully");

        // DELETE operation
        Transaction deleteTransaction = session.beginTransaction();

        Student student2 = session.find(Student.class, 104);

        if (student2 != null) {
            session.remove(student2);
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Student not found");
        }

        deleteTransaction.commit();

        // Close resources after all operations
        session.close();
        sessionFactory.close();
    }
}
