package dev.smith.repositories;

import dev.smith.models.Grade;
import dev.smith.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class GradeRepoHBImpl implements GradeRepo {


    @Override
    public List<Grade> getAllGrades() {
        Session session = HibernateUtil.getSession();
        List<Grade> grades = null;

        try {

            grades = session.createQuery("FROM Grade").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return grades;
    }

    @Override
    public Grade getGrade(int id) {
        Session session = HibernateUtil.getSession();
        Grade g = null;

        try{
            g = session.get(Grade.class, id);
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }

        return g;
    }
}
