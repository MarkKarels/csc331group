import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** FantasyFootballDraft.java
 * Program Purpose: Fantasy Football Draft - Final Project
 * A live fantasy football draft using GUI where there is one user-drafted team
 * and two CPU teams that will auto-draft to fill their roster
 * @author Andrew Court, Liam Coyle, Mark Karels, Charlie Morlock, & Trevor Shelton
 * Due Date: 4/24/2022 by 11:59pm
 * Course: CSC 331
 */

public class FantasyFootballDraft extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root =
                FXMLLoader.load(getClass().getResource("PlayerSelect.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Fantasy Football Draft");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch(args);}
}
