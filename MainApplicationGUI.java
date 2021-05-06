import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
/**
 * The main application for the GUI, creates menubar, text area and other functionalities.
 * 
 * @author  Kjetil Steinbakken, Håkon Sæther og Sigurd Odden.
 * @version V 1.1 
 */
public class MainApplicationGUI extends Application
{
    // We keep track of the count, and label displaying the count:
    private Register Reg;
    private TextArea textArea;

    /**
     * The main window is the setup in this method,
     * including menus, toolboxes and similar.
     * @param primaryStage The main stage making up the main window.
     */

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.Reg = new Register();
        autofill();

        BorderPane rootN = new BorderPane();
        VBox topContainer = new VBox();
        MenuBar mainMenu = createMenus();
        ToolBar toolBar = createToolBar(); //
        topContainer.getChildren().add(mainMenu);
        topContainer.getChildren().add(toolBar);  //

        rootN.setTop(topContainer);
        // rootN.setBottom(createStatusBar()); //

        textArea = new TextArea();
        rootN.setCenter(textArea);
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(rootN, 800,500);
        primaryStage.setTitle("Literature libary");
        primaryStage.setScene(scene);

        // Show the Stage (window)
        primaryStage.show();
    }

    /**
     * Fills the text area with information from the literature register
     */
    private void fillTextAreaFromRegister()
    {
        for (Literature lit : this.Reg.getLiteratureList())
        {
            String textStr = lit.getTitle() + ", " + lit.getPublisher() + ", " + lit.getType() + "\n";
            this.textArea.appendText(textStr);
        }
    }

    /**
     * Creates the ToolBar to be displayed
     * @return the tool bar to be displayed
     */

    private ToolBar createToolBar()
    {
        ToolBar toolBar = new ToolBar();
        //Toolbar buttons:

        Button fileBtn = new Button();
        Button exitBtn = new Button();
        Button printBtn = new Button();

        fileBtn.setGraphic(new ImageView("Images/rsz_open1.png"));
        printBtn.setGraphic(new ImageView("Images/rsz_print1.png"));
        exitBtn.setGraphic(new ImageView("Images/rsz_exit1.png"));

        //Eventhandlers
        fileBtn.setOnAction(new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent event)
                {
                    textArea.appendText("File Openened..\n");
                }
            }); 

        printBtn.setOnAction(new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent event)
                {
                    fillTextAreaFromRegister();
                }
            }); 
        exitBtn.setOnAction(new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent event)
                {
                    exitApplication();
                }
            });
        //Add buttons to the toolbar
        toolBar.getItems().addAll(fileBtn, printBtn, exitBtn);
        return toolBar;
    }

    /**
     * Autofill the register with availible literature
     */
    private void autofill()
    {
        this.Reg.addLiterature(new Newspaper("VG", "Schibsted Norge", 123, 305, "Newspaper"));
        this.Reg.addLiterature(new Newspaper("Aftenposten", "Schibsted Norge", 204, 305, "Newspaper"));
        this.Reg.addLiterature(new Book("LOTR","Tolkien","Forlaget", "Fantasy", 1000, "Book"));
        this.Reg.addLiterature(new Book("LOTR2","Tolkien","Forlaget", "Fantasy", 1000, "Book"));        
    }

    /**
     *  Creates and returns the menus to be displayed.
     *  @return The MenuBar to be displayed
     */
    private MenuBar createMenus()
    {
        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("File");
        MenuItem openFile = new MenuItem("Open");
        MenuItem printFile = new MenuItem("List");
        MenuItem exitApp = new MenuItem("Exit");
        menuFile.getItems().addAll(openFile, printFile);
        menuFile.getItems().add(new SeparatorMenuItem());
        menuFile.getItems().add(exitApp);

        exitApp.setOnAction(new EventHandler<ActionEvent>()
                //EventHandler for exit
            {

                public void handle(ActionEvent event)
                {
                    exitApplication();
                }
            });

        printFile.setOnAction(new EventHandler<ActionEvent>()
            {

                public void handle(ActionEvent event)
                {
                    fillTextAreaFromRegister();
                }

            });

        // The Edit-menu
        Menu menuEdit = new Menu("Edit");
        // The View-menu
        Menu menuView = new Menu("View");
        //the Setting-menu
        Menu menuSetting = new Menu("Settings");
        MenuItem menuChangeColor = new MenuItem("Change colour to default-grey");
        MenuItem menuChangeColor2 = new MenuItem("Change colour to green and black");
        menuChangeColor.setOnAction(new EventHandler<ActionEvent>()
                //EventHandler for settings:
            {
                @Override
                public void handle(ActionEvent event)
                {
                    setColourDefault();
                }
            });
        menuChangeColor2.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    setColourGreenAndBlack();
                }
            });

        // The Help-menu
        Menu menuHelp = new Menu("Help");
        MenuItem menuAbout = new MenuItem("About");
        // MenuItem menuSettings = new MenuItem("Settings");
        menuHelp.getItems().add(new SeparatorMenuItem());
        menuAbout.setOnAction(new EventHandler<ActionEvent>()
                //EventHandler for about:
            {
                @Override
                public void handle(ActionEvent event)
                {
                    showAboutDialog();
                }
            });

        menuHelp.getItems().addAll(menuAbout);
        menuSetting.getItems().addAll(menuChangeColor, menuChangeColor2);
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView,menuHelp,menuSetting);
        //  menuBar.getMenus().addAll(menuHelp);
        return menuBar;

    }

    /**
     *  Changes the color of the application
     */
    public void setColourDefault()
    {
        textArea.setStyle("-fx-control-inner-background:#d0d0d0; -fx-font-family: Consolas; -fx-highlight-fill: #f4f4f4; -fx-highlight-text-fill: white; -fx-text-fill: #000000; ");

    }

    /**
     *  Changes the color of the application to typical hackerman
     */
    public void setColourGreenAndBlack()
    {
        textArea.setStyle("-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; ");

    }

    /**
     * Shows the About dialog.
     */
    private void showAboutDialog()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information dialog - About");
        alert.setHeaderText("Literature Register");
        alert.setContentText("File: open a file or list the literature\n"  
            + "Edit: Doesn't do anything at the moment\n"
            + "View: Doesn't do anything at the moment\n" 
            + "Settings: Change the colour of the background\n"
            + " \n"
            + "Application created by\n"
            + "Kjetil, Håkon & Sigurd (C) \n"
            + "v1.1 04.05.2018");
        alert.showAndWait();
    }

    /**
     * Exit the application with a confirmation dialog.
     */
    private void exitApplication()
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Exit Application ?");
        alert.setContentText("Are you sure you want to exit the Application? ");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK)
        {
            stop();  
        } else
        {
            //Do nothing
        }
    }

    /**
     * Stops the  application
     */
    @Override
    public void stop()
    {
        System.exit(0);
    }

    public static void main(String args[])
    {
        launch(args);
    }
    
}
