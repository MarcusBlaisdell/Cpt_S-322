package librarianassistant;

import java.util.*;

public class Patron
{
    private int IDNumber;
    private String Name;
    private String Email;
    private String Password;
    private ArrayList<Media> MediaList = new ArrayList<Media>();
    private int UserLevel;
    
    Patron ()
    {
    	
    }
    
    Patron(Integer theID)
    {
    	IDNumber = theID;
    }
    
    int getIDNumber()
    {
        return IDNumber;
    }

    void setIDNumber(int theID)
    {
        IDNumber = theID;
    }

    String getName()
    {
        return Name;
    }

    void setName(String theName)
    {
        Name = theName;
    }

    String getEmail()
    {
        return Email;
    }

    void setEmail(String theEmail)
    {
        Email = theEmail;
    }

    String getPassword()
    {
        return Password;
    }

    void setPassword(String thePassword)
    {
        Password = thePassword;
    }

    ArrayList<Media> getMediaList()
    {
        return MediaList;
    }

    void setMediaList(ArrayList<Media> theMediaList)
    {
        MediaList = theMediaList;
    }

    int getUserLevel()
    {
        return UserLevel;
    }

    void setUserLevel(int theUserLevel)
    {
        UserLevel = theUserLevel;
    }
}
