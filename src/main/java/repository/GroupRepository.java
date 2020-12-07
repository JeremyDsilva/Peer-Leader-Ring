package repository;

import org.hibernate.Session;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import entity.Group;
import response.Response;
import util.HibernateUtil;

public class GroupRepository implements Repository<Group, Long> {

    @Override
    public Response<Long> create(Group entity) {

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
    public Response<Group> read(Long id) {

        Response<Group> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Group group = session.find(Group.class, id);
            session.getTransaction().commit();
            group.getStudents().size();
            response = Response.of(group);
        } catch (Exception e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            response = Response.of(e);
        } finally {
            session.close();
        }

        return response;
    }

    public Response<Group> read(String groupName) {

        Response<Group> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Group> q = cb.createQuery(Group.class);
            Root<Group> g = q.from(Group.class);
            ParameterExpression<String> expression = cb.parameter(String.class);
            q.select(g).where(cb.equal(g.get("name"), expression));

            TypedQuery<Group> query = session.createQuery(q);
            query.setParameter(expression, groupName);

            var result = query.getResultList();

            if (result.isEmpty())
                response = Response.ofException("No matching group with that name");
            else
                response = Response.of(result.get(0));

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
    public Response<Group> update(Group entity) {
        Session session = HibernateUtil.getSession();

        Response<Group> response;

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
    public Response<Group> delete(Group entity) {
        // TODO Auto-generated method stub
        return null;
    }

    public Response<List<Group>> readAll() {

        Response<List<Group>> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Group> cq = cb.createQuery(Group.class);
            Root<Group> rootEntry = cq.from(Group.class);
            CriteriaQuery<Group> all = cq.select(rootEntry);
            TypedQuery<Group> allQuery = session.createQuery(all);
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

    public Response<List<Group>> groupsUnderLeader(Long leaderId) {

        Response<List<Group>> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Group> q = cb.createQuery(Group.class);
            Root<Group> g = q.from(Group.class);
            ParameterExpression<Long> id = cb.parameter(Long.class);
            q.select(g).where(cb.or(cb.equal(g.get("teamLeader"), id), cb.equal(g.get("peerLeader"), id)));

            TypedQuery<Group> query = session.createQuery(q);
            query.setParameter(id, leaderId);
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
