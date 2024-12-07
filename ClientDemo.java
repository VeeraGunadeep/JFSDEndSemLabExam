package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        // Step 1: Configure Hibernate
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        // Step 2: Open Session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        // 1. Insert Records
        Client client2 = new Client();
        client2.setName("Veera");
        client2.setGender("Male");
        client2.setAge(20);
        client2.setLocation("Hyderabad");
        client2.setEmail("veera@gmail.com");
        client2.setMobileNumber("98765154810");
        
        
        
        Client client3 = new Client();
        client3.setName("Surya");
        client3.setGender("Male");
        client3.setAge(30);
        client3.setLocation("Vijayawada");
        client3.setEmail("surya@gmail.com");
        client3.setMobileNumber("9849743210");
        
        
        Client client4 = new Client();
        client4.setName("Kiran");
        client4.setGender("Male");
        client4.setAge(24);
        client4.setLocation("Kurnool");
        client4.setEmail("kiran@gmail.com");
        client4.setMobileNumber("7786543210");
        session.persist(client2);
        session.persist(client3);
        session.persist(client4);
        transaction.commit();
        
        // 2. Fetch All Records
        session = sessionFactory.openSession();
        List<Client> clients = session.createQuery("from Client", Client.class).list();
        
        System.out.println("All Clients:");
        for (Client client : clients) {
            System.out.println(client);
        }
        
        session.close();
        sessionFactory.close();
    }
}
