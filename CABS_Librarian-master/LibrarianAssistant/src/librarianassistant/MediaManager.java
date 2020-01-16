package librarianassistant;

import java.awt.*;
import java.util.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MediaManager
{	
	
	Media getMedia (Hashtable<String, Media> theMediaTable, String theMedia)
	{
		return theMediaTable.get(theMedia);
	}
	
	void addMedia(Hashtable<String, Media> theMediaTable, Media mediaData)
	{
		theMediaTable.put(mediaData.getTitle(), mediaData);
	}
	
	void removeMedia(Hashtable<String, Media> theMediaTable, String mediaData)
	{
		theMediaTable.remove(mediaData);
	}
	
	Boolean requestHold(Media theMedia, Patron thePatron)
	{
		try
		{
			theMedia.setReserved(thePatron);
			
			return true;
			
		} catch (IndexOutOfBoundsException e) 
		{
		    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		    return false;
		}
	}
	
	Boolean renewCheckout(Media theMedia)
	{
		try
		{
				// This method of updating the date was found on StackOverflow:
				// "http://stackoverflow.com/questions/428918/how-can-i-increment-a-date-by-one-day-in-java"
			Date newDate = theMedia.getDueDate();
			newDate = DateUtil.addDays(newDate, 7);
			theMedia.setDueDate(newDate);
			
		} catch (IndexOutOfBoundsException e) 
		{
		    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		    return false;
		} 
		
		return true;
	}
	
	Boolean checkOut(Hashtable<String, Media> theMediaTable, Media theMedia, 
			Hashtable<Integer, Patron> theProfiles, Patron thePatron)
	{
		try
		{
			theMediaTable.get(theMedia.getTitle()).setCheckedOut(thePatron);
			theProfiles.get(thePatron.getIDNumber()).getMediaList().add(theMedia);
			System.out.println ("Checkout successful");
		} catch (IndexOutOfBoundsException e) 
		
		{
		    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		    return false;
		} 
		
		return true;
	}
	
	void checkIn(Hashtable<String, Media> theMediaTable, Media theMedia, 
			Hashtable<Integer, Patron> theProfiles, Patron thePatron)
	{
		Patron blankPatron = new Patron(0);
		theMediaTable.get(theMedia.getTitle()).setCheckedOut(blankPatron);
		theProfiles.get(thePatron.getIDNumber()).getMediaList().remove(theMedia.getTitle());
		theMediaTable.get(theMedia.getTitle()).setDueDate(null);
	}
}
