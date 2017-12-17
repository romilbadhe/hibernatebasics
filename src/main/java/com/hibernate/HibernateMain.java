package com.hibernate;

import com.hibernate.dto.Address;
import com.hibernate.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HibernateMain {

    public static void main(String[] args) {

        // 01.Create Model obj
        UserDetails userDetails1 = new UserDetails();

        //userDetails.setUserId(1);
        userDetails1.setUserName("First User");
        userDetails1.setPassword("password");
        userDetails1.setJoinedDate(new Date());

        // Creating object of Address
        Address address = new Address();

        address.setState("New York");
        address.setCity("NY City");
        address.setStreet("13th Broadway");
        address.setPincode("455110");

        // Creating object of Address(@AttributeOverride)
        Address officeAddress = new Address();
        officeAddress.setStreet("Wall Street");
        officeAddress.setCity(address.getCity());
        officeAddress.setState(address.getState());
        officeAddress.setPincode("447770");

        userDetails1.setAddress(address);
        userDetails1.setOfficeAddress(officeAddress);

        userDetails1.setDescription("Here is some description");


        // 02.Create a SessionFactory obj and Reads the configuration file (hibernate.cfg.xml)
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        //SessionFactory sessionFactory = new Configuration().configure("com/somepackageName/hibernate.cfg.xml").buildSessionFactory();

        // 03.Create a Session obj
        Session session = sessionFactory.openSession();

        // 04.Begin tx
        session.beginTransaction();

        // 05.Save the Model object and commit tx
        session.save(userDetails1);

        UserDetails userDetails2 = new UserDetails();

        userDetails2.setUserName("Second User");
        userDetails2.setDescription("Other Description");

        String sDate1="31/12/1998";

            try {
            Date joinDate =new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            userDetails2.setJoinedDate(joinDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        session.save(userDetails2);

        session.getTransaction().commit();

        session.close();


        //Fetching data from DB

        userDetails1 = null;
        userDetails2 = null;

        session = sessionFactory.openSession();
        session.beginTransaction();

        userDetails1 = session.get(UserDetails.class, 1) ; // Object to be retrieved  from DB, Data to be retrieved

        userDetails2 = session.get(UserDetails.class, 2);

        System.out.println(userDetails1.toString());
        System.out.println(userDetails2.toString());

        session.close();

    }
}
