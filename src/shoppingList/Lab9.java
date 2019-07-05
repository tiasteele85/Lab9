package shoppingList;

import java.util.*;

public class Lab9 {

	public static void main(String[] args) {

		// Variables
		Scanner in = new Scanner(System.in);// object to store user input
		HashMap<String, Double> shopList = new HashMap<>();// hashMap to display list to user
		ArrayList<String> items = new ArrayList<>(); // arrayList to record user groceries
		ArrayList<Double> cost = new ArrayList<>(); // arrayList to store the prices of the groceries
		String flare = "========================================";
		char choice = 'Y';// store user choice to continue the program

		// Get predefined shopping list of inventory and costing
		shopList = makeMyInventory();

		do {
			// standard printing format for displaying shopList
			System.out.printf("%-20s %-20s\n", "Item", "Price");
			System.out.println(flare);
			for (Map.Entry<String, Double> showMe : shopList.entrySet()) {
				System.out.printf("%-20s $%-20s\n", showMe.getKey(), showMe.getValue());
			}

			System.out.println("What item would you like to order?");
			String item = in.nextLine();
			if (shopList.containsKey(item)) {
				items.add(item);
				cost.add(shopList.get(item));
				System.out.println("Adding " + item + " to cart at $" + shopList.get(item));
			} else {
				System.out.println("Sorry, we don't have those.  Please try again.\n");
				continue;
			}

			

			// Prompt user to continue the program
			System.out.println("Would you like to order anything else? (y/n)");
			choice = in.next().toUpperCase().charAt(0);
			
			//Force user to choose words be yes or no
			while(choice != 'Y' & choice != 'N') {
				System.out.println("Invalid Option. Please try again.");
				System.out.println("Would you like to order anything else? (y/n)");
				in.nextLine();//clear scanner object
				choice = in.next().toUpperCase().charAt(0);
				
			}
			
			in.nextLine(); // clear scanner object

		} while (choice == 'Y');

		// display the end results
		System.out.println("Thank you for shopping with us!");
		System.out.println("Here is what you ordered:");
		for (int i = 0; i < items.size(); i++) {

			System.out.printf("%-20s $%-20s\n", items.get(i), cost.get(i));
		}
		System.out.printf("Average price per item in order was $%.2f\n", averageCost(cost));
		System.out.printf("Highest price item was $%.2f\n", highestCost(cost));
		System.out.printf("Lowest price item was $%.2f\n", lowestCost(cost));
	}

	public static HashMap<String, Double> makeMyInventory() {

		HashMap<String, Double> storeInventory = new HashMap<>();

		// create inventory of items and prices
		storeInventory.put("apple", .99);
		storeInventory.put("banana", .59);
		storeInventory.put("cauliflower", 1.59);
		storeInventory.put("dragonfruit", 2.19);
		storeInventory.put("Elderberry", 1.79);
		storeInventory.put("figs", 2.09);
		storeInventory.put("grapefruit", 1.99);
		storeInventory.put("honeydew", 3.49);

		// return the inventory defined
		return storeInventory;

	}

	public static double averageCost(ArrayList<Double> cost) {

		double sum = 0;

		for (double price : cost) {
			sum += price;
		}

		return sum / (double) cost.size();
	}

	// Method to find the highest cost item by sorting a copy o the arraylist
	// copy created to eliminate altering the original arraylist
	public static double highestCost(ArrayList<Double> cost) {

		ArrayList<Double> temp = new ArrayList<>();
		for (double copy : cost) {
			temp.add(copy);
		}
		Collections.sort(temp);
		return temp.get(cost.size() - 1);
	}

	// Method to find the lowest cost item by sorting a copy of the arraylist
	// copy created to eliminate altering the original arraylist
	public static double lowestCost(ArrayList<Double> cost) {

		ArrayList<Double> temp = new ArrayList<>();
		for (double copy : cost) {
			temp.add(copy);
		}
		Collections.sort(temp);
		return temp.get(0);
	}
}
