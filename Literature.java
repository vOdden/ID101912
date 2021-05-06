
/**
 * Superclass for the subclasses Book, Newspaper and Journal. (Stores title, publisher and type 
 * delivered from the subclases)
 * 
 * @author  Kjetil Steinbakken, Håkon Sæther og Sigurd Odden.
 * @version V 1.1
 */
public abstract class Literature
{
    private String title;
    private String publisher;
    private String type;

    /**
     * Creates a new instance of Literature.
     * @param title the title of the literature
     * @param publisher the publisher of the literature
     * @param type of the literature
     */
    public Literature(String title, String publisher, String type)
    {
        //Initialise instance variables
        this.title = title;
        this.publisher = publisher;
        this.type = type;
    }

    /**
     * Returns the title of the literature.
     * @return the title of the literature
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Returns the type of the literature.
     * @return the type of the literature
     */
    public String getType()
    {
        return this.type;
    }
    
    /**
     * Returns the name of the publisher.
     * @return the name of the publisher.
     */
    public String getPublisher()
    {
        return this.publisher;
    }

    /**
     * Sets the title of the literature.
     * @param title the new title of the literature.
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Sets the publisher of the literature.
     * @param publisher the publisher name.
     */
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

}
