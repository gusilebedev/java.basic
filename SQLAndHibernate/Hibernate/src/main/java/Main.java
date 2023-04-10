import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = query.from(PurchaseList.class);
        query.select(root);
        List<PurchaseList> purchaseList = session.createQuery(query).getResultList();

        CriteriaQuery<Student> query1 = builder.createQuery(Student.class);
        Root<Student> root1 = query1.from(Student.class);
        query1.select(root1);
        List<Student> studentsList = session.createQuery(query1).getResultList();

        CriteriaQuery<Course> query2 = builder.createQuery(Course.class);
        Root<Course> root2 = query2.from(Course.class);
        query2.select(root2);
        List<Course> coursesList = session.createQuery(query2).getResultList();

        Transaction transaction = session.beginTransaction();
        for (PurchaseList purchase : purchaseList) {
            LinkedPurchaseList linkedPurchase = new LinkedPurchaseList();
            for (Student student : studentsList) {
                if (purchase.getStudentName().equals(student.getName())){
                    for (Course course : coursesList) {
                        if(purchase.getCourseName().equals(course.getName())) {
                            linkedPurchase.setId(new LinkedPurchaseListKey(student.getId(), course.getId()));
                            session.save(linkedPurchase);
                        }
                    }
                }
            }
        }
        transaction.commit();
        sessionFactory.close();
        session.close();
    }
}
