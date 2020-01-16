package librarianassistant;

import java.util.*;
import java.util.Scanner;

public class LibrarianAssistant 
{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		
			// Test this thing
		
		libDatabase maindatabase = new libDatabase();
		MediaManager myMediaManager = new MediaManager(); 
		
			// create a blank patron 
		
		Patron blankPatron = new Patron(000000);
		blankPatron.setName("Available");
		blankPatron.setEmail("libs@WSU.edu");
		blankPatron.setPassword("APassword");
		blankPatron.setUserLevel(1);
		
			// create a user
		
		Patron tempPatron = new Patron(112233);
		tempPatron.setName("Bob Smith");
		tempPatron.setEmail("Bob.Smith@WSU.edu");
		tempPatron.setPassword("YesyesPassword");
		tempPatron.setUserLevel(1);
		
			// add our users to our profiles:
		
		maindatabase.profiles.put(000000, blankPatron);
		maindatabase.profiles.put(112233, tempPatron);
		
		
		Date blankDate = new Date(00,01,01);
		
			// test Data: add some books to our mediaTable for testing:
		
		maindatabase.mediaTable.put("Dynamic Scoping for fun and profit", new Book ("Dynamic Scoping for fun and profit", "Computer Science", "Dynamic Scoping",
				"Arthur Lockley", "New Press", "Swahili", "Computer Science", blankPatron, blankPatron, "L1-M3-B12", blankDate, "First", 1234567890));
		
		maindatabase.mediaTable.put("Algorithm Analysis", new Book ("Algorithm Analysis", "Computer Science", "Algorithm Analysis",
				"Scott Dobbs", "Old Press", "German", "Computer Science", blankPatron, blankPatron, "L3-M2-BD12", blankDate, "Ninth", 1243658709));
		
		maindatabase.mediaTable.put("Data Structures of recombinant DNA modelling", new Book ("Data Structures of recombinant DNA modelling", "Computer Science", "Data Structures",
				"Frank Wright", "Im Press", "Australian", "Computer Science", blankPatron, blankPatron, "D12-L3-M2", blankDate, "Fourth", 2078563412));
		
	
			// prompt for a book:
		System.out.println("Book: ");
		Scanner scanner = new Scanner(System.in);
		String searchBook = scanner.nextLine();
		
		
			// Prompt user for a book, get its record from the mediaTable:
		
		Book newBook = new Book();
		
		if (maindatabase.mediaTable.get(searchBook) != null)
		{
			newBook = (Book) maindatabase.mediaTable.get(searchBook);
		} // end if book exists
		else
		{
			System.out.println("Book not found\n");
		} // end book not found
		
		System.out.println ("I found: " + newBook.getTitle() );

			// we need to get a patron to associate it with, this is as if we swiped our Cougar card:
		
		System.out.println("Patron: ");
		int searchPatron = scanner.nextInt();
		scanner.close();
		
		Patron newPatron = new Patron();
		
		if (maindatabase.profiles.get(searchPatron) != null)
		{
			newPatron = maindatabase.profiles.get(searchPatron);
		}
		else 
		{
			System.out.println("Patron not found\n");
		}
			
			// and add this book to their list of checked out books in their mediaList
		
		System.out.println("MediaList before : " + maindatabase.profiles.get(newPatron.getIDNumber()).getName() + "   :   " 
				+ maindatabase.profiles.get(newPatron.getIDNumber()).getMediaList());
		System.out.println("mediaTable before: " + maindatabase.mediaTable.get("Dynamic Scoping for fun and profit").getCheckedOut().getName());
		
		myMediaManager.checkOut(maindatabase.mediaTable, newBook, maindatabase.profiles, newPatron);
		//newPatron.getMediaList().add(newBook);
		
			// test checkout:
		System.out.println("MediaList after : " + maindatabase.profiles.get(newPatron.getIDNumber()).getName() + "   :   " 
			+ maindatabase.profiles.get(newPatron.getIDNumber()).getMediaList().get(0).getTitle());
		System.out.println("mediaTable after: " + maindatabase.mediaTable.get("Dynamic Scoping for fun and profit").getCheckedOut().getName());
	}

}
