
import java.awt.*;
import java.util.*;

public class MediaManager
{	
	
	ArrayList<Media> searchMedia(String theSearch)
	{
		ArrayList<Media> searchList = new ArrayList<Media>();
		Media n = mediaTable.get(theSearch);
		if (n != null)
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
	
	Bool requestHold(Media theMedia, Patron thePatron)
	{
		try:
		{
			theMedia.getReserved() = thePatron;
			return true;
		} catch
		{
			System.out.println ("Unable to reserve media\n");
			return false;
		}
		return true;
	}
	
	Boolean renewCheckout(Media theMedia)
	{
		try:
		{
			theMedia.dueDate += 7;
		} catch
		{
			System.out.println("Failed to renew check out\n");
			return false;
		}
		return true;
	}
	
	Boolean checkOut(Media theMedia, Patron thePatron)
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
		theMedia.getCheckedOut() = NULL;
		theMedia.getDueDate() = NULL;
	}
}
