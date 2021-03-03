package repository;

import model.Vet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtil;

import java.util.List;

public class VetDao {
    public void createVet(Vet vet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
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
        }
    }

    public void updateVet(Vet vet){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
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
        }
    }

    public void deleteVet(Vet vet){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
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
        }
    }

    public Vet getVet(String lastName){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Vet vet = session.find(Vet.class, lastName);
            return vet;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Vet> getVets() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from vet", Vet.class);

            List<Vet> vets = query.list();

            return vets;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
