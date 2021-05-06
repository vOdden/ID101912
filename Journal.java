
/**
 * Represents a journal. A journal is a type of Literature.
 *
 * @author  Kjetil Steinbakken, Håkon Sæther og Sigurd Odden.
 * @version V 1.1
 */
public class Journal extends Literature
{
    private String author;
    private String publisher;
    private int published;
    
    /**
     * Creates an instance of Journal.
     *
     * @param (String) title, the title of the journal
     * @param (String) publisher, the name of the Publisher of the journal
     * @param (int) published, the number of publishes per year
     * @param (String) type, type of journal
     */
    public Journal(String title, String publisher, int published, String type)
    {
     //Initialise instance variables
     super(title, publisher, type);
     this.published = published;
    }
    
    /**
     * Returns the number of publishes per year
     * @return the number of publishes per year.
     */
    public int getPublished()
    {
        return this.published;   
    }
    
    /**
     * sets the number of publishes per year
     * @param (int) published, the number of publishes per year
     */
    public int setPublished(int published)
    {
        return this.published = published;
    }
}
