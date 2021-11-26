import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otp.hibernate.pojo.HibernateUtility;

public class Updating {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtility.getSessionFactory();

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// Reading complete Entity
		System.out.println("Simple update");

		String qryString = "update Student s set s.address='Hyderabad' where s.studentId=5";
		
		Query query = session.createQuery(qryString);
		
		int count = query.executeUpdate();
		
		System.out.println(count + " Record(s) Updated.");

		System.out.println("Updating with Query Parameters ");

		String qryString2 = "update Student s set s.address='Pune' where s.studentId=?";
		Query query2 = session.createQuery(qryString2);
		query2.setParameter(0, 3);
		int count2 = query2.executeUpdate();

		System.out.println(count2 + " Record(s) Updated.");

		System.out.println("Updating with Named Parameters");

		String qryString3 = "update Student s set s.address='Goa' where s.studentId=:sId";
		Query query3 = session.createQuery(qryString3);
		query3.setParameter("sId", 6);
		int count3 = query3.executeUpdate();

		System.out.println(count3 + " Record(s) Updated.");

		transaction.commit();
		session.clear();
		session.close();
		System.out.println("Transaction Completed !");

	}

}
