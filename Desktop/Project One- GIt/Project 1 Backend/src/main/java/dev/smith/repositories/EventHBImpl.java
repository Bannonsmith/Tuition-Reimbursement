package dev.smith.repositories;

import dev.smith.models.Event;
import dev.smith.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class EventHBImpl implements EventRepo {
    @Override
    public List<Event> getAllEvents() {
        Session session = HibernateUtil.getSession();
        List<Event> events = null;

        try {

            events = session.createQuery("FROM Event").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return events;
    }

    @Override
    public Event getEvents(int id) {

        Session session = HibernateUtil.getSession();
        Event e = null;

        try{
            e = session.get(Event.class, id);
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }

        return e;
    }
}
