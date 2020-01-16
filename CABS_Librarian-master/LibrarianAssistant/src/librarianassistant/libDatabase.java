package librarianassistant;

import java.util.*;

public class libDatabase
{
	public Hashtable<Integer, Patron> profiles = new Hashtable<Integer, Patron>();
	public Hashtable<String, Media> mediaTable = new Hashtable<String, Media>();
	
	Patron getProfile (Integer theID)
	{
		return profiles.get(theID);
	}
	
	Media getMedia (String theTitle)
	{
		return mediaTable.get(theTitle);
	}
	
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

}
