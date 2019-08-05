package cartSystemExample;

public class Item{
    private String itemName;
    private String itemDesc;
    private Double itemPrice;
    private Integer quantityInCart;
    private Integer availableQuantity;
    

	public String getItemName() {
		
		return itemName;
	}

	
	public Item(String itemName, String itemDesc, Double itemPrice, Integer availableQuantity) {
		super();
		quantityInCart = 0 ;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
		this.availableQuantity = availableQuantity;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getQuantityInCart() {
		return quantityInCart;
	}

	public void setQuantityInCart(Integer quantityInCart) {
		this.quantityInCart = quantityInCart;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Item() {
		quantityInCart = 0;
	}
}
