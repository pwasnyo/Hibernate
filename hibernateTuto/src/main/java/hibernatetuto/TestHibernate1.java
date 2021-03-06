package main.java.hibernatetuto;

import java.math.BigDecimal;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestHibernate1 {

    public static void main(String args[]) throws Exception {
        
        SessionFactory sessionFactory = new AnnotationConfiguration().configure("main/resources/hibernate.cfg.xml").buildSessionFactory();

        Transaction transaction = null;
        int index = 5;
        Session session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            /*Compte c = new Compte("A12", new BigDecimal(1200));
            select * from compte;
             id | numero | solde 
            ----+--------+-------
              1 | A12    |  1200*/
            //il faut vérifier que le numéro de compte existe déjà
            /*Compte c = new CompteCourant(200,"A12", new BigDecimal(1200));        
            select * from compte_courant ;
             id | numero | solde | decouvert 
            ----+--------+-------+-----------
              2 | A12    |  1200 |       200 */
            
            Compte c = new CompteEpargne(new BigDecimal(2.3),"A12", new BigDecimal(1200));
            /*
            select * from compte_epargne ;
             id | numero | solde | taux 
            ----+--------+-------+------
              3 | A12    |  1200 |  2.3
            */          
            session.save(c);
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
