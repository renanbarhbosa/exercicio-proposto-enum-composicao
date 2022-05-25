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
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("enter client data:");
        System.out.print("name: ");
        String clientName = sc.nextLine();
        System.out.print("email: ");
        String clientEmail = sc.nextLine();
        System.out.print("birth date: (DD/MM/YYYY): ");
        Date clientBirthDate = sdf.parse(sc.next());
        Client clientOne = new Client(clientName, clientEmail, clientBirthDate);
        System.out.println("enter order data:");
        System.out.print("status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next()); // converte o valor de string para OrderStatus.
        Order order = new Order(new Date(), status, clientOne);
        System.out.print("how many items to this order? ");
        int numberOfOrders = sc.nextInt();
        for (int i = 0; i < numberOfOrders; i++) {
            System.out.println("enter product " + (i + 1) + " data: ");
            System.out.print("product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("quantity: ");
            int productQuantity = sc.nextInt();
            Product product = new Product(productName, productPrice);
            OrderItem it = new OrderItem(productQuantity, productPrice, product);
            order.additem(it);
        }
        System.out.println();
        System.out.println(order);
        sc.close();
    }

}
