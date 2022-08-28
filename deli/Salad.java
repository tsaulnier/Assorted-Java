package deli;

import java.util.*;

/**
 * a salad must have lettuce, and any additional meat or vegetables
 * it has a price depending on its ingredients
 * @author Thomas Saulnier
 */
public class Salad extends Food {

	private double costOfSalad; //cost of salad with all ingredients, never null, value >= 3.00, in USD
	private Collection<Meat> meatInSalad; //all the meat in the salad, never null, contains no nulls
	private Collection<Vegetable> vegetablesInSalad; //all the additional vegetables in the salad, never null, contains no nulls
	private Collection<Cheese> cheeseInSalad; //the cheese added to the salad, never null, contains no nulls
	
	public Salad() {
		costOfSalad = 3.00;
		meatInSalad = new ArrayList<>();
		cheeseInSalad = new ArrayList<>();
		
		vegetablesInSalad = new ArrayList<>();
		vegetablesInSalad.add(Vegetable.lettuce);
		
	}
	
	/**
	 * adds a meat to the salad
	 * @param meatToAdd: the meat to add to the salad, not null
	 */
	@Override
	public void addMeatToFood(Meat meatToAdd) {
		meatInSalad.add(meatToAdd);
		costOfSalad += 1.00;
	}

	/**
	 * adds a vegetable to the salad
	 * @param vegetableToAdd: the vegetable to add to the salad, not null, cannot add lettuce since a base salad already has lettuce
	 */
	@Override
	public void addVegetableToFood(Vegetable vegetableToAdd) {
		vegetablesInSalad.add(vegetableToAdd);
	}
	
	/**
	 * adds cheese to the salad
	 * @param addCheese: true if the salad includes cheese, false otherwise
	 */
	@Override
	public void addCheeseToFood(Cheese cheeseToAdd) {
		cheeseInSalad.add(cheeseToAdd);
		costOfSalad += 0.50;
	} 

	/**
	 * gets the price of the salad
	 */
	@Override
	public double getPriceOfFoodItem() {
		return costOfSalad;
	}

	/**
	 * says whether or not this food item is a sandwich 
	 * @return: always false for this salad subclass
	 */
	@Override
	public boolean isFoodItemASandwich() {
		return false;
	}
}
