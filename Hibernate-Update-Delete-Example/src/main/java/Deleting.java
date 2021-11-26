import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otp.hibernate.pojo.HibernateUtility;


public class Deleting {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtility.getSessionFactory();

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// Reading complete Entity
		System.out.println("Simple Delete");

		String qryString = "delete from Student s where s.studentId=1";
		
		Query query = session.createQuery(qryString);
		
		int count = query.executeUpdate();
		
		System.out.println(count + " Record(s) Updated.");

		System.out.println("Deleting with Query Parameters ");

		String qryString2 = "delete from Student s where s.studentId=?";
		
		Query query2 = session.createQuery(qryString2);
		
		query2.setParameter(0, 2);
		int count2 = query2.executeUpdate();

		System.out.println(count2 + " Record(s) Updated.");

		System.out.println("Deleting with Named Parameters");

		String qryString3 = "delete from Student s where s.studentId=:sId";
		Query query3 = session.createQuery(qryString3);
		query3.setParameter("sId", 4);
		int count3 = query3.executeUpdate();

		System.out.println(count3 + " Record(s) Updated.");

		transaction.commit();
		session.clear();
		session.close();
		System.out.println("Transaction Completed !");

	}

}
