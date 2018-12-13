package hibernate;

import hibernate.model.Address;
import hibernate.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


class Manager {

    public static List<Employee> getThemAll(EntityManager manager) {
        Query q =  manager.createQuery("select k from Employee k");
        return q.getResultList();
    }
    public static void generateEmployees(EntityManager entityManager) {
        Employee emp = new Employee();
            emp.setFirstName("Jan");
            emp.setLastName("Polak");

            entityManager.persist(emp);

            emp = new Employee();
            emp.setFirstName("Janek");
            emp.setLastName("Polakek");

            entityManager.persist(emp);

            emp = new Employee();
            emp.setFirstName("Jerzy");
            emp.setLastName("Polak");

            entityManager.persist(emp);

            emp = new Employee();
            emp.setFirstName("Adam");
            emp.setLastName("Polakek");

            entityManager.persist(emp);
            emp = new Employee();
            emp.setFirstName("ZJan");
            emp.setLastName("ZPolak");

            entityManager.persist(emp);
    }
    public static List<Employee> poNazwisku(EntityManager entityManager, String name) {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT c FROM Employee c WHERE c.lastName LIKE :name",Employee.class);
        return query.setParameter("name", name).getResultList();
    }

    public static void main(String[] args) {

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {
            //taka nazwa jak w persistence.xml
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            //utworz entityManagera
            entityManager = entityManagerFactory.createEntityManager();

            //rozpocznij transakcje
//            entityManager.getTransaction().begin();
//            generateEmployees(entityManager);
//            entityManager.flush();
//            entityManager.getTransaction().commit();

//            entityManager.getTransaction().begin();
//            entityManager.createQuery("select k from Employee k").getResultList().forEach(e->System.out.println(e));
//            System.out.println("--------------------------------------------------------------------------------------------");
//            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
            System.out.println("Done");

            entityManager.close();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }

}