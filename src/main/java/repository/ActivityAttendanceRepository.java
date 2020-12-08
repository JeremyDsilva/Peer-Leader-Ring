package repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import entity.ActivityAttendance;
import entity.ActivityAttendancePK;
import entity.Group;
import response.Response;
import util.HibernateUtil;

public class ActivityAttendanceRepository implements Repository<ActivityAttendance, ActivityAttendancePK> {

    @Override
    public Response<ActivityAttendancePK> create(ActivityAttendance entity) {

        Response<ActivityAttendancePK> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            response = Response.of((ActivityAttendancePK) session.save(entity));
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
    public Response<ActivityAttendance> read(ActivityAttendancePK id) {

        Response<ActivityAttendance> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            response = Response.of(session.find(ActivityAttendance.class, id));
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
    public Response<ActivityAttendance> update(ActivityAttendance entity) {
        Session session = HibernateUtil.getSession();
        Response<ActivityAttendance> response;

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
    public Response<Void> delete(ActivityAttendance entity) {

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

    public Response<Long> count() {

        Response<Long> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
            Root<ActivityAttendance> leader = criteria.from(ActivityAttendance.class);

            criteria.select(builder.count(leader));

            TypedQuery<Long> query = session.createQuery(criteria);

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




}
