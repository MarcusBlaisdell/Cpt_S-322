import java.applet.*;
import java.awt.*;

public class mediaManager
{	
	
	ArrayList<Media> searchMedia(String theSearch)
	{
		ArrayList<Media> searchList = new ArrayList<Media>();
		Media n = mediaTable.get(theSearch);
		if n != null
		{
			searchList.add(n);
		}
		
		return searchList;
	}
	
	Media getMedia (String theMedia)
	{
		return mediaTable.get(theMedia);
	}
	
	void addMedia(Media mediaData)
	{
		mediaTable.put(mediaData);
	}
	
	void removeMedia(String mediaData)
	{
		mediaTable.remove(mediaData);
	}
	
	Bool requestHold(Media theMedia, patron thePatron)
	{
		try:
		{
			theMedia.reserved = thePatron;
			return true;
		} catch
		{
			System.out.println ("Unable to reserve media\n");
			return false;
		}
		return true;
	}
	
	Bool renewCheckout(Media theMedia)
	{
		try:
		{
			Media.dueDate += 7;
		} catch
		{
			System.out.println("Failed to renew check out\n");
			return false;
		}
		return true;
	}
	
	Bool checkOut(Media theMedia, Patron thePatron)
	{
		try:
		{
			theMedia.checkedOut = thePatron;
		} catch
		{
			return false;
			System.out.println("Unable to check out media\n");
		}
		return true;
	}
	
	void checkIn(Media theMedia)
	{
		theMedia.checkedOut = NULL;
		theMedia.dueDate = NULL;
	}
}
