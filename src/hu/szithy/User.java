package hu.szithy;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private int id;
	private String name;

	private ProteinData proteinData = new ProteinData();
	
	private Set<UserHistory> history = new HashSet<UserHistory>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProteinData getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}
	public Set<UserHistory> getHistory() {
		return history;
	}
	public void setHistory(Set<UserHistory> history) {
		this.history = history;
	}
	
}
