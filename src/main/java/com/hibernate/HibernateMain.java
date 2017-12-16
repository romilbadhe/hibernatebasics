package com.hibernate;


import com.hibernate.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

    public static void main(String[] args) {

        // 01.Create Model obj
        UserDetails userDetails = new UserDetails();

        userDetails.setUserId(1);
        userDetails.setUserName("First User");

        // 02.Create a SessionFactory obj and Reads the configuration file (hibernate.cfg.xml)
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //SessionFactory sessionFactory = new Configuration().configure("com/somepackageName/hibernate.cfg.xml").buildSessionFactory();

        // 03.Create a Session obj
        Session session = sessionFactory.openSession();

        // 04.Begin tx
        session.beginTransaction();

        // 05.Save the Model object and commit tx
        session.save(userDetails);
        session.getTransaction().commit();


    }
}
