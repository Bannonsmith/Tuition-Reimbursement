package dev.smith.repositories;

import dev.smith.models.Department;
import dev.smith.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class DepartmentRepoHBImpl implements DepartmentRepo{
    @Override
    public List<Department> getAllDepartments() {
        Session session = HibernateUtil.getSession();
        List<Department> departments = null;

        try {

            departments = session.createQuery("FROM Department").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return departments;
    }

    @Override
    public Department getDepartment(int id) {
        Session session = HibernateUtil.getSession();
        Department d = null;

        try{
            d = session.get(Department.class, id);
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }

        return d;
    }
}
