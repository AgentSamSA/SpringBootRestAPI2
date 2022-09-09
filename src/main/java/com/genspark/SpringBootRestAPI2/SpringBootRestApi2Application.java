package com.genspark.SpringBootRestAPI2;

import com.genspark.SpringBootRestAPI2.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class SpringBootRestApi2Application {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee1 = new Employee();
		employee1.setEmployeeId(1);
		employee1.setEmployeeName("Samuel");
		employee1.setEmployeeDepartment("IT Department");
		session.save(employee1);

		Employee employee2 = new Employee();
		employee2.setEmployeeId(2);
		employee2.setEmployeeName("Jonny");
		employee2.setEmployeeDepartment("Medical");
		session.save(employee2);

		Employee employee3 = new Employee();
		employee3.setEmployeeId(3);
		employee3.setEmployeeName("James Neutron");
		employee3.setEmployeeDepartment("Research");
		session.save(employee3);

//		Query query = session.createQuery("from Employee where employeeDepartment=:dept");
//		query.setParameter("dept", "Medical");
//		List<Employee> employeeList = query.list();
//
//		for (Employee emp: employeeList) {
//			System.out.println(emp);
//		}

//		Query q = session.createQuery("update Employee set employeeName=:name where employeeId=:i");
//		q.setParameter("name", "Jimmy Neutron");
//		q.setParameter("i", 1);
//		int status = q.executeUpdate();
//		System.out.println(status);

		transaction.commit();
		System.out.println("Successfully updated.");
		factory.close();
		session.close();
	}

}
