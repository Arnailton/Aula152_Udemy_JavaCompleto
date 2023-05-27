package entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
	private int quantity;
	private double price;

	List<Product> product = new ArrayList<>();

	public OrderItem() {
	}

	public OrderItem(int quantity, double price) {
		this.quantity = quantity;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double subTotal(int quantity, double priceOrdemItem) {
		double sub = quantity * priceOrdemItem;
		return sub;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void addProduct(Product products) {
		product.add(products);
	}

	@Override
	public String toString() {
		StringBuilder texto = new StringBuilder();
		texto.append(product.toString().replace("[", "").replace("]", "")+ ", ");
		texto.append("Quantity: " + quantity + ", ");
		texto.append("Subtotal: $" + String.format("%.2f", subTotal(quantity, getPrice())) + "\n");
		return texto.toString();
	}
}
