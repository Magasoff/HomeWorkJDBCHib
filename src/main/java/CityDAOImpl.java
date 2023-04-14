import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO {

    @Override
    public City add(City city) {
        int id;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            id = (Integer) session.save(city);
            transaction.commit();
        }
        return city;
    }

    @Override
    public City getById(int id) {
        return null;
    }

    @Override
    public List<City> allGetAllCity() {
        return null;
    }

    @Override
    public City getBuyId(int Id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(City.class, Id);
        }
    }

    @Override
    public List<City> getAllCity() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM City").list();
        }
    }

    @Override
    public City updateCity(City city) {
        City updated;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            updated = (City) session.merge(city);
            transaction.commit();
        }
        return updated;
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            session.delete(city);
            transaction.commit();
        }
    }
}