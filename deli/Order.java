package deli;

import java.util.*;

/**
 * An order comprises of collections of food and drink items respectively
 * 
 * @author Thomas Saulnier
 */
public class Order {
	
	//representation
	private int uniqueID; //a unique identification number for the order, never null, > 0
	private int sandwichCount;
	private int saladCount;
	private Collection<Food> foodInOrder; //the food items in this order, never null, can be empty if drinksInOrder is not empty
	private Collection<Drink> drinksInOrder; //the food items in this order, never null, can be empty if foodInOrder is not empty
	private double totalOrderCost; //the total cost of all items in the order, never null, values >= 0 
	
	
	public Order() {
		uniqueID = System.identityHashCode(this);
		foodInOrder = new ArrayList<>();
		drinksInOrder = new ArrayList<>();
		totalOrderCost = 0;
	}
	
	/**
	 * gets the total cost of the order in USD and stores it
	 * @return: the additive total of each item in the order
	 */
	public double getTotalCost() {
		return totalOrderCost;
	}
	
	/**
	 * adds a sandwich or salad to the order (in USD, sandwiches are 3.50 each + 0.50 for 1st meat + 1.00 for nth additional meat + 0.50 for cheese
	 * salads are 3.00 with no cost for extra vegetables, but adding meat costs 1.00 per type and cheese costs 0.50
	 * @param foodItem: the sandwich or salad to add to the order, never null
	 */
	public void addFoodToOrder(Food foodItem) {
		foodInOrder.add(foodItem);
		while (foodInOrder.iterator().hasNext()) {
			totalOrderCost += foodInOrder.iterator().next().getPriceOfFoodItem();
		}
	}
	
	/**
	 * adds a drink to the order (fixed price of 1.50 USD per drink added)
	 * @param drinkItem: the drink to add to the order, never null
	 */
	public void addDrinkToOrder(Drink drinkItem) {
		totalOrderCost += 1.50;
		drinksInOrder.add(drinkItem);
	}
	
	/**
	 * removes all items from order
	 */
	public void clearOrder() {
		totalOrderCost = 0;
	}
	
	/**
	 * THIS METHOD WAS NOT IN THE UML
	 * finds out if the next food item in the order is a sandwich
	 * @return: true if food item is a sandwich, false otherwise
	 */
	public boolean isNextFoodItemASandwich() {
		if (foodInOrder.iterator().hasNext()) {
			return foodInOrder.iterator().next().isFoodItemASandwich();
		}
		else {
			throw new IllegalStateException("Cannot call on an empty order");
		}
	}
	
}
