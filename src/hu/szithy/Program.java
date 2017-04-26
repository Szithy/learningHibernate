package hu.szithy;

import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		Session session =  HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setName("Adam");
		user.addHistory(new UserHistory(new Date(), "Set name to Adam"));
		user.getProteinData().setGoal(250);
		user.addHistory(new UserHistory(new Date(), "Set the goal to 250"));
		
		user.getGoalAlerts().add(new GoalAlert("Congrats!"));
		user.getGoalAlerts().add(new GoalAlert("You did it!"));
		
		session.save(user);
		
		session.getTransaction().commit();
		
		session.beginTransaction();
		
		User loadedUser = (User) session.load(User.class,1);
		System.out.println(loadedUser.getName());
		System.out.println(loadedUser.getProteinData().getGoal());
		
		for(UserHistory history : loadedUser.getHistory()){
			System.out.println(history.getEntryTime().toString() + " " + history.getEntry());
		}
		
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
		loadedUser.addHistory(new UserHistory(new Date(),"Added 50 protein"));
		
		user.setProteinData(new ProteinData());
		
		session.getTransaction().commit();
		
		session.close();
		
		HibernateUtilities.getSessionFactory().close();
	}

}
