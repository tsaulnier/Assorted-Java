package deli;

import java.util.*;

/**
 * A restaurant that manages food, drink and combo orders
 * @author Thomas Saulnier
 */
public class Deli {

	//representation
	private double[] salesHistory; //tallies total money earned from sales, as well as quantity of each sandwich or salad sold, never null, contains no nulls, values >=0
	private Collection<Order> preparationQueue; //keeps track of orders to be prepared, never null, contains no nulls
	private Collection<Order> dispatchQueue; //keeps track of orders to be dispatched, never null, contains no nulls
	
	public Deli() {
		salesHistory = new double[3];
		for (int i = 0; i < 3; i++) {
			salesHistory[i] = 0;
		}
		preparationQueue = new ArrayList<>();
		dispatchQueue = new ArrayList<>();
	}
	
	/**
	 * adds an order to the preparation queue
	 * @param orderToPlace: never null
	 */
	public void placeOrder(Order orderToPlace) {
		preparationQueue.add(orderToPlace);
	}
	
	/**
	 * removes the next order from the preparation queue and places it into the dispatch queue
	 */
	public void prepareOrder() {
		if (!preparationQueue.isEmpty()) {
			Order order = preparationQueue.iterator().next();
			dispatchQueue.add(order);
			preparationQueue.remove(order);
		}
	}

	/**
	 * collects the sandwich and/or salad total quantity from order as well as the total cost of order and records it in salesHistory
	 * also removes the order from the dispatch queue (order has been fulfilled)
	 */
	public void sendOutOrder(Collection<Order> dispatchQueue) {
		if (!dispatchQueue.isEmpty()) {
			Order order = dispatchQueue.iterator().next();
			salesHistory[0] += order.getTotalCost();
			if (order.isNextFoodItemASandwich()) {
				salesHistory[1] += 1;
			}
			else {
				salesHistory[2] += 1;
			}
			salesHistory[0] += order.getTotalCost();
		}
	}
}
