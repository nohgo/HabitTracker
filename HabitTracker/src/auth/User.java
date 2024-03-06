package auth;

import java.io.Serializable;
import java.util.ArrayList;
import habits.*;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private ArrayList<Habit> habits;
	public User(String username, String password) {
		setHabits(new ArrayList<Habit>());
		setUsername(username);
		setPassword(password);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (! (o instanceof User))
			return false;
		
		User c = (User) o;
		return c.getUsername().equals(this.getUsername()) &&
				c.getPassword().equals(this.getPassword());
	}
	@Override
	public int hashCode() {
		return this.getUsername().hashCode() + this.getPassword().hashCode();
	}
	public void addHabit(String title, String description, int freq) {
		habits.add(new Habit(title, description, freq));
	}
	private String getUsername() {
		return username;
	}
	private void setUsername(String username) {
		this.username = username;
	}
	private String getPassword() {
		return password;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Habit> getHabits() {
		return habits;
	}
	private void setHabits(ArrayList<Habit> habits) {
		this.habits = habits;
	}
	
}
