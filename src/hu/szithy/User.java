package hu.szithy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	
	private int id;
	private String name;

	private ProteinData proteinData = new ProteinData();
	
	private Map<String, UserHistory> history = new HashMap<String, UserHistory>();
	
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
	public Map<String, UserHistory> getHistory() {
		return history;
	}
	public void setHistory(Map<String, UserHistory> history) {
		this.history = history;
	}
	
}
