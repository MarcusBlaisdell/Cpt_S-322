
public class Book extends Media
{
		// attributes
	private String edition;
	private int isbn;
	
		// constructor
	public Book (String theTitle)
	{
		super(theTitle);
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
