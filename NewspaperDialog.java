import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
/**
 * Write a description of class NewspaperDialog here.
 * The NewspaperDialog class is not done at this very moment.
 *
 * @author  Kjetil Steinbakken, Håkon Sæther og Sigurd Odden.
 * @version V 1.1
 */
public class NewspaperDialog extends Dialog<Newspaper>
{
    private Newspaper existingNewspaper = null;
    /**
     * Constructor for objects of class NewspaperDialog
     */
    public NewspaperDialog()
    {
        //Initialise instance variables
        super();
        createContent();
    }

    private void createContent()
    {
        setTitle("Newspaper Details");

        // Set the button types.
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setPromptText("Title");

        TextField publisher = new TextField();
        publisher.setPromptText("Publisher");

        TextField issueNoTxt = new TextField();
        issueNoTxt.setPromptText("Issue number");
        // Prevent characters (non-integers) to be added
        issueNoTxt.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable,
                String oldValue, String newValue)
                {
                    try
                    {
                        if (newValue.length() > 0)
                        {
                            Integer.parseInt(newValue);
                        }
                    } catch (NumberFormatException e)
                    {
                        issueNoTxt.setText(oldValue);
                    }
                }
            });

        TextField totalNoOfIssuesTxt = new TextField();
        totalNoOfIssuesTxt.setPromptText("Total number of issues");
        // Prevent characters (non-integers) to be added
        totalNoOfIssuesTxt.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable,
                String oldValue, String newValue)
                {
                    try
                    {
                        if (newValue.length() > 0)
                        {
                            Integer.parseInt(newValue);
                        }
                    } catch (NumberFormatException e)
                    {
                        totalNoOfIssuesTxt.setText(oldValue);
                    }
                }
            });

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("Issue number:"), 0, 2);
        grid.add(issueNoTxt, 1, 2);
        grid.add(new Label("Number of issues pr year:"), 0, 3);
        grid.add(totalNoOfIssuesTxt, 1, 3);

        getDialogPane().setContent(grid);

        // Convert the result to Newspaper-instance when the OK button is clicked.

    }
}
