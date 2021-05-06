
/**
 * Represents a newspaper. A newspaper is a type of Literature.
 *
 * @author  Kjetil Steinbakken, Håkon Sæther og Sigurd Odden.
 * @version V 1.1
 */
public class Newspaper extends Literature
{
    private int numberOfYearlyIssues;
    private int issueNumber;
    private int maximumYearlyIssues = 365;
    /**
     * Creates an instance of Newspaper.
     *
     * @param (String) title, the title of the newspaper
     * @param (String) publisher, the name of the Publisher of the newspaper
     * @param (int) issueNo, the number of this issue
     * @param (int) numberOfIssues, total number of issues per year
     * @param (String) type, type of newspaper
     */
    public Newspaper(String title, String publisher, int issueNo, int numberOfIssues, String type)
    {
        //Initialise instance variables
        super(title, publisher,type);
        this.issueNumber = issueNo;
        this.numberOfYearlyIssues = numberOfIssues;
    }

    /**
     * Returns the number of yearly issues.
     * @return the number of yearly issues.
     */
    public int getNumberOfYearlyIssues()
    {
        return numberOfYearlyIssues;
    }

    /**
     * Returns the issue number of this issue.
     * @return the issue number of this issue.
     */
    public int getIssueNumber()
    {
        return issueNumber;
    }

    /**
     * Sets the number of yearly issues.
     * @param numberOfYearlyIssues the number of yearly issues.
     */
    public void setNumberOfYearlyIssues(int numberOfYearlyIssues ) throws IllegalArgumentException {
        if(numberOfYearlyIssues > maximumYearlyIssues)
        {
            throw new IllegalArgumentException("The number of yearly issues exceeds the maximum");
        }
        this.numberOfYearlyIssues = numberOfYearlyIssues;
    }

    /**
     * Sets the issue number.
     * @param issueNumber the issue number.
     */
    public void setIssueNumber(int issueNumber) throws IllegalArgumentException {
        if(issueNumber > maximumYearlyIssues)
        {
            throw new IllegalArgumentException("The number of issues exceeds the maximum");
        }
        this.issueNumber = issueNumber;
    }
}
