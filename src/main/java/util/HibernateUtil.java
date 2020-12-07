package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory factory;
    private static ServiceRegistry registry;

    static {
        Configuration conf = new Configuration().addAnnotatedClass(entity.Activity.class)
                .addAnnotatedClass(entity.ActivityAttendance.class)
                .addAnnotatedClass(entity.ActivityAttendancePK.class)
                .addAnnotatedClass(entity.Group.class)
                .addAnnotatedClass(entity.Student.class)
                .addAnnotatedClass(entity.StudentLeader.class)
                .addAnnotatedClass(entity.User.class).configure();
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        factory = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

    public static Session getSession() {
        return factory.openSession();
    }

    public static void close() {
        factory.close();
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
