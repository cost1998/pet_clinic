package repository;

import model.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtil;

import java.util.List;

public class PetDao {

    public void createPet(Pet pet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the pet object
            session.save(pet);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updatePet(Pet pet){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the pet object
            session.update(pet);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deletePet(Pet pet){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the pet object
            session.delete(pet);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public Pet getPet(String name){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Pet pet = session.find(Pet.class,name );
            return pet;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Pet> getPets() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from pet", Pet.class);

            List<Pet> pets = query.list();

            return pets;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
