import java.awt.*;
import java.util.*;

public class mediaTest {

	public static void main(String[] args) {
		boolean success = true;
		
		//Constructors
		Media media1 = new Media("Great Media Title");
		Book book1 = new Book("Good Book Title");
		Dvd dvd1 = new Dvd("Fair Dvd Title");
		
		if(media1 == null || book1 == null || dvd1 == null){
			success = false;
		}
		
		//Getters and Setters
		if(!media1.getTitle().equals("Great Media Title"))
				success = false;
		if(!book1.getTitle().equals("Good Book Title"))
			success = false;
		if(!dvd1.getTitle().equals("Fair Dvd Title"))
			success = false;
		
		// Media
		media1.setAuthor("Bob");
		media1.setCheckedOut(new Patron("Bob"));
		media1.setDescription("Great Book");
		media1.setDueDate(new Date());
		media1.setGenre("Good");
		media1.setLanguage("English");
		media1.setLocation("Here");
		media1.setPublisher("WSU");
		media1.setReserved(new Patron("Bob"));
		media1.setSubject("CPTS");
		
		if(!media1.getAuthor().equals("Bob"))
			success = false;
		if(!(media1.getCheckedOut() == new Patron("Bob")))
			success = false;
		if(!(media1.getDescription().equals("Great Book")))
			success = false;
		if(!(media1.getDueDate() == new Date()))
			success = false;
		if(!(media1.getGenre().equals("Good")))
			success = false;
		if(!(media1.getLanguage().equals("English")))
			success = false;
		if(!(media1.getLocation().equals("Here")))
			success = false;
		if(!(media1.getPublisher().equals("WSU")))
			success = false;
		if(!(media1.getReserved() == new Patron("Bob")))
			success = false;
		if(!(media1.getSubject().equals("CPTS")))
			success = false;
		
		//Book 
		book1.setAuthor("Bob");
		book1.setCheckedOut(new Patron("Bob"));
		book1.setDescription("Great Book");
		book1.setDueDate(new Date());
		book1.setGenre("Good");
		book1.setLanguage("English");
		book1.setLocation("Here");
		book1.setPublisher("WSU");
		book1.setReserved(new Patron("Bob"));
		book1.setSubject("CPTS");
		book1.setEdition("1st");
		book1.setISBN(54);
		
		if(!book1.getAuthor().equals("Bob"))
			success = false;
		if(!(book1.getCheckedOut() == new Patron("Bob")))
			success = false;
		if(!(book1.getDescription().equals("Great Book")))
			success = false;
		if(!(book1.getDueDate() == new Date()))
			success = false;
		if(!(book1.getGenre().equals("Good")))
			success = false;
		if(!(book1.getLanguage().equals("English")))
			success = false;
		if(!(book1.getLocation().equals("Here")))
			success = false;
		if(!(book1.getPublisher().equals("WSU")))
			success = false;
		if(!(book1.getReserved() == new Patron("Bob")))
			success = false;
		if(!(book1.getSubject().equals("CPTS")))
			success = false;
		if(!(dvd1.getEdition().equals("1st")))
			success = false;
		if(!(dvd1.getISBN() == 54))
			success = false;
		
		
		//Dvd
		dvd1.setAuthor("Bob");
		dvd1.setCheckedOut(new Patron("Bob"));
		dvd1.setDescription("Great Book");
		dvd1.setDueDate(new Date());
		dvd1.setGenre("Good");
		dvd1.setLanguage("English");
		dvd1.setLocation("Here");
		dvd1.setPublisher("WSU");
		dvd1.setReserved(new Patron("Bob"));
		dvd1.setSubject("CPTS");
		dvd1.setRegion("America");
		dvd1.setID(5);
		
		if(!dvd1.getAuthor().equals("Bob"))
			success = false;
		if(!(dvd1.getCheckedOut() == new Patron("Bob")))
			success = false;
		if(!(dvd1.getDescription().equals("Great Book")))
			success = false;
		if(!(dvd1.getDueDate() == new Date()))
			success = false;
		if(!(dvd1.getGenre().equals("Good")))
			success = false;
		if(!(dvd1.getLanguage().equals("English")))
			success = false;
		if(!(dvd1.getLocation().equals("Here")))
			success = false;
		if(!(dvd1.getPublisher().equals("WSU")))
			success = false;
		if(!(dvd1.getReserved() == new Patron("Bob")))
			success = false;
		if(!(dvd1.getSubject().equals("CPTS")))
			success = false;
		if(!(dvd1.getRegion().equals("America")))
			success = false;
		if(!(dvd1.getID() == 5))
			success = false;
		
		//Inheritance
		Media mediaBook = new Book("Test1");
		Media mediaDvd = new Dvd("Test2");
		Media mediaMedia = new Media("Test3");
		
		if(mediaBook != new Book("Test1"))
			success = false;
		if(mediaDvd != new Dvd("Test2"))
			success = false;
		if(mediaMedia != new Media("Test3"))
			success = false;
		
		if(success){
			System.out.print("Media Testing Succesful");
		}else{
			System.out.print("Media Testing Failed");
		}
	}

}
