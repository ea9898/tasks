package criteriaQuery.criteriaQueryGroupByAndHaving;

import criteriaQuery.entity.Department;
import criteriaQuery.entity.Employee;
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
            Root<Employee> root = criteriaQuery.from(Employee.class);

            criteriaQuery.multiselect(builder.count(root.get("name")), builder.sum(root.get("salary")), root.get("department"));
            criteriaQuery.groupBy(root.get("department"));
            criteriaQuery.having(builder.greaterThan(builder.sum(root.get("salary")), 20000));

            Query<Object[]> query = session.createQuery(criteriaQuery);
            List<Object[]> resultList = query.getResultList();

            for (Object[] obj : resultList) {
                Department dep = (Department) obj[2];
                System.out.println(dep.getId() + "\t" + dep.getName());

                long name = (long) obj[0];
                System.out.println("Count: " + name);

                Double salary = (Double) obj[1];
                System.out.println("Salary: " + salary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
