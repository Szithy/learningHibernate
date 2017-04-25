package hu.szithy;

import java.util.Date;
import java.util.Map.Entry;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		Session session =  HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setName("Adam");
		user.getHistory().put("GL123",new UserHistory(new Date(), "Set name to Adam"));
		user.getProteinData().setGoal(250);
		user.getHistory().put("LG124",new UserHistory(new Date(), "Set the goal to 250"));
		session.save(user);
		
		session.getTransaction().commit();
		
		session.beginTransaction();
		
		User loadedUser = (User) session.load(User.class,9);
		System.out.println(loadedUser.getName());
		System.out.println(loadedUser.getProteinData().getGoal());
		
		for(Entry<String, UserHistory> history : loadedUser.getHistory().entrySet()){
			System.out.println("Key value: " + history.getKey());
			System.out.println(history.getValue().getEntryTime().toString() + " " + history.getValue().getEntry());
		}
		
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
		loadedUser.getHistory().put("GL125",new UserHistory(new Date(),"Added 50 protein"));
		
		session.getTransaction().commit();
		
		session.close();
		
		HibernateUtilities.getSessionFactory().close();
	}

}
