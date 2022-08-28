package deli;

import java.util.*;

/**
 * a sandwich must have bread, and can contain any meat, vegetables or condiments
 * it has a price depending on its ingredients
 * @author Thomas Saulnier
 */
public class Sandwich extends Food {

	//representation
	
	private double costOfSandwich; //cost of sandwich with all ingredients, never null, value >= 3.50, in USD
	private Enum breadForSandwich; //the type of bread used for the sandwich
	private Collection<Meat> meatInSandwich; //all the meat in the sandwich, never null, contains no nulls
	private Collection<Vegetable> vegetablesInSandwich; //all the vegetables in the sandwich, never null, contains no nulls
	private Collection<Condiment> condimentsInSandwich; //list of condiments in sandwich, never null, contains no nulls
	private Collection<Cheese> cheeseInSandwich; //the cheese in the sandwich, never null, contains no nulls
	
	/**
	 * @param breadType: the type of bread on which the sandwich will be made, not null
	 */
	public Sandwich(Bread breadType) {
		costOfSandwich = 3.50;
		breadForSandwich = breadType;
		meatInSandwich = new ArrayList<>();
		vegetablesInSandwich = new ArrayList<>();
		condimentsInSandwich = new ArrayList<>();
		cheeseInSandwich = new ArrayList<>();
	}
	
	/**
	 * adds a meat to the sandwich
	 * @param meatToAdd: the meat to add to the sandwich, not null
	 */
	@Override
	public void addMeatToFood(Meat meatToAdd) {
		if (meatInSandwich.isEmpty()) {
			costOfSandwich += 0.50;
		}
		else {
			costOfSandwich += 1.00;
		}
		meatInSandwich.add(meatToAdd);
	}

	/**
	 * adds a vegetable to the sandwich
	 * @param vegetableToAdd: the vegetable to add to the sandwich, not null
	 */
	@Override
	public void addVegetableToFood(Vegetable vegetableToAdd) {
		vegetablesInSandwich.add(vegetableToAdd);
	}
	
	/**
	 * adds a condiment to the sandwich
	 * @param condimentToAdd: the condiment to add to the sandwich, not null
	 */
	public void addCondimentToSandwich(Condiment condimentToAdd) {
		condimentsInSandwich.add(condimentToAdd);
	}

	/**
	 * adds cheese to the sandwich
	 * @param addCheese: true if the sandwich includes cheese, false otherwise
	 */
	@Override
	public void addCheeseToFood(Cheese cheeseToAdd) {
		cheeseInSandwich.add(cheeseToAdd);
		costOfSandwich += 0.50;
	} 
	
	/**
	 * gets the price of the sandwich and all it's optional ingredients
	 * @return: the price of the sandwich in question, in USD
	 */
	@Override
	public double getPriceOfFoodItem() {
		return costOfSandwich;
	}

	/**
	 * says whether or not this food item is a sandwich 
	 * @return: always true for this sandwich subclass
	 */
	@Override
	public boolean isFoodItemASandwich() {
		return true;
	}
	
}
