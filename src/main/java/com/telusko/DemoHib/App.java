package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        // Create an object to save in the database
        Alien telusko = new Alien();
        

        // Step 1: Configure Hibernate
        Configuration con = new Configuration()
                .configure() // Load the hibernate.cfg.xml configuration file
                .addAnnotatedClass(Alien.class); // Link the POJO (Alien) to Hibernate

        // Step 2: Build a Service Registry
        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties()) // Apply configuration settings
                .build(); // Build the registry

        // Step 3: Create a Session Factory
        SessionFactory sf = con.buildSessionFactory(reg); // Create a factory for sessions

        // Step 4: Open a Session
        Session session = sf.openSession(); // Start a session to interact with the database

        // Step 5: Begin Transaction
        Transaction tx = session.beginTransaction(); // Start a transaction for database operations

        // Step 6: Save the Object
//        session.persist(telusko); // Save the Alien object to the database
        
        telusko = session.get(Alien.class, 104);

        // Step 7: Commit the Transaction
        tx.commit(); // Finalize and apply changes to the database
        
        System.out.println(telusko);

        // Program ends here
    }
}
