package repository;

import model.Consult;
import model.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtil;

import java.util.List;

public class ConsultDao {

    public void createConsult(Consult consult) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the consult object
            session.save(consult);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            System.out.println("Something went wrong!");

        } finally {
            session.close();
        }
    }

    public void updateConsult(Consult consult) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the consult object
            session.update(consult);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            System.out.println("Something went wrong!");

        } finally {
            session.close();
        }
    }

    public void deleteConsult(Consult consult) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the consult object
            session.delete(consult);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            System.out.println("Something went wrong!");

        } finally {
            session.close();
        }
    }

    public Consult getConsult(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Consult consult = session.find(Consult.class, id);
            return consult;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong!");

            return null;
        } finally {
            session.close();
        }
    }

    public List<Consult> getConsults() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query query = session.createQuery("from consult", Consult.class);

            List<Consult> consults = query.list();

            return consults;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong!");


            return null;
        } finally {
            session.close();
        }
    }

    public void printAllConsults() {
        List<Consult> consults = getConsults();
        for (Consult consult :
                consults) {
            System.out.println(consult.toString());
        }
    }
}
