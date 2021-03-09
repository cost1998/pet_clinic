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
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
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
            System.out.println("Something went wrong!");
        }finally {
            session.close();
        }
    }

    public void updatePet(Pet pet){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
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
            System.out.println("Something went wrong!");
        }finally {
            session.close();
        }
    }

    public void deletePet(Pet pet){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
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
            System.out.println("Something went wrong!");
        }finally {
            session.close();
        }
    }

    public Pet getPet(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Pet pet = session.get(Pet.class,id);
            return pet;
        } catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Something went wrong!");
            return null;
        }finally {
            session.close();
        }
    }

    public List<Pet> getPets() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query query = session.createQuery("from Pet", Pet.class);

            List<Pet> pets = query.list();

            return pets;
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Something went wrong!");
            return null;
        }finally {
            session.close();
        }
    }
    
    public void printAllPets(){
        List<Pet> pets = getPets();
        for (Pet pet:
             pets) {
            System.out.println(pet.toString());
        }
    }
}
