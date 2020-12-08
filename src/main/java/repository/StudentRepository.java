package repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

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
        Session session = HibernateUtil.getSession();
        Response<Student> response;

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
    public Response<Void> delete(Student entity) {
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

    public Response<List<Student>> readAll() {

        Response<List<Student>> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Student> cq = cb.createQuery(Student.class);
            Root<Student> rootEntry = cq.from(Student.class);
            CriteriaQuery<Student> all = cq.select(rootEntry);
            TypedQuery<Student> allQuery = session.createQuery(all);
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

    public Response<List<Student>> getStudentsFromGroup(Long groupId) {

        Response<List<Student>> response;

        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Student> q = cb.createQuery(Student.class);
            Root<Student> g = q.from(Student.class);
            ParameterExpression<Long> id = cb.parameter(Long.class);
            q.select(g).where(cb.equal(g.get("group"), id));

            TypedQuery<Student> query = session.createQuery(q);
            query.setParameter(id, groupId);

            var students = query.getResultList();

            // to get attendance
            for (var student : students) {
                student.getAttendace().size();
            }

            response = Response.of(students);

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
            Root<Student> student = criteria.from(Student.class);

            criteria.multiselect(student.get("college") , builder.count(student.get("id")));
            criteria.groupBy(student.get("college"));

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
