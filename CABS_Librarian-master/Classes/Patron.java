import java.applet.*;
import java.awt.*;
import PatronManager;
import MediaManager;

public class Patron
{
    Private int IDNumber;
    Private String theName;
    Private String theEmail;
    Private String thePassword;
    Private media theMediaList;
    Private int theUserLevel;
    
    
    int getIDNumber(int theID)
    {
        profiles.get(theID).IDNumber = theID;
        return theID;
    }

    void setIDNumber(int theID, int IDNumber)
    {
        profiles.put(theID).IDNumber;
    }

    String getName(int theID)
    {
        profiles.get(theID).Name = theName;
        return theName;
    }

    void setName(int theID, String theName)
    {
        profiles.put(theID).Name = theName;
    }

    String getEmail(int theID)
    {
        profiles.get(theID).Email = theEmail;
        return theEmail;
    }

    void setEmail(int theID, String theEmail)
    {
        profiles.put(theID).Email = theEmail;
    }

    String getPassword(int theID)
    {
        profiles.get(theID).password = thePassword;
        return thePassword;
    }

    void setPassword(int theID, String thePassword)
    {
        profiles.put(theID).password = thePassword;
    }

    ArrayList getMediaList(int theID)
    {
        profiles.get(theID).mediaList = theMediaList;
        return theMediaList;
    }

    void AddToMediaList(int theID, media theMediaList)
    {
        profiles.put(theID).mediaList = theMediaList;
    }

    int getUserLevel(int theID)
    {
        profiles.get(theID).userLevel = theUserLevel;
        return theUserLevel;
    }

    void setUserLevel(int theID, int theUserLevel)
    {
        profiles.set(theID).userLevel = theUserLevel;
    }
}
