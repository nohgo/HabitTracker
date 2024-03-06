package habits;

import java.io.Serializable;

class IncrementTimer implements Serializable{
	private static final long serialVersionUID = 1L;
	private long lastIncremented;
	
	IncrementTimer() {
		lastIncremented = 0;
	}
	boolean isIncrementable(int frequency) {
		return (System.currentTimeMillis() - lastIncremented) / 86400000 >= frequency;
	}
	void increment() {
		lastIncremented = System.currentTimeMillis();
	}
}
