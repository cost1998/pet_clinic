package repository;

import model.Consult;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtil;

import java.util.List;

public class ConsultDao {

    public void createConsult(Consult consult) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
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
        }
    }

    public void updateConsult(Consult consult){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
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
        }
    }

    public void deleteConsult(Consult consult){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
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
        }
    }

    public Consult getConsult(long id){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Consult consult = session.find(Consult.class,id );
            return consult;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<Consult> getConsults() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from consult", Consult.class);

            List<Consult> consults = query.list();

            return consults;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
