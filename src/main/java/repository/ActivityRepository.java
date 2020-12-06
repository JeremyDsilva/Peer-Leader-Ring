package repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import entity.Activity;
import response.Response;
import util.HibernateUtil;

public class ActivityRepository implements Repository<Activity, Long> {

    @Override
    public Response<Long> create(Activity entity) {

        Response<Long> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            response = Response.of((Long) session.save(entity));
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            response = Response.of(e);
        } finally {
            session.close();
        }

        return response;
    }

    @Override
    public Response<Activity> read(Long id) {

        Response<Activity> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            response = Response.of(session.find(Activity.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            response = Response.of(e);
        } finally {
            session.close();
        }

        return response;
    }

    @Override
    public Response<Activity> update(Activity entity) {
        Session session = HibernateUtil.getSession();
        Response<Activity> response;
        
        try {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            response = Response.of(entity);
        } catch (Exception e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            response = Response.of(e);
        } finally {
            session.close();
        }
        
        return response;       
    }

    @Override
    public Response<Activity> delete(Activity entity) {
        // TODO Auto-generated method stub
        return null;
    }

    public Response<List<Activity>> readAll() {

        Response<List<Activity>> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Activity> cq = cb.createQuery(Activity.class);
            Root<Activity> rootEntry = cq.from(Activity.class);
            CriteriaQuery<Activity> all = cq.select(rootEntry);
            TypedQuery<Activity> allQuery = session.createQuery(all);
            response = Response.of(allQuery.getResultList());
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            response = Response.of(e);
        } finally {
            session.close();
        }

        return response;

    }

}
