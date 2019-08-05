package cartSystemExample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class CartSystem extends TheSystem{
    private Item amtToAdd1;



	public CartSystem() throws FileNotFoundException {
    	super();
	}
	 public void display() {

	        double subtotal = 0.00;
	        double tax = 0;
	        
	        HashMap<String, Item> currentItemList = getItemCollection();
	        Set<String> setOfKeys = currentItemList.keySet();
	        
	        for (String Keys : setOfKeys) {
	            System.out.println("Name: " + itemCollection.get(Keys).getItemName() + "; " +
	                                                        
	                                "Description: " +     itemCollection.get(Keys).getItemDesc() + "; " +
	                                "Price: " + itemCollection.get(Keys).getItemPrice() + "; " +
	                                "QuantityInCart: " + itemCollection.get(Keys).getQuantityInCart());
	            
	            subtotal += (itemCollection.get(Keys).getItemPrice() * itemCollection.get(Keys).getQuantityInCart());
	            tax  += (subtotal * 0.05);

	        }

	            System.out.println("----------------------------------");
	            System.out.println("Tax: $" + tax);

	            System.out.println("Subtotal: $" + subtotal);
	            double total = subtotal + tax;

	            System.out.println("Total: $" + total);
	    }


	    public boolean add(Item item, int amtToAdd) throws FileNotFoundException {

	        boolean isAvailable = checkAvailability(item, amtToAdd);

	        if (isAvailable) {
	            item.setAvailableQuantity(item.getAvailableQuantity() - amtToAdd);
	            item.setQuantityInCart(item.getQuantityInCart() + amtToAdd);

	            itemCollection.remove(item.getItemName());
	            itemCollection.put(item.getItemName(), item);
	        } 

	return true;
	    }
    	
    	
    
	 public Boolean checkAvailability(Item item, Integer amtToAdd) {
	        // Quantity in cart + wishlish should be fewer than available
	        boolean greedy = (item.getQuantityInCart() + amtToAdd) >= (item.getAvailableQuantity());

	        if (greedy) {
	            System.out.println(
	                    "Sorry, there are only " + item.getAvailableQuantity() + "available for " + item.getItemName());
	            return false;
	        } else {
	            return true;
	        }

	 }
}

