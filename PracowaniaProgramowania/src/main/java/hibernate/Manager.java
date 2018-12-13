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

//            saveSomething(entityManager);
            //rozpocznij transakcje
            entityManager.getTransaction().begin();

            Employee jan = new Employee();
            jan.setFirstName("Jan");
            jan.setLastName("Biały");
            entityManager.persist(jan);
            System.out.println(jan);
            Address a = new Address("Biała","Bielice","4","5A","12345");
            jan.setAddress(a);
            entityManager.persist(jan);
            System.out.println(jan);

            System.out.println("--------------------------------------------------------------------------------------------");
//            Employee emp = new Employee();
//            emp.setFirstName("Jan");
//            emp.setLastName("Polak");
////            emp.setSalary(100);
////            emp.setPesel(100);

//            entityManager.persist(emp);
//
//            Employee employee = entityManager.find(Employee.class, emp.getId());
//
//            entityManager.remove(emp);
//
//            System.out.println("Employee " + employee.getId() + " " + employee.getFirstName() +     employee.getLastName());

            //zakoncz transakcje


            entityManager.getTransaction().commit();


            System.out.println("Done");

            entityManager.close();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }

}