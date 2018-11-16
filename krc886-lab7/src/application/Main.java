package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {	
	/**
	 * Handles the setup of the stage and first scene
	 */
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
			stage.setScene(new Scene(root, 800, 800)); 
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
