package librarianassistant;

public class Dvd extends Media
{
		// attributes
		
	private String region;
	private int ID;
	
		// constructor
		
	public Dvd (String theTitle)
	{
		super(theTitle);
	}
	
		// operations
		
	String getRegion ()
	{
		return region;
	}
	
	void setRegion (String theRegion)
	{
		region = theRegion;
	}
	
	int getID ()
	{
		return ID;
	}
	
	void setID (int theID)
	{
		ID = theID;
	}
	
}
