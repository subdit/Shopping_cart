package cartSystemExample;

import java.io.IOException;
import java.util.Scanner;

public class MainEntryPoint {
	
	static Scanner reader = new Scanner(System.in);//static so methods out side of the main class can access if neccesarry.
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		AppSystem app = new AppSystem();
		CartSystem cart = new CartSystem();
		
		Integer choice = 0;
		while (choice != 7) {
			menu();
			try {
				
				choice = reader.nextInt();
				switch (choice) {
				case 1://add to System
					Item item = new Item();
					reader.nextLine();//this clears the end of line character so we can use one scanner for Strings and Integers
					System.out.print("\nEnter the item name:\n");
					item.setItemName(reader.nextLine());
					System.out.print("\nEnter a description for the item:\n");
					item.setItemDesc(reader.nextLine());
					System.out.print("\nEnter the item's price:\n");
					item.setItemPrice(reader.nextDouble());
					System.out.print("\nEnter the quantity available in the System:\n");
					item.setAvailableQuantity(reader.nextInt());
					System.out.println(item.getItemName());
					if (app.add(item)) {
						System.out.println("Item successfully added");
					} else {
						System.out.println("Try Again");
					}
					break;
				case 2://add to Cart
					app.display();
					System.out.println("Enter the name of the item");
					reader.nextLine();
					String item_name = reader.nextLine();
					System.out.println("What Quantity do you want to add");
					if (cart.add(app.getItemCollection().get(item_name), reader.nextInt())) {
						System.out.println("Item successfully added");
					} else {
						System.out.println("Please Try Again");
					}
					reader.nextLine();
					
					break;
				case 3://display cart
					cart.display();
					break;
				case 4://display the system
					app.display();
					break;
				case 5://remove item from cart completely
					cart.display();
					System.out.println("Enter the name of the item");
					reader.nextLine();
					item_name = reader.nextLine();
					if (cart.remove(item_name) != null) {
						System.out.println(item_name + " was removed from the cart");
					} else {
						System.out.println("Invalid Item, Please Try Again");
					}
					break;
				case 6://remove Item From System Completely
					app.display();
					System.out.println("Enter the name of the item");
					reader.nextLine();
					item_name = reader.nextLine();
					if (app.remove(item_name) != null) {
	
						System.out.println(item_name + " was removed from the System");
						//bonus remove item from cart as well
						if (cart.remove(item_name) != null) {
							System.out.println(item_name + " was also removed from the cart");
						}
					} else {
						System.out.println("Invalid Item, Please Try Again");
					}
	
					break;
				case 7://exit
					System.out.println("\nByyyeee!!");
					break;
				default://in case something aside from a number was input
					System.out.println("Number not in menu, please enter a number in the menu");					
					break;
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());//"Please enter a number on the menu");
				e.printStackTrace();
				reader.nextLine();
				continue;
			}
		}
		reader.close();
	}

	public static void menu() {
		System.out.println("\nChoose an action:");
		System.out.println("1. Add item to System");
		System.out.println("2. Add item to Cart");
		System.out.println("3. Display Cart");
		System.out.println("4. Display System");
		System.out.println("5. Remove item from Cart");
		System.out.println("6. Remove item from System");
		System.out.println("7. Quit");
	}
}
