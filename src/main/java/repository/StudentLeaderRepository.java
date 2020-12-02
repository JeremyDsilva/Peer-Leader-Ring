package repository;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response<StudentLeader> delete(StudentLeader entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
