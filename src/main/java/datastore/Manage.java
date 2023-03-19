package datastore;

import java.util.Scanner;

public class Manage {

	public static void main(String[] args) {
		boolean created = false;
		char option;
		Scanner userInput = new Scanner(System.in);
		
		while(true) {
			System.out.println("What would you like to do?");
			if(created == false) {	// Option C is made unavailable after it has been used
				System.out.println("C - Create database and table");
			}
			System.out.println("F - Fetch a specific order");
			System.out.println("R - Read the whole table");
			System.out.println("A - Add a new order to the table");
			System.out.println("U - Update table");
			System.out.println("N - Nuke orders");
			System.out.println("D - Delete order from table");
			System.out.println("Q - Quit");
			
			option = userInput.nextLine().trim().toUpperCase().charAt(0);
			if(option == 'Q')
				break;
			if(option == 'C') {
				if(created)
					System.out.println("Database and table already created.");
				else {
					Create.proceed();
					created = true;
				}
				continue;
			}
			if(option == 'F') {
				Fetch.proceed(userInput);
				continue;
			}
			if(option == 'R') {
				Read.proceed();
				continue;
			}
			if(option == 'U') {
				Update.proceed();
				continue;
			}
			if(option == 'D') {
				Delete.proceed(userInput);
				continue;
			}
			if(option == 'A') {
				Add.proceed(userInput);
				continue;
			}
			if(option == 'N') {
				Nuke.proceed();
				continue;
			}
		}
	}

}
