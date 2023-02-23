package criteria.criteriaQueryJoin.client;

import criteria.criteriaQueryJoin.entity.Department;
import criteria.criteriaQueryJoin.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class CriteriaQueryJoinClientTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
            Root<Employee> rootEmployee = criteriaQuery.from(Employee.class);
            Root<Department> rootDepartment = criteriaQuery.from(Department.class);

            criteriaQuery.multiselect(rootEmployee, rootDepartment);
            criteriaQuery.where(builder.equal(rootEmployee.get("department"), rootDepartment.get("id")));

            Query<Object[]> query = session.createQuery(criteriaQuery);
            List<Object[]> resultList = query.getResultList();

            for (Object[] obj : resultList) {
                Employee employee = (Employee) obj[0];
                System.out.println(employee.getId() + "\t" + employee.getName());
                Department department = (Department) obj[1];
                System.out.println(department.getId() + "\t" + department.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
