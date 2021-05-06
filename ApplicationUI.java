import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * 
 * @author  Kjetil Steinbakken, Håkon Sæther og Sigurd Odden.
 * @version V 1.1
 */
public class ApplicationUI
{
    Register register = new Register();

    Scanner reader = new Scanner(System.in);
    /**
    public void startv2()
    {
        
        boolean finished = false;
        printWelcome();
        while(!finished) 
        {
            Scanner reader = new Scanner(System.in);
            int option = 0;
            if (reader.hasNext() )
            {
                option = reader.nextInt();
            }
            else
            {
                // Set choice to an invalid value
                option = 99;
            }

            switch(option)
            {
                case 1: //List all literatures
                if(register.empty())
                {
                    System.out.println("The register is empty");
                }
                else
                {
                    //register.show();    
                }
                break;
                case 2: //List the number of the literatures in the register
                System.out.println("Number of the literatures are "+ register.getSize());
                break;

                case 3: //Find all books
                if(register.empty())
                {
                    System.out.println("There are no books in the register");
                }
                else
                {
                    showBooksOnly();
                }
                break;

                case 4: //Find all newspaper
                if(register.empty())
                {
                    System.out.println("There are no newspapers in the register");
                }
                else
                {
                    showNewspapersOnly();
                }
                break;
                case 5: //Find all journals
                if(register.empty())
                {
                    System.out.println("There are no journals in the register");
                }
                else
                {
                    showJournalsOnly();
                }
                break;
                
                case 7: //Add literature to the literature
                System.out.println("Enter title:");
                String title = getInput();
                System.out.println("Enter publisher: ");
                String publisher = getInput();
                System.out.println("Please insert type:");
                String type = getInput();
                if(!(register.isValidType(type)))
                {

                    System.out.println("Enter issueNumber:");
                    int issueNumber = getIntInput();
                    System.out.println("Enter number of issues:");
                    int numberOfIssues = getIntInput();
                    register.addLiterature(new Newspaper(title, publisher, issueNumber, numberOfIssues, type));
                }

                if(!(register.isValidType(type)))
                {
                    System.out.println("Enter Author:");
                    String author = getInput();
                    System.out.println("Enter genre:");
                    String genre = getInput();
                    System.out.println("Number of pages:");
                    int numberOfPages = getIntInput();   
                    register.addLiterature(new Book(title, author, publisher, genre, numberOfPages, type));
                }

                if(!(register.isValidType(type)))
                {
                    System.out.println("published");
                    int published = getIntInput();
                    register.addLiterature(new Journal(title, publisher, published, type));
                }
                
                
                break;
                default:
                System.out.println("Invalid choice, please try again");

            }
        }
    }
    
    public void printWelcome()
    {
        //Make a menu.
        System.out.println();
        System.out.println("  #########   Menu  #########");
        System.out.println("Please type in an available option:");
        System.out.println("  1. List all types of the literature");
        System.out.println("  2. List the size of the register");
        System.out.println("  3. List all books");
        System.out.println("  4. List all newspapers");
        System.out.println("  5. List all journals");
        System.out.println("  6. Autofill");
        System.out.println("  7. Add literature");
    }

    public String getInput()
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim().toLowerCase();
        return input;
    }

    public int getIntInput()
    {
        Scanner scanInt = new Scanner(System.in);
        int intInput = scanInt.nextInt();
        return intInput;
    }

    public void showBooksOnly()
    {
        Iterator<Literature> it = this.register.getIterator();  
        while(it.hasNext())
        {
            Literature literature = it.next();
            if(literature instanceof Book)
            {
               // literature.display();    
            }
        }
    }

    public void showJournalsOnly()
    {
        Iterator<Literature> it = this.register.getIterator();
        while(it.hasNext())
        {
            Literature literature = it.next();
            if(literature instanceof Journal)
            {
               // literature.display();
            }
        }

    }

    public void showNewspapersOnly()
    {
        Iterator<Literature> it = this.register.getIterator();  
        while(it.hasNext())
        {
            Literature literature = it.next();
            if(literature instanceof Newspaper)
            {
               // literature.display();    
            }
        }
    }
    */
}
