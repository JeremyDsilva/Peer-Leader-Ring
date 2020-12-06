package repository;

import org.hibernate.Session;

import entity.ActivityAttendance;
import entity.ActivityAttendancePK;
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
    public Response<ActivityAttendance> delete(ActivityAttendance entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
