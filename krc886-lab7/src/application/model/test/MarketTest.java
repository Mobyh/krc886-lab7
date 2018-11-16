package application.model.test;

import org.junit.Before;
import org.junit.Test;

import application.model.Item;
import application.model.Market;

public class MarketTest {

	private Market market;
	private Item item;
	
	@Before
	public void setUp() throws Exception {
		market = new Market();
		item = new Item("Ice Cream", 10, 25.23);
		market.getInventory().put(item.getName(), item);
	}

	@Test
	public void testAddItem() {
		market.addItem(item);
		assert (market.getInventory().get(item.getName())) != null : "Error in good check for add Item item Ice Cream !=" + market.getInventory().get(item.getName());
	}

	@Test
	public void testGetQuantity() {
		Integer quantity = market.getQuantity(item.getName());
		assert (quantity == item.getQuantity()):"Error in good check for get quantity 10 !=" + quantity;
	}

	@Test
	public void testGetPrice() {
		String price = market.getPrice(item.getName());
		assert (price.equals(item.getStrPrice())):"Error in good check for get price $25.23 !=" + price;
	}

	@Test
	public void testUpdateQuantity() {
		market.updateQuantity(item.getName(), 50);
		assert (item.getQuantity() == 50): "Error in good check for update quantity 50 !=" + item.getQuantity();
	}

}
