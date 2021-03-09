package repository;

import model.Pet;
import model.Vet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtil;

import java.util.List;

public class VetDao {
    public void createVet(Vet vet) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the vetet object
            session.save(vet);
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

    public void updateVet(Vet vet) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the vet object
            session.update(vet);
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

    public void deleteVet(Vet vet) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the vet object
            session.delete(vet);
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

    public Vet getVet(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Vet vet = session.find(Vet.class, id);
            return vet;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong!");

            return null;
        } finally {
            session.close();
        }
    }

    public List<Vet> getVets() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query query = session.createQuery("from Vet", Vet.class);

            List<Vet> vets = query.list();

            return vets;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong!");

            return null;
        } finally {
            session.close();
        }

    }

    public void printAllVets() {
        List<Vet> vets = getVets();
        for (Vet vet :
                vets) {
            System.out.println(vet.toString());
        }
    }
}
