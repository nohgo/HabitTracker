package auth;
import java.io.Serializable;
import java.util.ArrayList;

public class UserAuthenticator implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<User> users;
	public UserAuthenticator() {
		users = new ArrayList<User>();
	}
	public void addUser(String username, String password) {
		users.add( new User(username, password) );
	}
	public User login(String username, String password) {
		for (User user : users)
			if (user.equals(new User(username, password)))
				return user;
		return null;
	}
	public boolean hasUsers() {
		return users.size() != 0;
	}
}
