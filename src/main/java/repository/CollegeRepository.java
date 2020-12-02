package repository;

import org.hibernate.Session;

import entity.College;
import response.Response;
import util.HibernateUtil;

public class CollegeRepository implements Repository<College, Long> {

    @Override
    public Response<Long> create(College entity) {

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
    public Response<College> read(Long id) {

        Response<College> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            response = Response.of(session.find(College.class, id));
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
    public Response<College> update(College entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response<College> delete(College entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
