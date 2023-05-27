package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);

		Scanner teclado = new Scanner(System.in);
		Date dataHoraSistema = new Date();
		SimpleDateFormat sdfCliente = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfOrder = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataHoraFormatada = sdfOrder.format(dataHoraSistema);

		System.out.println("ENTER CLIENTE DATA");
		System.out.print("Name: ");
		String nomeCliente = teclado.nextLine();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Birth date: ");
		String birthDate = teclado.next();
		System.out.println("ENTER ORDER DATA:");
		Client cliente = new Client(nomeCliente, email, sdfCliente.parse(birthDate));

		System.out.print("Status: ");
		String status = teclado.next();
		Order ordem = new Order(sdfOrder.parse(dataHoraFormatada), OrderStatus.valueOf(status));

		ordem.addCliente(cliente);

		System.out.print("How many items to this order? ");
		int totalItens = teclado.nextInt();
		for (int i = 1; i <= totalItens; i++) {

			System.out.println("ENTER #" + i + " ITEM DATA:");
			System.out.print("Product name: ");
			String productName = teclado.next();
			System.out.print("Product price: ");
			double productPrice = teclado.nextDouble();
			System.out.print("Quantity: ");
			int quantity = teclado.nextInt();

			Product product = new Product(productName, productPrice);

			OrderItem ordemItem = new OrderItem(quantity, product.getPrice());

			ordemItem.addProduct(product);
			ordem.addItem(ordemItem);
		}

		System.out.println(ordem);

		teclado.close();
	}
	/*
		
		//-----------------------------------------------------------\\ 
						//                       \\ 
						// Dados já instanciados  \\
						//                        \\
		//------------------------------------------------------------\\
		  

		Locale.setDefault(Locale.US);

		Scanner teclado = new Scanner(System.in);
		Date dataHoraSistema = new Date();
		SimpleDateFormat sdfCliente = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfOrder = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataHoraFormatada = sdfOrder.format(dataHoraSistema);

		Client cliente1 = new Client("Arnailton Brito", "nana@mail.com", sdfCliente.parse("18/10/1988"));

		System.out.print("Status: ");
		Order ordem = new Order(sdfOrder.parse(dataHoraFormatada), OrderStatus.PROCESSING);

		ordem.addCliente(cliente1);

		// Product 1

		Product product1 = new Product("TV", 1000.00);

		OrderItem ordemItem1 = new OrderItem(2, product1.getPrice());

		ordemItem1.addProduct(product1);
		ordem.addItem(ordemItem1);

		// Product 2

		Product product2 = new Product("Mouse", 40.25);

		OrderItem ordemItem2 = new OrderItem(6, product2.getPrice());

		ordemItem2.addProduct(product2);
		ordem.addItem(ordemItem2);

		// Product 3

		Product product3 = new Product("Teclado", 70.36);

		OrderItem ordemItem3 = new OrderItem(3, product3.getPrice());

		ordemItem3.addProduct(product3);
		ordem.addItem(ordemItem3);

		// Product 4

		Product product4 = new Product("Monitor", 570.53);

		OrderItem ordemItem4 = new OrderItem(2, product4.getPrice());

		ordemItem4.addProduct(product4);
		ordem.addItem(ordemItem4);

		// Product 5
		Product product5 = new Product("Caneta", 10.20);

		OrderItem ordemItem5 = new OrderItem(5, product5.getPrice());

		ordemItem5.addProduct(product5);
		ordem.addItem(ordemItem5);

		System.out.println(ordem);

		teclado.close();
		
	}
	*/

}
