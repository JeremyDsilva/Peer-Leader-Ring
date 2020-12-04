package repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

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

    public Response<List<User>> readAll(String userRole) {

        Response<List<User>> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> q = cb.createQuery(User.class);
            Root<User> u = q.from(User.class);
            ParameterExpression<String> role = cb.parameter(String.class);
            q.select(u).where(cb.equal(u.get("userRole"), role));

            TypedQuery<User> query = session.createQuery(q);
            query.setParameter(role, userRole);
            response = Response.of(query.getResultList());

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
