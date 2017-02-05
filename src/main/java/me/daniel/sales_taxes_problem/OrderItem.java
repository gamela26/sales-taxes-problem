package me.daniel.sales_taxes_problem;

public class OrderItem {

	private final Integer quantity;
	private final Product product;
	
	public OrderItem(Integer quantity, Product product){
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder("");
		str.append(this.quantity);
		str.append(" " + this.product.getName() +" at ");
		str.append(this.product.getPrice());
		
		return str.toString();
	}
	
	@Override
    public boolean equals(Object o) {

        if (o == this){
        	return true;
        }
        
        if (!(o instanceof OrderItem)) {
            return false;
        }

        OrderItem orderItem = (OrderItem) o;

        return this.quantity.equals(orderItem.quantity) &&
        	   this.product.equals(orderItem.product);
	}
	
}
