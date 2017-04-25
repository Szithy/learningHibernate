package hu.szithy;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		Session session =  HibernateUtilities.getSessionFactory().openSession();
		session.close();
	}

}
