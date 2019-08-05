package cartSystemExample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class TheSystem {
	protected HashMap<String, Item> itemCollection;

	protected TheSystem() throws FileNotFoundException {
		itemCollection = new HashMap<String, Item>();
		
		}

	public HashMap<String, Item> getItemCollection() {
		//Fill Out Code
		// New hashMap 
		HashMap<String, Item> result = new HashMap<String, Item>();
		result.putAll(itemCollection);
		return result;
		
	}

	public void setItemCollection(HashMap<String, Item> newItemCollection) {
		//Fill Out Code
		// set the newItemCollection to ItemCollection 
		newItemCollection = itemCollection;
	}

	 public Boolean add(Item item) {
	        // takes Item object as a parameter and 
	        // checks if the item is already in the system. 
	            
	        // if found in sample.txt
	        if(itemCollection.containsKey(item)) {
	            System.out.println(item + " is already in the system");
	            return false;
	        } else {
	            // if not found add the item to hashMap
	            itemCollection.put(item.getItemName(), item);    
	            return true;
	        }
	    
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

	 public String remove(String itemName) {

	        // item to be removed. First it checks if the item 
	        if (itemCollection.containsKey(itemName)) {
	            itemCollection.remove(itemName)    ;    
	            
	            return itemName;
	        } else 
	            return null;
	    }
	
//    public Item remove(Item item_Name) {
//
//        // item to be removed. First it checks if the item 
//        if (itemCollection.containsKey(item_Name)) {
//            itemCollection.remove(item_Name)    ;   
//            
//            return item_Name;
//        } else 
//            return null;
//    }
}