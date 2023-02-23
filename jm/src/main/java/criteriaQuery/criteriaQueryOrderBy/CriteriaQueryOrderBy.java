package criteriaQuery.criteriaQueryOrderBy;

import criteriaQuery.entity.Department;
import criteriaQuery.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class CriteriaQueryOrderBy {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
            Root<Employee> root = criteriaQuery.from(Employee.class);

            criteriaQuery.select(root);
            criteriaQuery.orderBy(builder.desc(root.get("salary")));
            Query<Employee> query = session.createQuery(criteriaQuery);
            List<Employee> resultList = query.getResultList();

            for (Employee emp : resultList) {
                System.out.println(emp.getName() + " " + emp.getSalary());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
