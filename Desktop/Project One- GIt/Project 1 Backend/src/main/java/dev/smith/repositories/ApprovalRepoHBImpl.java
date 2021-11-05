package dev.smith.repositories;

import dev.smith.models.Approval;
import dev.smith.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ApprovalRepoHBImpl implements ApprovalRepo{
    @Override
    public Approval addApproval(Approval a) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();

            a.setApprovalId((int)session.save(a));

            session.getTransaction().commit();
        } catch (HibernateException h) {
            h.printStackTrace();
            session.getTransaction().rollback();
            a = null;
        } finally {
            session.close();
        }


        return a;
    }

    @Override
    public List<Approval> getAllApprovals() {
        Session session = HibernateUtil.getSession();
        List<Approval> approvals = null;

        try {

            approvals = session.createQuery("FROM Approval").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return approvals;    }

    @Override
    public Approval getApproval(int id) {
        Session session = HibernateUtil.getSession();
        Approval a = null;

        try{
            a = session.get(Approval.class, id);
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }

    @Override
    public Approval updateApproval(Approval change) {
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
    public Approval deleteApproval(int id) {
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
    public List<Approval> getAllApprovalsByEmployeeId(int id) {

        Session session = HibernateUtil.getSession();
        List<Approval> approvals = null;

        try {

           // approvals = session.createQuery("FROM Approval WHERE approval_employee_id = ?").list();
            Query query = session.createQuery("FROM Approval WHERE approval_employee_id = :employee_id");
            query.setParameter("employee_id", id);
            approvals = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return approvals;
    }

}
