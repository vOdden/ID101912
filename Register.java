import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * The Literature register represents a register of all types of Literature,
 * 
 * @author  Kjetil Steinbakken, Håkon Sæther og Sigurd Odden.
 * @version V 1.1
 */
public class Register
{
    //the collection of Literature instances.
    private final ArrayList<Literature> Register;

    /**
     * Creates an instance of the literature-register.
     */
    public Register()
    {
        //Initialise instance variables
        this.Register = new ArrayList<>();
    }

    /**
     * Returns the list of literature.
     * @return the list of literature.
     */
    public ArrayList<Literature> getLiteratureList()
    {
        return this.Register;
    }
    /**
     * Returns the iterator from literature register.
     * @return the iterator from literature register.
     */
    public Iterator<Literature> getIterator()
    {
        return this.Register.iterator();
    }

    /**
     * Add a literature instance to the register
     * @param literature, the literature to add
     */
    public void addLiterature(Literature literature)
    {
        this.Register.add(literature);
    }

    /**
     * Returns the first instance of Literature with a title matching the title provided
     * @param title, the title to search for
     * @return returns a Literature object if a match is found. If not, null is returned.
     */
    public Literature findLiteratureByTitle(String title)
    {
        Literature result = null;
        boolean foundLiterature = false;
        Iterator<Literature> it = this.Register.iterator();
        while (it.hasNext() && !foundLiterature)
        {
            Literature lit = it.next();
            if (lit.getTitle().equals(title))
            {
                foundLiterature = true;
                result = lit;
            }
        }
        return result;
    }

    /**
     * Removes literature by name and returns the literature with a title matching the title provided title
     * @param (String) title, the title to remove
     * @return returns a Literature object if a match is found. If not, null is returned.
     */
    public Literature removeLiteratureByName(String title)
    {
        Literature literatureDeleted = null;

        Iterator<Literature> it = this.Register.iterator();
        while((null==literatureDeleted) && (it.hasNext()))
        {
            Literature lit = it.next();
            if(lit.getTitle().equals(title))
            {
                literatureDeleted = lit;
                it.remove();
            }
        }
        return literatureDeleted;
    }
    
    /**
     * Returns the number of items in the literature register.
     * @return the number of items in the literature register.
     */
    public int getSize()
    {
        return this.Register.size();
    }
    /**
     *  Return a boolean to check if the register is empty.
     *  @return true if empty, false if not.
     */
    public boolean empty()
    {
        return this.Register.isEmpty();
    }
    
    /**
     * Checks if String is correct. 
     * @return true if if string equals and false if not.
     */
    public boolean isValidType(String type)
    {
        if(type.equals("Newspaper") || type.equals("Journal") || type.equals("Journal")){
            return true; 
        } 
        else
        {
            return false; 
        }

    }

}
