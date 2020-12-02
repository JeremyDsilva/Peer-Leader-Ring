package repository;

import org.hibernate.Session;

import entity.Student;
import response.Response;
import util.HibernateUtil;

public class StudentRepository implements Repository<Student, Long> {

    @Override
    public Response<Long> create(Student entity) {

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
    public Response<Student> read(Long id) {

        Response<Student> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            response = Response.of(session.find(Student.class, id));
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
    public Response<Student> update(Student entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response<Student> delete(Student entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
