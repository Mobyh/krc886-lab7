/**
 * Main Controller for the program
 * 
 * @author Luis Garza krc886
 */

package application.controller;

import application.model.Item;
import application.model.Market;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController implements EventHandler<ActionEvent>{

	/*Class variables*/
	@FXML
	Button button;
	@FXML
	TextArea area;
	
	//Set up regular expression to process text area
	final String regex = "^([a-zA-Z ]*)[ ]*([0-9]*)[ ]*[$]([0-9]*[.][0-9]{2})$";
	final Pattern pattern = Pattern.compile(regex);
	
	
	Market market = new Market();
	
	/**
	 * Handles functionality of the save button
	 */
	public void handle(ActionEvent event) {
		String[] tokens = area.getText().split("\n");
		for(int i = 0; i<tokens.length; i++) {
			final Matcher matcher = pattern.matcher(tokens[i]);
			if(matcher.find()) {
				Item item = new Item(matcher.group(1).trim(), Integer.parseInt(matcher.group(2)), Double.parseDouble(matcher.group(3)));
				market.addItem(item);
			}
		}
		market.saveItemsToFile();
	}
	
	/**
	 * Runs before the user sees the view, loads items and displays them on text area
	 */
	public void initialize() {
		market.loadItemsFromFile();
		market.getInventory().forEach((k,v) -> area.appendText(v.toString() + "\n"));
	}

}
