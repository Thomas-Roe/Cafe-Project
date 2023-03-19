package datastore;

import java.util.Scanner;

public class Manage {

	public static void main(String[] args) {
		boolean created = false;
		char option;
		Scanner userInput = new Scanner(System.in);
		String orderID = userInput.nextLine();
		userInput.close();
		
		while(true) {
			System.out.println("What would you like to do?\n\n");
			if(created == false) {	// Option C is made unavailable after it has been used
				System.out.println("C - Create database and table\n");
			}
			System.out.println("F - Fetch a specific order\n");
			System.out.println("R - Read the whole table\n");
			System.out.println("A - Add a new order to the table\n");
			System.out.println("U - Update table\n");
			System.out.println("D - Delete order from table\n\n");
			System.out.println("Q - Quit\n\n");
			
			option = userInput.nextLine().trim().toUpperCase().charAt(0);
			var id = orderID;
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
			if(option == 'F' && id != null) {
				Fetch.proceed(id);
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
				Delete.proceed();
				continue;
			}
		}
	}

}
