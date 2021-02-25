package Employee_IN_LAB.Employee_Task;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Order;

public class EmployeeDAO {

public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = (Transaction) session.beginTransaction();
		
		//HQL
//		Random r = new Random();
//		for(int i=1;i<10;i++) {
//			Employee_pojo emp = new Employee_pojo();
//			emp.setEmpno(i);
//			emp.setEmpname("name"+i);
//			emp.setAge(r.nextInt(100));
//			session.save(emp);
//		}
//		Query q = session.createQuery("select age,empname from Employee_pojo where empno > 3");
//		Query q = session.createQuery("update Employee_pojo set empname=:name where empno=:no");
//		q.setParameter("name", "Chaitanya");
//		q.setParameter("no", 3);
//		q.executeUpdate();
//		List<Object[]> e = q.list();
//		for(Object[] p:e) {
//		System.out.println(p[0]+" "+p[1]);
//		}
//		for(String e:list) {
//			System.out.println(e);
//		}
//		System.out.println(list);
		
		//HCQL
		Criteria c = session.createCriteria(Employee_pojo.class);
//		c.add(Restrictions.gt("age", 20));
		c.addOrder(Order.asc("age"));
		List l = c.list();
		System.out.println(l);
		
		t.commit();
		System.out.println("Insertion Successfull");
		factory.close();
		session.close();
		
	}
}
