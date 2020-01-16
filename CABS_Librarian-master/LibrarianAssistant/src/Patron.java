
import java.util.*;

public class Patron
{
    private int IDNumber;
    private String Name;
    private String Email;
    private String Password;
    private ArrayList<Media> MediaList;
    private int UserLevel;
    
    
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

    ArrayList getMediaList()
    {
        return MediaList;
    }

    void AddToMediaList(ArrayList<Media> theMediaList)
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
