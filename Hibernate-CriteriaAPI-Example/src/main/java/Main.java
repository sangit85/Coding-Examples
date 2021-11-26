import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.otp.hibernate.pojo.Employee;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder
				.build());

		Session session = factory.openSession();

		System.out.println("Reading Complete Entity");

		Criteria crit = session.createCriteria(Employee.class);
		List list = crit.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Employee emp = (Employee) it.next();
			System.out.println("Employee : " + emp.toString());

		}

		System.out.println("Reading Complete Entity with Condition");

		Criteria crit2 = session.createCriteria(Employee.class);

		Criterion criterion = Restrictions.eq("departmentId", 101);

		crit2.add(criterion);

		List list2 = crit2.list();

		Iterator it2 = list2.iterator();

		while (it2.hasNext()) {
			Employee emp = (Employee) it2.next();
			System.out.println("Employee : " + emp.toString());
		}

		System.out.println("Reading Partial Entity");

		Criteria crit3 = session.createCriteria(Employee.class);
		Projection projection = Projections.property("salary");
		Projection projection2 = Projections.property("departmentId");
		Projection projection3 = Projections.property("employeeName");

		ProjectionList pList = Projections.projectionList();
		pList.add(projection);
		pList.add(projection2);
		pList.add(projection3);
		crit3.setProjection(pList);

		List list3 = crit3.list();

		Iterator it3 = list3.iterator();

		while (it3.hasNext()) {
			Object[] obj = (Object[]) it3.next();
			System.out.println("Salary : " + obj[0] + " DeptId : " + obj[1]
					+ " empName : " + obj[2]);
		}

		System.out.println("Projection Methods");

		Criteria crit4 = session.createCriteria(Employee.class);
		Projection projection4 = Projections.avg("salary");

		crit4.setProjection(projection4);

		List list4 = crit4.list();

		Iterator it4 = list4.iterator();

		while (it4.hasNext()) {
			Double salSum = (Double) it4.next();
			System.out.println("Salary sum : " + salSum);
		}

		System.out.println("Restrictions with Projections ");

		Criteria crit5 = session.createCriteria(Employee.class);

		Criterion criterion5 = Restrictions.eq("departmentId", 101);
		Projection projection5 = Projections.property("salary");

		crit5.setProjection(projection5);
		crit5.add(criterion5);

		List list5 = crit5.list();

		Iterator it5 = list5.iterator();

		while (it5.hasNext()) {
			Integer sal = (Integer) it5.next();
			System.out.println("Salary : " + sal);
		}

		
	}

}
