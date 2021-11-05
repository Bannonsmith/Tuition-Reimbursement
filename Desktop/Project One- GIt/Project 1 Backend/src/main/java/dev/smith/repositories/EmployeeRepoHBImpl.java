package dev.smith.repositories;

import dev.smith.models.Employee;
import dev.smith.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class EmployeeRepoHBImpl implements EmployeeRepo{

    @Override
    public Employee addEmployee(Employee e) {

        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();

            e.setEmployee_id((int)session.save(e));

            session.getTransaction().commit();
        } catch (HibernateException h) {
            h.printStackTrace();
            session.getTransaction().rollback();
            e = null;
        } finally {
            session.close();
        }


        return e;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Session session = HibernateUtil.getSession();
        List<Employee> employees = null;

        try {

            employees = session.createQuery("FROM Employee").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employees;
    }

    @Override
    public Employee getEmployee(int id) {

        Session session = HibernateUtil.getSession();
        Employee e = null;

        try{
            e = session.get(Employee.class, id);
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }

        return e;
    }

    @Override
    public Employee getEmployee(String name) {

        Session session = HibernateUtil.getSession();
        Employee e = null;

        try {
            Criteria crit = session.createCriteria(Employee.class);
            crit.add(Restrictions.eq("name", name));

            // Cant be sure it would return only one name
          //  e = (Employee) crit.uniqueResult();

            List<Employee> employees = crit.list();

            if(employees.size() > 0) {
                e = (Employee) crit.list().get(0);
            }
            //Can switch it to a list if you think it would return multiple which is what we should probably do
        } catch (HibernateException h) {
            h.printStackTrace();

        }

        return e;
    }

    @Override
    public Employee updateEmployee(Employee change) {

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
    public Employee deleteEmployee(int id) {

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
}
