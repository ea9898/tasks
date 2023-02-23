package criteriaQuery.criteriaQueryJoin;

import criteriaQuery.entity.Department;
import criteriaQuery.entity.Employee;
import org.hibernate.Session;
import util.HibernateUtil;

public class SaveDataClientTest {
    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Department department1 = new Department();
            department1.setLocation("London");
            department1.setName("IT");

            Employee employee1 = new Employee();
            employee1.setDesignation("Developer");
            employee1.setName("Ivan");
            employee1.setSalary(7000.0);
            department1.getEmployees().add(employee1);
            employee1.setDepartment(department1);

            Employee employee2 = new Employee();
            employee2.setDesignation("Developer");
            employee2.setName("Boris");
            employee2.setSalary(8000.0);
            department1.getEmployees().add(employee2);
            employee2.setDepartment(department1);

            Employee employee3 = new Employee();
            employee3.setDesignation("Developer");
            employee3.setName("Petr");
            employee3.setSalary(9000.0);
            department1.getEmployees().add(employee3);
            employee3.setDepartment(department1);

            Department department2 = new Department();
            department2.setLocation("France");
            department2.setName("Finance");

            Employee employee4 = new Employee();
            employee4.setDesignation("Buhgaleter");
            employee4.setName("Eugene");
            employee4.setSalary(10000.0);
            department2.getEmployees().add(employee4);
            employee4.setDepartment(department2);

            Employee employee5 = new Employee();
            employee5.setDesignation("Manager");
            employee5.setName("Olga");
            employee5.setSalary(11000.0);
            department2.getEmployees().add(employee5);
            employee5.setDepartment(department2);

            Employee employee6 = new Employee();
            employee6.setDesignation("Sheff");
            employee6.setName("Irina");
            employee6.setSalary(6000.0);
            department2.getEmployees().add(employee6);
            employee6.setDepartment(department2);

            session.beginTransaction();
            session.persist(department1);
            session.persist(department2);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
