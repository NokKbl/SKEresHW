

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Main class for user interface for a menu and ordering system,
 * using console interface.This class will display commands, menu items
 * and prices then let customer input command and orders and print
 * final order receipt when done.
 * 
 * @author Kunyaruk Katebunlu
 */
public class SKERestaurant {
	static Scanner scan = new Scanner(System.in);
	static String day ;
	static int[] quantities;
	static double[] result;
	static double total;
	static double subtotal = 0.00;
	static int orderNumber;
	static RestaurantManager rm;
	static private String[] menu;
	static private double[] price;
	static protected DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");
	static protected LocalDateTime now = LocalDateTime.now();
	
	public SKERestaurant(RestaurantManager rm){
		this.rm = rm;
	}
	
	/**
	 * Print list of available menu.
	 **/
	public static void printMenuList() {
		menu = rm.getMenuItems();
		price = rm.getPrices();
		
		System.out.println("\n>> Menu Items List <<");
		for (int n = 0; n <= menu.length - 1; n++) {
			System.out.printf("\t%2d. ", n + 1);
			for (int k = n; k <= n; k++) {
				System.out.printf("%-27s %6.2f Baht.\n", menu[k], price[k]);
			}
		}
	}
	
	/**
	 * Print all commands and some guide for change order's quantity.
	 **/
	public static void printCommands(){
		System.out.printf("\nPress :\t[ o ] --> Start order");
		System.out.printf("\n\t[ p ] --> Print latest order");
		System.out.printf("\n\t[ e ] --> Edit order\n");
		System.out.println("\t\t  (put ' - ' for reduce quantity)");
		System.out.printf("\t[ q ] --> Show reciept and Exit");
		System.out.printf("\n\t[ m ] --> Show menu list");
		System.out.printf("\n\t[ ? ] --> Show commands\n");
	}
	
	/**
	 * Print the list of available menu and commands.
	 **/
	public static void printCommandsAndMenu(){
		System.out.println("--------- Welcome to SKE Restaurant ---------");
		printCommands();
		printMenuList();
	}

	/**
	 * Get a day that the restaurant get an order to check some promotion.
	 * 
	 * @return the day that the customer make the order.
	 */
	public static String getDay() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		day = new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime());
		
		System.out.println("\n!! PROMOTION WARNING !! : >> Fri = 10% discount");
		System.out.println("\t\t\t  >> Weekend = 5% discount\n");
		if(day.equals("Fri")) System.out.println(">> Today is " + day + ", you got 10% discount.");
		else if(day.equals("Sat") || day.equals("Sun")) System.out.println(">> Today is " + day + ", you got 5% discount.");
		else System.out.println(">> Today is " + day + ", no discount available.");
		return day;
	}

	/**
	 * Require input for choice to get quantity/ to print total/ to end the
	 * program. (It depends on the choice that the customer choose.)
	 **/
	public static void recordOrder(int orderNumber) {
		int quantity = 0;
		price = rm.getPrices();
		quantities = new int[price.length];
		result = new double[price.length];

		while (true) {
			System.out.print("\nEnter your Command: ");
			String inChoice = scan.next();
			if (inChoice.equals("p")) {
				printOrder();
			}
			if (inChoice.equals("e") || inChoice.equals("o")) {
				while (true) {
					System.out.print("\nEnter menu item / Command: ");
					if (scan.hasNextInt()) {
						orderNumber = scan.nextInt();
						if (orderNumber >= 1 && orderNumber <= price.length) {
							System.out.print("Enter Quantity: ");
							quantity = scan.nextInt();
							for (int ch = 1; ch <= price.length; ch++) {
								if (orderNumber == ch) {
									quantities[ch - 1] = quantities[ch - 1] + quantity;
									if (quantities[ch - 1] < 0) {
										quantities[ch - 1] = 0;
									}
									result[ch - 1] = quantities[ch - 1] * price[ch - 1];
								}
							}
						}
					} else {
						inChoice = scan.next();
						if (inChoice.equals("p")) {
							printOrder();
							break;
						} else break;
					}
				}
			}
			if (inChoice.equals("m")) printMenuList();
			if (inChoice.equals("?")) printCommands();
			if (inChoice.equals("q")) {
				printReceipt();
				System.out.println("\n============= Thank you =============");
				break;
			}
		}
	}

	/**
	 * Print the latest version of customer's order.
	 */
	public static void printOrder() {
		menu = rm.getMenuItems();

		System.out.println("\n+--------------- Menu ---------------+-- Qty --+---- Price ----+");
		for (int k = 1; k <= result.length; k++) {
			if (quantities[k - 1] != 0 && quantities[k - 1] > 0) {
				System.out.printf("| %-35s|%7d  |%13.2f  |\n", menu[k - 1], quantities[k - 1], result[k - 1]);
			}
		}
		System.out.println("+------------------------------------+---------+---------------+");
	}

	/**
	 * Calculate VAT value of the customer order.
	 * 
	 * @param subtotal is the price before add any VAT or discount.
	 * @return VAT value
	 */
	public static double vat(double subtotal) {
		double vat = (subtotal * 7) / 100;
		return vat;
	}

	/**
	 * Print the latest version of customer's order.
	 */
	public static void printReceipt() {
		double vat, discount;

		System.out.println("\nDate & Time : " + dtf.format(now));
		printOrder();

		for (int c = 0; c < result.length; c++) subtotal = subtotal + result[c];
		if (day.equals("Fri")) discount = (subtotal * 10) / 100;
		else if (day.equals("Sat") || day.equals("Sun")) discount = (subtotal * 5) / 100;
		else discount = 0.00;
		vat = vat(subtotal);
		total = subtotal + vat - discount;

		System.out.printf("|%-46s|%13.2f  |\n", " Subtotal :", subtotal);
		if (discount != 0) {
			if (day.equals("Fri")) System.out.printf("|%-46s|%13.2f  |\n", " Friday discount (10%) :", discount);
			else System.out.printf("|%-46s|%13.2f  |\n", " Weekend discount (5%) :", discount);
		}
		System.out.printf("|%-46s|%13.2f  |\n", " VAT 7% :", vat);
		System.out.printf("|%-46s|%13.2f  |\n", " Total :", total);
		System.out.println("+----------------------------------------------+---------------+");
		
	}
	
	public static String getData(){
		String allOrder = "";
		for (int k = 1; k <= result.length; k++) {
			if (quantities[k - 1] != 0 && quantities[k - 1] > 0) {
				String Orders = menu[k - 1] + ", " + quantities[k - 1] + " @ " + result[k - 1] + "\n";
				allOrder = allOrder.concat(Orders);
			}
		}
		allOrder = allOrder.concat(String.format("Total : %.2f\n\n", total));
		return allOrder;
	}
	
	public static void getReceipt() throws IOException {
		String receipt = getData();
		String dateTime = dtf.format(now) + "\n";
		rm.writeToFile(dateTime, receipt);
	}

	public static void main(String[] args) throws IOException {
		rm.init();
		printCommandsAndMenu();
		getDay();
		recordOrder(orderNumber);
		getReceipt();
	}

}
