import java.applet.*;
import java.awt.*;
import java.util.*;
import Patron;

public class Media
{
		// attributes
		
	private String title;
	private String genre;
	private String description;
	private String author;
	private String publisher;
	private String language;
	private String subject;
	private Patron reserved;
	private Patron checkedOut;
	private String location;
	private Date dueDate;
	
		// Contructor
		
	public Media (String theTitle)
	{
		title = theTitle;
	}
	
		// operations
	
	String getTitle ()
	{
		return title;
	}
	
	void setTitle (String theTitle)
	{
		title = theTitle;
	}
	
	String getGenre ()
	{
		return genre;
	}
	
	void setGenre (String theGenre)
	{
		genre = theGenre;
	}
	
	String getDescription ()
	{
		return description;
	}
	
	void setDescription (String theDescription)
	{
		description = theDescription;
	}
	
	String getAuthor ()
	{
		return author;
	}
	
	void setAuthor (String theAuthor)
	{
		author = theAuthor;
	}
	
	String getPublisher ()
	{
		return publisher;
	}
	
	void setPublisher (String thePublisher)
	{
		publisher = thePublisher;
	}
	
	String getLanguage ()
	{
		return language;
	}
	
	void setLanguage (String theLanguage)
	{
		language = theLanguage;
	}
	
	String getSubject ()
	{
		return subject;
	}
	
	void setSubject (String theSubject)
	{
		subject = theSubject;
	}
	
	Patron getReserved ()
	{
		return reserved;
	}
	
	void setReserved (Patron theReserved)
	{
		reserved = theReserved;
	}
	
	Patron getCheckedOut ()
	{
		return checkedOut;
	}
	
	void setCheckedOut (Patron theCheckedOut)
	{
		checkedOut = theCheckedOut;
	}
	
	String getLocation ()
	{
		return location;
	}
	
	void setLocation (String theLocation)
	{
		location = theLocation;
	}
	
	Date getDueDate ()
	{
		return dueDate;
	}
	
	void setDueDate (Date theDueDate)
	{
		dueDate = theDueDate
	}
	
}
