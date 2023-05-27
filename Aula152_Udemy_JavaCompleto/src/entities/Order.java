package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdfOrder = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sdfCliente = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private OrderStatus orderStatus;

	List<Client> cliente = new ArrayList<>();

	List<OrderItem> ordemItem = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus orderStatus) {
		this.moment = moment;
		this.orderStatus = orderStatus;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<Client> getCliente() {
		return cliente;
	}

	public List<OrderItem> getOrdemItem() {
		return ordemItem;
	}

	public void addCliente(Client client) {
		cliente.add(client);
	}

	public void addItem(OrderItem item) {
		ordemItem.add(item);
	}
	
	public void removeItem(OrderItem item) {
		ordemItem.remove(item);
	}

	public double total(List<OrderItem> ordemItem) {
		double soma = 0;
		for (int i = 0; i < ordemItem.size(); i++) {
			soma += ordemItem.get(i).getQuantity() * ordemItem.get(i).getPrice();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder texto = new StringBuilder();
		texto.append("\nORDER SUMMARY:\n");
		texto.append("Order moment: " + sdfOrder.format(moment) + "\n");
		texto.append("Order status: " + orderStatus + "\n");
		texto.append("Client: " + cliente.toString().replace("[", "").replace("]", ""));
		texto.append("\nOrder items:\n");
		for (int i = 0; i < ordemItem.size(); i++) {
			texto.append(ordemItem.get(i));
		}
		texto.append("Total price: $" + String.format("%.2f", total(ordemItem)));
		return texto.toString();
	}
}
