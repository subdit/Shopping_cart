package cartSystemExample;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class AppSystem extends TheSystem {
    public AppSystem() throws NumberFormatException, IOException {
        super();//call TheSystem constructor
        
            try {
                String line;
                BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
                while ((line = reader.readLine()) != null) {
                    String[] lines = line.split("  ");

                    String itemName = lines[0];
                    String itemDesc = lines[1];
                    double itemPrice = Double.parseDouble(lines[2]);
                    Integer availableQuantity = Integer.parseInt(lines[3]);

                    Item something = new Item(itemName, itemDesc, itemPrice, availableQuantity);
                    itemCollection.put(itemName, something);
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }         
    
    }
    			

	public void display() {
		// display all item in the AppSystem.
		HashMap<String, Item> currentItemList = getItemCollection();
		
		// Set variable for keys from hashMap
		Set<String> setOfKeys = currentItemList.keySet();

		// for each key, get my elements of hashMap 
		for (String Keys : setOfKeys) {
			System.out.println("Product name: " + itemCollection.get(Keys).getItemName() + "; " +
														
								"Details: " + 	itemCollection.get(Keys).getItemDesc() + "; " +
								"Price: " + itemCollection.get(Keys).getItemPrice() + "; " +
								"Available Amount: " + itemCollection.get(Keys).getAvailableQuantity());
		}
	}
    
}