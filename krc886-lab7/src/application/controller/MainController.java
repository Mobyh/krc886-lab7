/**
 * Main Controller for the program
 * 
 * @author Luis Garza krc886
 */

package application.controller;

import application.model.Market;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController implements EventHandler<ActionEvent>{

	/*Class variables*/
	@FXML
	Button button;
	@FXML
	TextArea area;
	
	Market market = new Market();
	
	public void handle(ActionEvent event) {
		market.loadItemsFromFile();
		
	}

}
