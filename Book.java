
/**
 * Represents a book. A book is a type of Literature.
 *
 * @author  Kjetil Steinbakken, Håkon Sæther og Sigurd Odden.
 * @version V 1.1 
 */
public class Book extends Literature
{
    //Publisher of the newspaper
    private String author;
    //Type of newspaper
    private String genre;
    //number of releases per month
    private int numberOfPages;

    /**
     * Creates an instance of Book.
     *
     * @param (String) title, the title of the book
     * @param (String) author, the author of the book
     * @param (String) publisher, the publisher of the book
     * @param (String) genre, the genre of the book
     * @param (int) numberOfPages, number of pages
     * @param (String) type, type of book
     */
    public Book(String title, String author, String publisher, String genre, int numberOfPages, String type)
    {
        //Initialise instance variables
        super(title,publisher,type);
        this.author = author;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }
    
    /**
     * Returns the author of the book.
     * @return the author of the book.
     */
    public String getAuthor()
    {
        return this.author;
    }
    
    /**
     * Returns number of pages.
     * @return number of pages.
     */
    public int getNumberOfPages()
    {
        return this.numberOfPages;
    }
    
    /**
     * Set genre of book
     * @param genre of book
     */
    public String setGenre(String genre)
    {
        return this.genre = genre;
    }
    
    /**
     * Set number of pages
     * @param number of pages
     */
    public int setNumberOfPages(int numberOfPages)
    {
        return this.numberOfPages = numberOfPages;
    }
    
}
