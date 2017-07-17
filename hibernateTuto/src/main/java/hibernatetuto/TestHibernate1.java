package main.java.hibernatetuto;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class TestHibernate1 {

    public static void main(String args[]) throws Exception {

//        ClassLoader cl = ClassLoader.getSystemClassLoader();
//
//        URL[] urls = ((URLClassLoader) cl).getURLs();
//
//        for (URL url : urls) {
//            System.out.println(url.getFile());
//        }
        SessionFactory sessionFactory = new AnnotationConfiguration().configure("main/resources/hibernate.cfg.xml").buildSessionFactory();

        Transaction transaction = null;
        int index = 6;
        Session session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            Adresse adresse = new Adresse("ligne1_" + index, "ligne2_" + index, "cp_"
                    + index, "ville" + index, "ligne3_" + index);
            Personne personne = new Personne("nom" + index, "prenom_" + index, null, adresse);
            System.out.println("PERSONNE ID IS " + personne.getId());
            adresse.setPersonne(personne);// on doit setter en mode bidirectionnel le maître dans l'esclave avant de sauvegarder
            session.save(personne);
            transaction.commit();

            System.out.println("La nouvelle personne a été enregistrée");

        } catch (Exception e) { //permet de voir plus précisément le problème en db

            e.printStackTrace();
            Throwable t = e;
            while (t.getCause() != null) {
                t = t.getCause();
            }
            if (t instanceof SQLException) {
                ((SQLException) t).getNextException().printStackTrace();
            }

            transaction.rollback();
        } finally {
            session.close();
        }

        sessionFactory.close();
    }
}
