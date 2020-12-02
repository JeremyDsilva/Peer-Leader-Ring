package repository;

import org.hibernate.Session;

import entity.User;
import response.Response;
import util.HibernateUtil;

public class UserRepository implements Repository<User, Long> {

    @Override
    public Response<Long> create(User entity) {

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
    public Response<User> read(Long id) {

        Response<User> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            response = Response.of(session.find(User.class, id));
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
    public Response<User> update(User entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response<User> delete(User entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
