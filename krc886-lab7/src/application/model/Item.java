/**
 * Represents an item in the market.
 * 
 * @author Luis Garza krc886
 */
package application.model;

public class Item implements Comparable<Item>{
	
	/*Class variables*/
	private String name;
	private Integer quantity;
	private Double price;
	private String strPrice;
	
	/*Constructo*/
	public Item(String name, Integer quantity, Double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		strPrice = String.format("%.2f", this.price);
	}
	
	/*Class methods*/
	
	/**
	 * @return a formatted string that represents the information of a given item.
	 */
	public String toString() {
		return this.name + " " + this.quantity + " " + "$" + strPrice;
	}

	/**
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quantity.
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set.
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price.
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set.
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the strPrice
	 */
	public String getStrPrice() {
		return strPrice;
	}

	/**
	 * @param strPrice the strPrice to set
	 */
	public void setStrPrice(String strPrice) {
		this.strPrice = strPrice;
	}
	
	/**
	 * Compares two Items to see which one is greater alphabetically
	 */
	public int compareTo(Item item) {
		return this.name.compareTo(item.getName());
	}	
}
