/**
 * Holds a HashMap of Items and loads in data from csv file.
 * 
 * @author Luis Garza krc886
 */

package application.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Market {
	/*Class variables*/
	private HashMap<String, Item> inventory;
	
	/*Constructor*/
	public Market() {
		this.inventory = new HashMap<String,Item>();
	}

	
	/*Class methods*/
	/**
	 * Adds a given Item object to the Market.
	 * @param item
	 */
	public void addItem(Item item){
		inventory.put(item.getName(), item);
	}
	
	/**
	 * Returns the quantity of an Item, given its String name.
	 * @param name
	 * @return quantity of an item
	 */
	public Integer getQuantity(String name) {
		return this.inventory.get(name).getQuantity();
	}
	
	/**
	 * Returns the price of an Item, given its String name.
	 * @param name
	 * @return price of an item
	 */
	public String getPrice(String name) {
		return this.inventory.get(name).getStrPrice();
	}
	
	/**
	 * Updates the Item, saved in the Market, given the item name and quantity.
	 * @param name
	 * @param quantity
	 */
	public void updateQuantity(String name, Integer quantity) {
		this.inventory.get(name).setQuantity(quantity);
	}
	
	/**
	 * Loads the HashMap from the csv file.
	 */
	public void loadItemsFromFile() {
		File file = new File("data/market.csv");
		try {
			Scanner scan = new Scanner(file);
			String[] tokens;
			String line;
			
			while(scan.hasNextLine()) {
				line = scan.nextLine();
				tokens = line.split(",");
				Item item = new Item(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
				this.inventory.put(item.getName(), item);
			}
		
			scan.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		//Sort the map
		ArrayList<Item> items = new ArrayList<Item>();
		inventory.forEach((key,value)-> items.add(value));
		Collections.sort(items, new Comparator<Item>(){
			public int compare(Item i, Item j) {
				return i.getName().compareTo(j.getName());
			}
		});
		for(int i = 0; i< items.size(); i++) {
			inventory.put(items.get(i).getName(), items.get(i));
		}
	}
	
	/**
	 * Saves the HashMap to the csv file.
	 */
	public void saveItemsToFile(){
		File file = new File("data/market.csv");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("");
			inventory.forEach((key, value)->{
				try {
					writer.append(value.getName() + "," + value.getQuantity() + "," + value.getPrice());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the inventory.
	 */
	public HashMap<String, Item> getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set.
	 */
	public void setInventory(HashMap<String, Item> inventory) {
		this.inventory = inventory;
	}
}
