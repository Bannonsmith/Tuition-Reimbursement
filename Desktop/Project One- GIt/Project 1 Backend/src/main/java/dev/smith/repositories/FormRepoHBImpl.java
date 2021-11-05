package dev.smith.repositories;

import dev.smith.models.Form;
import dev.smith.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FormRepoHBImpl implements FormRepo {

    @Override
    public Form addForm(Form f) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            f.setFormId((int)session.save(f));
            session.getTransaction().commit();
        } catch (HibernateException h) {
            h.printStackTrace();
            session.getTransaction().rollback();
            f = null;
        } finally {
            session.close();
        }


        return f;
    }

    @Override
    public List<Form> getAllForms() {
        Session session = HibernateUtil.getSession();
        List<Form> forms = null;

        try {

            forms = session.createQuery("FROM Form").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return forms;
    }

    @Override
    public Form getForm(int id) {
        Session session = HibernateUtil.getSession();
        Form f = null;

        try{
            f = session.get(Form.class, id);
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }

        return f;
    }

    @Override
    public Form updateForm(Form change) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;


        try {
            tx = session .beginTransaction();
            session.update(change);
            tx.commit();
        } catch (HibernateException h) {
            h.printStackTrace();
            assert tx != null;
            tx.rollback();
            return null;
        } finally {
            session.close();
        }


        return change;
    }

    @Override
    public Form deleteForm(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Form> getAllFormsByEmployeeId(int id) {
        Session session = HibernateUtil.getSession();
        List<Form> forms = null;

        try {

            // forms = session.createQuery("FROM FORM WHERE form_employee_id = ?").list();
            Query query = session.createQuery("FROM Form WHERE form_employee_id = :employee_id");
            query.setParameter("employee_id", id);
            forms = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return forms;
    }


}
