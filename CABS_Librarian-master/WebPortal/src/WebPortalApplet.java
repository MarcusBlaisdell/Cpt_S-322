/**
 * Created by Joseph on 4/22/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;

public class WebPortalApplet extends JApplet implements ActionListener {
    private ArrayList<media> searchList;
    private Patron user = null;

    public void init()
    {
        renderer();
    }

    public void paint (Graphics g)
    {
//        g.drawString("Hello World", 25, 50);
//        add(new JLabel("Library Catalog", 0));
//        add("Search Field", new JTextField());
//        add("Search Button", new JButton("Search"));
//        getComponent(2).addComponentListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        JPanel cards = (JPanel)getContentPane().getComponent(0);
        CardLayout cl = (CardLayout)cards.getLayout();

        if(cmd.equals("search media"))
        {
            JPanel j = (JPanel)getContentPane().getComponent(0);
            j = (JPanel)j.getComponent(0);
            JTextField f = (JTextField)j.getComponent(1);
            String s = f.getText();
            String[] search = s.split(" ");

            for(int i = 0; i < search.length; i++)
            {
                searchList.addAll(mediaManager.searchMedia(search[i]));
            }

            JPanel panel = (JPanel)getContentPane().getComponent(0);
            panel = (JPanel)panel.getComponent(1);

            cl.show(cards, "search results");

            JButton homeTop = new JButton("Home");
            homeTop.addActionListener(this);
            homeTop.setActionCommand("home from search");
            panel.add(homeTop);

            panel.add(new JScrollBar(JScrollBar.VERTICAL));

            for(int i = 0; i < searchList.size(); i++)
            {
                media m = searchList.get(i);
                panel.add(new JLabel("Title: " + m.getTitle()));
                panel.add(new JLabel("Genre: " + m.getGenre()));
                panel.add(new JLabel("Description: " + m.getDescription()));
                panel.add(new JLabel("Author: " + m.getAuthor));
                panel.add(new JLabel("Publisher: " + m.getPublisher()));
                panel.add(new JLabel("Language: " + m.getLanguage()));
                panel.add(new JLabel("Subject: " + m.getSubject()));
                panel.add(new JLabel("Status:"));
                Patron reserved = m.getReserved();
                if(reserved != null) panel.add(new JLabel("Reserved by: " reserved.getName()));
                else panel.add(new JLabel("Not reserved"));
                Patron checkedOut = m.getCheckedOut();
                if(checkedOut != null)
                {
                    panel.add(new JLabel("Checked out by: " + checkedOut.getName()));
                    Date dueDate = m.getDueDate();
                    String month = dueDate.toString().substring(4,6);
                    String day = dueDate.toString().substring(8,9);
                    String year = dueDate.toString().substring(24,27);
                    String date = month + " " + day + ", " + year;
                    panel.add(new JLabel("Due date: " + date));
                }
                else panel.add(new JLabel("Not checked out"));
                panel.add(new JLabel("Location: " + m.getLocation()));
                if(media instanceof Book)
                {
                    panel.add(new JLabel("Edition: " + (Book)m.getEdition()));
                    panel.add(new JLabel("ISBN: " + (Book)m.getISBN()));
                }
                if(media instanceof DVD)
                {
                    panel.add(new JLabel("Region: " + (DVD)m.getRegion()));
                    panel.add(new JLabel("ID: " + (DVD)m.getID()));
                }
                JButton placeHold = new JButton("Place hold");
                placeHold.addActionListener(this);
                placeHold.setActionCommand("place hold " + i);
                panel.add(placeHold);

                JButton deleteMedia = new JButton("Delete");
                deleteMedia.addActionListener(this);
                deleteMedia.setActionCommand("delete media " + i);
                panel.add(deleteMedia);

                JButton checkOutMedia = new JButton("Check out");
                checkOutMedia.addActionListener(this);
                checkOutMedia.setActionCommand("check out media " + i);
                panel.add(checkOutMedia);

                JButton checkInMedia = new JButton("Check in");
                checkInMedia.addActionListener(this);
                checkInMedia.setActionCommand("check in media " + i);
                panel.add(checkInMedia);

                JButton renew = new JButton("Renew");
                renew.addActionListener(this);
                renew.setActionCommand("renew item " + i);
                panel.add(renew);
            }
            JButton homeBottom = new JButton("Home");
            homeBottom.addActionListener(this);
            homeBottom.setActionCommand("home from search");
            panel.add(homeBottom);
        }

        if (cmd.contains("renew item"))
        {
            JPanel panel = (JPanel)cards.getComponent(1);
            int index = 0;
            for (int i = 11; i < cmd.length(); i++)
            {
                index = (index * 10) + (cmd.charAt(i) - '0');
            }

            if(user != null)
            {
                if(mediaManager.renewCheckout(searchList.get(index)))
                    panel.add(new JLabel("Checked in " + searchList.get(index).getTitle()), 0);
                else panel.add(new JLabel("Check in failed"), 0);
            }
            else panel.add(new JLabel("You are not logged in"), 0);
        }

        if (cmd.contains("check in media"))
        {
            JPanel panel = (JPanel)cards.getComponent(1);
            int index = 0;
            for (int i = 15; i < cmd.length(); i++)
            {
                index = (index * 10) + (cmd.charAt(i) - '0');
            }

            if(user != null)
            {
                if(user.getUserLevel() > 1)
                {
                    mediaManager.checkIn(searchList.get(index));
                    panel.add(new JLabel("Checked in " + searchList.get(index).getTitle()), 0);
                }
                else panel.add(new JLabel("You do not have clearance to perform this action"), 0);
            }
            else panel.add(new JLabel("You are not logged in"), 0);
        }

        if(cmd.contains("check out media"))
        {
            JPanel panel = (JPanel)cards.getComponent(1);
            int index = 0;
            for (int i = 16; i < cmd.length(); i++)
            {
                index = (index * 10) + (cmd.charAt(i) - '0');
            }
            if(user != null)
            {
                if(mediaManager.checkOut(searchList.get(index), user))
                        panel.add(new JLabel("Checked out " + searchList.get(index).getTitle()));
                else panel.add(new JLabel("Check out failed"), 0);
            }
            else panel.add(new JLabel("You are not logged in"), 0)
        }

        if(cmd.equals("get patron"))
        {
            JPanel j = (JPanel)getContentPane().getComponent(0);
            j = (JPanel)j.getComponent(0);
            JTextField f = (JTextField)j.getComponent(1);
            String s = f.getText();

            cl.show(cards, "patron");

            int ID = 0;
            for(int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                ID = (ID * 10) + (c - '0');
            }

            Patron p = patronManager.getUser(ID);

            JPanel panel = (JPanel) getContentPane().getComponent(0);
            panel = (JPanel) panel.getComponent(2);

            if(user == null) {
                panel.add(new JLabel("User not logged in"));
            }
            else {
                if (user.getUserLevel == 1 && user.getUserID() != p.getUserID())
                {
                    panel.add(new JLabel("You do not have clearance to view this"));
                }
                else {
                    panel.add(new JLabel("Name: " + p.getName()));

                    panel.add(new JLabel("ID: " + p.getIDNumber()));

                    panel.add(new JLabel("Email: " + p.getEmail()));

                    panel.add(new JLabel("Media:"));

                    ArrayList<media> patronMedia = p.getMedia();
                    for(int i = 0; i < patronMedia.size(); i++)
                    {
                        media m = patronMedia.get(i);
                        panel.add(new JLabel("Title: " + m.getTitle()));
                        panel.add(new JLabel("Genre: " + m.getGenre()));
                        panel.add(new JLabel("Description: " + m.getDescription()));
                        panel.add(new JLabel("Author: " + m.getAuthor));
                        panel.add(new JLabel("Publisher: " + m.getPublisher()));
                        panel.add(new JLabel("Language: " + m.getLanguage()));
                        panel.add(new JLabel("Subject: " + m.getSubject()));
                        panel.add(new JLabel("Location: " + m.getLocation()));
                        if(media instanceof Book)
                        {
                            panel.add(new JLabel("Edition: " + (Book)m.getEdition()));
                            panel.add(new JLabel("ISBN: " + (Book)m.getISBN()));
                        }
                        if(media instanceof DVD)
                        {
                            panel.add(new JLabel("Region: " + (DVD)m.getRegion()));
                            panel.add(new JLabel("ID: " + (DVD)m.getID()));
                        }
                        panel.add(new JLabel("---------"));
                    }
                }
            }
            JButton homeBottom = new JButton("Home");
            homeBottom.addActionListener(this);
            homeBottom.setActionCommand("home from patron");
            panel.add(homeBottom);
        }

        if(cmd.equals("home from search"))
        {
            JPanel panel = (JPanel)cards.getComponent(1);
            panel.removeAll();
            searchList.clear();
            panel.revalidate();
            cl.show(cards, "home");
        }

        if(cmd.equals("home from patron"))
        {
            JPanel panel = (JPanel)cards.getComponent(2);
            panel.removeAll();
            panel.revalidate();
            cl.show(cards, "home");
        }

        if(cmd.equals("log in page"))
        {
            cl.show(cards, "login");
        }

        if(cmd.equals("log in"))
        {
            JPanel panel = (JPanel)cards.getComponent(3);

            JTextField IDField = (JTextField)panel.getComponent(1);
            JTextField PasswordField = (JTextField)panel.getComponent(3);

            String IDString = IDField.getText();
            int IDNum = 0;
            for(int i = 0; i < IDString.length(); i++)
            {
                char c = IDString.charAt(i);
                IDNum = (IDNum * 10) + (c - '0');
            }

            Patron p = patronManager.get(IDNum);

            if (!p.getPassword().equals(PasswordField.getText()))
            {
                if(panel.getComponents().length == 4) panel.add(new JLabel("Incorrect ID or password"));
            }

            else
            {
                cl.show(cards, "home");
            }
        }

        if(cmd.contains("place hold"))
        {
            JPanel panel = (JPanel)cards.getComponent(1);
            int index = 0;
            for (int i = 11; i < cmd.length(); i++)
            {
                index = (index * 10) + (cmd.charAt(i) - '0');
            }
            if(user != null) {
                if(mediaManager.RequestHold(searchList.get(index), user))
                    panel.add(new JLabel("Hold placed on: " + searchList.get(index).getTitle()), 0);
                else panel.add(new JLabel("Hold unsuccessful on: " + searchList.get(index).getTitle()), 0);
            }
            else panel.add(new JLabel("You are not logged in"), 0);
        }

        if(cmd.contains("delete media"))
        {
            JPanel panel = (JPanel)cards.getComponent(1);
            int index = 0;
            for (int i = 13; i < cmd.length(); i++)
            {
                index = (index * 10) + (cmd.charAt(i) - '0');
            }
            if(user != null)
            {
                if(user.getUserLevel() == 3)
                {
                    mediaManager.removeMedia(searchList.get(index));
                    panel.add(new JLabel("Removed " + searchList.get(index).getTitle), 0);
                }
                else
                {
                    panel.add(new JLabel("You don't have clearance to perform this action"), 0);
                }
            }
            else panel.add(new JLabel("You are not logged in"));
        }

        if(cmd.equals("add book"))
        {
            if (user != null)
            {
                if (user.getUserLevel() == 3) {
                    cl.show(cards, "add book");
                }
            }
        }

        if(cmd.equals("add dvd"))
        {
            if (user != null)
            {
                if (user.getUserLevel() == 3) {
                    cl.show(cards, "add dvd");
                }
            }
        }

        if(cmd.equals("submit add dvd"))
        {
            JPanel panel = (JPanel)cards.getComponent(5);
            String[] input = new String[10];
            for (int i = 1; i <= 19; i = i + 2)
            {
                JTextField curr = (JTextField)panel.getComponent(i);
                input[i/2] = curr.getText();
            }

            DVD d = new DVD();

            d.setTitle(input[0]);

            d.setGenre(input[1]);

            d.setDescription(input[2]);

            d.setAuthor(input[3]);

            d.setPublisher(input[4]);

            d.setLanguage(input[5]);

            d.setSubject(input[6]);

            d.setLocation(input[7]);

            d.setRegion(input[8]);

            int ID = 0;
            for(int i = 0; i < input[9].length(); i++)
            {
                ID = (ID * 10) + (input[9].charAt(i) - '0');
            }
            d.setID(ID);

            mediaManager.addMedia(d);

            cl.show(cards, "home");
        }

        if(cmd.equals("submit add book"))
        {
            JPanel panel = (JPanel)cards.getComponent(4);
            String[] input = new String[10];
            for (int i = 1; i <= 19; i = i + 2)
            {
                JTextField curr = (JTextField)panel.getComponent(i);
                input[i/2] = curr.getText();
            }

            Book b = new Book();

            b.setTitle(input[0]);

            b.setGenre(input[1]);

            b.setDescription(input[2]);

            b.setAuthor(input[3]);

            b.setPublisher(input[4]);

            b.setLanguage(input[5]);

            b.setSubject(input[6]);

            b.setLocation(input[7]);

            b.setEdition(input[8]);

            int ISBN = 0;
            for(int i = 0; i < input[9].length(); i++)
            {
                ISBN = (ISBN * 10) + (input[9].charAt(i) - '0');
            }
            b.setISBN(ISBN);

            mediaManager.addMedia(b);

            cl.show(cards, "home");
        }
    }

    private void renderer()
    {
//        setLayout(null);
        JPanel homeCard = new JPanel(new FlowLayout());
        homeCard.add(new JLabel("Library Catalog Search:", 0));
//        for(Component c : getContentPane().getComponents())
//        {
//            System.out.println("Label");
//        }
        homeCard.add(new JTextField());
//        for(Component c : getContentPane().getComponents())
//        {
//            System.out.println("search field");
//        }
        JButton searchMediaButton = new JButton("Search Media");
        searchMediaButton.addActionListener(this);
        searchMediaButton.setActionCommand("search media");
        homeCard.add(searchMediaButton);

        JButton getPatronButton = new JButton("Get Patron");
        getPatronButton.addActionListener(this);
        getPatronButton.setActionCommand("get patron");
        homeCard.add(getPatronButton);

        JButton addBookButton = new JButton("Add book");
        addBookButton.addActionListener(this);
        addBookButton.setActionCommand("add book");
        homeCard.add(addBookButton);

        JButton addDVDButton = new JButton("Add DVD");
        addDVDButton.addActionListener(this);
        addDVDButton.setActionCommand("add dvd");
        homeCard.add(addDVDButton);

        JButton loginPageButton = new JButton("Log in");
        loginPageButton.addActionListener(this);
        loginPageButton.setActionCommand("log in page");
        homeCard.add(loginPageButton);

        JPanel cards = new JPanel(new CardLayout());

        cards.add(homeCard, "home");

        JPanel searchResultsCard = new JPanel(new BoxLayout(cards, BoxLayout.Y_AXIS));
        cards.add(searchResultsCard, "search results");
//        getContentPane().getComponent(2).setPreferredSize(new Dimension(50,50));
//        for(Component c : getContentPane().getComponents())
//        {
//            System.out.println("button");
//        }

        JPanel patronCard = new JPanel(new BoxLayout(cards, BoxLayout.Y_AXIS));
        cards.add(patronCard, "patron");

        JPanel loginCard = new JPanel(new BoxLayout(cards, BoxLayout.Y_AXIS));

        loginCard.add(new JLabel("ID:"));

        loginCard.add(new JTextField());

        loginCard.add(new JLabel("Password:"));

        loginCard.add(new JTextField());

        JButton loginButton = new JButton("Log in");
        loginButton.addActionListener(this);
        loginButton.setActionCommand("log in");
        loginCard.add(loginButton);

        cards.add(loginCard, "login");

        JPanel addBookCard = new JPanel(new BoxLayout(cards, BoxLayout.Y_AXIS));

        addBookCard.add(new JLabel("Title:"));
        addBookCard.add(new JTextField());

        addBookCard.add(new JLabel("Genre:"));
        addBookCard.add(new JTextField());

        addBookCard.add(new JLabel("Description:"));
        addBookCard.add(new JTextField());

        addBookCard.add(new JLabel("Author:"));
        addBookCard.add(new JTextField());

        addBookCard.add(new JLabel("Publisher:"));
        addBookCard.add(new JTextField());

        addBookCard.add(new JLabel("Language:"));
        addBookCard.add(new JTextField());

        addBookCard.add(new JLabel("Subject:"));
        addBookCard.add(new JTextField());

        addBookCard.add(new JLabel("Location:"));
        addBookCard.add(new JTextField());

        addBookCard.add(new JLabel("Edition:"));
        addBookCard.add(new JTextField());

        addBookCard.add(new JLabel("ISBN:"));
        addBookCard.add(new JTextField());

        JButton addBookSubmit = new JButton("Submit");
        addBookSubmit.addActionListener(this);
        addBookSubmit.setActionCommand("submit add book");
        addBookCard.add(addBookSubmit);

        cards.add(addBookCard, "add book");

        JPanel addDVDCard = new JPanel(new BoxLayout(cards, BoxLayout.Y_AXIS));

        addDVDCard.add(new JLabel("Title:"));
        addDVDCard.add(new JTextField());

        addDVDCard.add(new JLabel("Genre:"));
        addDVDCard.add(new JTextField());

        addDVDCard.add(new JLabel("Description:"));
        addDVDCard.add(new JTextField());

        addDVDCard.add(new JLabel("Author:"));
        addDVDCard.add(new JTextField());

        addDVDCard.add(new JLabel("Publisher:"));
        addDVDCard.add(new JTextField());

        addDVDCard.add(new JLabel("Language:"));
        addDVDCard.add(new JTextField());

        addDVDCard.add(new JLabel("Subject:"));
        addDVDCard.add(new JTextField());

        addDVDCard.add(new JLabel("Location:"));
        addDVDCard.add(new JTextField());

        addDVDCard.add(new JLabel("Region:"));
        addDVDCard.add(new JTextField());

        addDVDCard.add(new JLabel("ID:"));
        addDVDCard.add(new JTextField());

        cards.add(addDVDCard, "add dvd");

        getContentPane().add(cards);

        JPanel panel = (JPanel)getContentPane().getComponent(0);
        CardLayout cl = (CardLayout)panel.getLayout();
        cl.show(cards, "home");
    }
}
