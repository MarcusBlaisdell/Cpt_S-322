package librarianassistant;

import java.util.*;

public class PatronManager
{
	Patron getUser(Hashtable<Integer, Patron> theProfiles, int theID)
	{
		return theProfiles.get(theID);
	}
	
	void setuser(Patron theProfile, int theID, String theName, String theEmail, String thePassword, ArrayList<Media> theMediaList, int theUserLevel)
	{
		theProfile.setIDNumber(theID);
		theProfile.setName(theName);
		theProfile.setEmail(theEmail);
		theProfile.setPassword(thePassword);
		theProfile.setUserLevel(theUserLevel);
		theProfile.setMediaList(theMediaList);
	}
	
	Boolean deleteUser (Hashtable<Integer, Patron> theProfiles, Patron thePatron)
	{
		try
		{
			theProfiles.remove (thePatron);
		} catch (IndexOutOfBoundsException e) 
		{
		    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		    return false;
		} 
		
		return true;
	}
	
	Boolean addUser(Hashtable<Integer, Patron> theProfiles, Patron thePatron)
	{
		try
		{
			theProfiles.put (thePatron.getIDNumber(), thePatron);
		} catch (IndexOutOfBoundsException e) 
		{
		    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		    return false;
		} 
		
		return true;
	}
	
}
