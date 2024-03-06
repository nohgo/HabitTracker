package habits;

import java.io.Serializable;

public class Habit implements Serializable{
	private static final long serialVersionUID = 1L;
	private String title;
	private String description;
	private int streak;
	private int frequency; // 1 = day, 7 = week, 31 = month, 356 = year;
	private IncrementTimer incrementer;
	
	public Habit(String title, String description, int frequency) {
		setTitle(title);
		setDescription(description);
		setStreak(0);
		setFrequency(frequency);
		setIncrementer(new IncrementTimer());
	}

	public boolean increment() {
		if (incrementer.isIncrementable(getFrequency())) {
			setStreak(getStreak() + 1);
			incrementer.increment();
			return true;
			}
		return false;
	}
	@Override
	public String toString() {
		return "Title: " + getTitle() +
				"\nDescription: " + getDescription() +
				"\nStreak: " + getStreak() +
				"\nFrequency: " + getFrequency();
	}
	private String getTitle() {
		return title;
	}
	private void setTitle(String title) {
		this.title = title;
	}
	private String getDescription() {
		return description;
	}
	private void setDescription(String description) {
		this.description = description;
	}
	private int getStreak() {
		return streak;
	}
	private void setStreak(int streak) {
		this.streak = streak;
	}
	private int getFrequency() {
		return frequency;
	}
	private void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	private void setIncrementer(IncrementTimer incrementer) {
		this.incrementer = incrementer;
	}
	
	
}
