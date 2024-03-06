package application;

import java.util.Scanner;
import auth.*;
import habits.*;
import util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		UserAuthenticator master = new UserAuthenticator();
		
		try {master = Loader.loadFile();}
		catch(Exception e) {}
		
		if (!master.hasUsers()) {
			addUser(input, master);
			System.out.println();
		}
		else {
			System.out.print("Would you like to create an account? (Y or N): ");
			if (input.next().charAt(0) == 'Y')
			addUser(input, master);
		}
		
		User user;
		while(true) {
			System.out.print("Please enter your username and password, separated by spaces: ");
			user = master.login(input.next(), input.next());
			if (user != null) break;
			input.nextLine();
		}
		input.nextLine();
		Scanner scanner = new Scanner(System.in);
		String strUserInput = null;
		int intUserInput = 0;
		System.out.println();
		do {
			//CONSTRUCTOR VARIABLES
			String title;
			String description;
			int frequency;
			
			System.out.println("Enter your choice: ");
			System.out.println("1. Add habit");
			System.out.println("2. Increment habit");
			System.out.println("3. List all habits");
			System.out.println("4. Exit");
			System.out.println();
			strUserInput = scanner.nextLine();
			intUserInput = Integer.parseInt(strUserInput);
			switch (intUserInput) {
			case 1:
				System.out.print("Enter the title: ");
				title = input.nextLine();
				System.out.print("Enter the description: ");
				description = input.nextLine();
				
				while (true) {
					System.out.print("Enter the frequency in days: ");
					frequency = Integer.parseInt(input.nextLine());
					if (frequency >= 1) break;
				}
				
				user.addHabit(title, description, frequency);
				System.out.println();
				break;
			case 2:
				for (int i = 0; i < user.getHabits().size(); i++) {
					System.out.println((i+1) + ". " + user.getHabits().get(i));
					System.out.println();
				}
				System.out.print("Which habit do you want to increment? (Enter num): ");
				int habitIndex = Integer.parseInt(input.nextLine()) - 1;
				if (habitIndex < 0 || habitIndex > user.getHabits().size()) {
					System.out.println("Invalid number");
				}
				else {
					System.out.println(user.getHabits().get(habitIndex).increment() ? "Success! ": "Too soon! ");
					System.out.println();
				}
				break;
			case 3:
				System.out.println();
				for (Habit habit : user.getHabits()) {
					System.out.println(habit + "\n");
				}
				break;
			case 4:
				System.out.println("Thank you for using the habit tracker");
				Saver.saveClass(master);
				input.close();
				scanner.close();
				break;
			default:
				System.out.println("Invalid menu option entered. Try again.");
			}
		} while (intUserInput != 4);
		
	}
	public static void addUser(Scanner input, UserAuthenticator master) {
		System.out.print("Please enter a username and password for your account, separated by spaces: ");
		master.addUser(input.next(), input.next());
		input.nextLine();
	}
}
