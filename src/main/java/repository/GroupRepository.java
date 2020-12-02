package repository;

import org.hibernate.Session;

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

    @Override
    public Response<Group> update(Group entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response<Group> delete(Group entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
