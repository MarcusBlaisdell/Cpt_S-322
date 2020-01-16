import java.applet.*;
import java.awt.*;

public class patronManager
{
	Patron getUser(int theID)
	{
		return profiles.get(theID);
	}
	
	void setuser(int theID, String theName, String theEmail, String thePassword, ArrayList<Media> theMediaList, int theUserLevel)
	{
		profiles.get(theID).IDNumber = theID;
		profiles.get(theID).Name = theName;
		profiles.get(theID).Email = theEmail;
		profiles.get(theID).password = thePassword;
		profiles.get(theID).mediaList = theMediaList;
		profiles.get(theID).userLevel = theUserLevel;
	}
	
	Bool deleteUser (Patron thePatron)
	{
		try:
		{
			profiles.remove (thePatron);
		} catch
		{
			System.out.println ("Unable to remove User \n");
			return false;
		}
		return true;
	}
	
	Bool addUser(Patron thePatron)
	{
		try:
		{
			profiles.put (thePatron);
		} catch
		{
			System.out.println ("Unable to add user \n");
			return false;
		}
		return true;
	}
	
}
