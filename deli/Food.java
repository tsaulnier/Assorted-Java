package deli;

import java.util.*;

/**
 * a food is either a sandwich or a salad
 * @author Thomas Saulnier
 */
public abstract class Food {
	
	protected int sandwichCount;
	protected int saladCount;
	
	public Food() {
		
	}
	
	/**
	 * adds a meat to the food item
	 * @param meatToAdd
	 */
	public abstract void addMeatToFood(Meat meatToAdd);
	
	/**
	 * adds a vegetable to the food item
	 * @param vegetableToAdd
	 */
	public abstract void addVegetableToFood(Vegetable vegetableToAdd);
	
	/**
	 * adds cheese to the food itemCom
	 * @param addCheese: true if cheese is added, false otherwise
	 */
	public abstract void addCheeseToFood(Cheese cheeseToAdd);
	
	/**
	 * gets the price of the food or drink item
	 * @return: the food or drink item price in USD
	 */
	public abstract double getPriceOfFoodItem();

	/**
	 * THIS METHOD WAS NOT IN THE UML
	 * @return: true if food item is a sandwich, false otherwise
	 */
	public abstract boolean isFoodItemASandwich();
}
