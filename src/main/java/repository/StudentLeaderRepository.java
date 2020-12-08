package repository;

import java.util.List;
import java.util.Map;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import entity.StudentLeader;
import response.Response;
import util.HibernateUtil;

public class StudentLeaderRepository implements Repository<StudentLeader, Long> {

    @Override
    public Response<Long> create(StudentLeader entity) {

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
    public Response<StudentLeader> read(Long id) {

        Response<StudentLeader> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            response = Response.of(session.find(StudentLeader.class, id));
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
    public Response<StudentLeader> update(StudentLeader entity) {
        Session session = HibernateUtil.getSession();
        Response<StudentLeader> response;

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
    public Response<Void> delete(StudentLeader entity) {
        Session session = HibernateUtil.getSession();

        Response<Void> response;

        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            response = Response.Ok();
        } catch (Exception e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            response = Response.of(e);
        } finally {
            session.close();
        }

        return response;
    }

    public Response<List<StudentLeader>> readAll() {

        Response<List<StudentLeader>> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<StudentLeader> cq = cb.createQuery(StudentLeader.class);
            Root<StudentLeader> rootEntry = cq.from(StudentLeader.class);
            CriteriaQuery<StudentLeader> all = cq.select(rootEntry);
            TypedQuery<StudentLeader> allQuery = session.createQuery(all);
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

    public Response<Long> countPerRole(String leaderRole) {

        Response<Long> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
            Root<StudentLeader> leader = criteria.from(StudentLeader.class);

            criteria.select(builder.count(leader));

            ParameterExpression<String> role = builder.parameter(String.class);
            criteria.where(builder.equal(leader.get("studentLeaderRole"), role));

            TypedQuery<Long> query = session.createQuery(criteria);
            query.setParameter(role, leaderRole);

            response = Response.of(query.getSingleResult());

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

    public Response<List<Object>> countPerCollege() {

        Response<List<Object>> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object> criteria = builder.createQuery(Object.class);
            Root<StudentLeader> leader = criteria.from(StudentLeader.class);

            criteria.multiselect(leader.get("college") , builder.count(leader.get("id")));
            criteria.groupBy(leader.get("college"));

            TypedQuery<Object> query = session.createQuery(criteria);

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
