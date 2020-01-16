package librarianassistant;

import java.util.Date;

public class Book extends Media
{
		// attributes
	private String edition;
	private int isbn;
	
		// constructors
	
	public Book ()
	{
	}
	
	public Book (String theTitle)
	{
		super(theTitle);
	}
	
	public Book (String theTitle, String theGenre, String theDescription, String theAuthor, String thePublisher, String theLanguage, String theSubject, 
			Patron theReserved, Patron theCheckedOut, String theLocation, Date theDueDate, String theEdition, Integer theISBN)
	{
		super (theTitle, theGenre, theDescription, theAuthor, thePublisher, theLanguage, theSubject, 
				theReserved, theCheckedOut, theLocation, theDueDate);
		edition = theEdition;
		isbn = theISBN;
	}
	
		// operations
	
	String getEdition ()
	{
		return edition;
	}
	
	void setEdition (String theEdition)
	{
		edition = theEdition;
	}
	
	int getIsbn ()
	{
		return isbn;
	}
	
	void setIsbn (int theIsbn)
	{
		isbn = theIsbn;
	}
}
