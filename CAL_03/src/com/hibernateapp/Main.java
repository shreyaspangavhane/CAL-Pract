package com.hibernateapp;

import com.hibernateapp.model.User;
import com.hibernateapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        User user = new User("john_doe", "john@example.com");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(user);

        tx.commit();
        session.close();

        System.out.println("User saved successfully.");
    }
}