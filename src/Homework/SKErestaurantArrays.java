package Homework;


import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * User interface for a menu and ordering system, using console interface.
 * 
 * @author Kunyaruk Katebunlu
 */

public class SKErestaurantArrays {
	static String[] menu = { "Pizza", "Chickens", "Ham Spaghetti", "Caesar Salad", "Garlic Bread", "SKE's Pizzokie",
			"Chocolate Lava Cake", "Ice-Cream", "Soft Drink", "Juice", "Italian Soda", "Water" };
	static double[] price = { 250, 120, 149, 129, 79, 109, 75, 25, 45, 45, 45, 20 };
	static double[] quantities = new double[menu.length];
	static double[] choices = new double[menu.length];
	static double total, subtotal = 0.00;
	static String day;
	static Scanner scan = new Scanner(System.in);

	/**
	 * Print the list of available menu, other choices, and some guide to change
	 * the quantity of the order.
	 **/
	public static void printMenuList() {
		System.out.println("--------- Welcome to SKE Restaurant ---------");
		System.out.println("\n>> Menu Items List <<");
		for (int n = 0; n <= menu.length - 1; n++) {
			System.out.printf("\t%2d. ", n + 1);
			for (int k = n; k <= n; k++) {
				System.out.printf("%-23s %6.2f Baht.\n", menu[k], price[k]);
			}
		}
		System.out.println("\nNote : If you want to reduce the order quantity,");
		System.out.println("        put ' - ' before your new quantity.");
		System.out.printf("\n>> [p] Get total order");
		System.out.printf("\n>> [q] Exit\n");
	}

	/**
	 * Ask for input of a day that the restaurant get an order to check some
	 * promotion.
	 * 
	 * @return the day that the customer make the order.
	 */
	public static String getDay() {
		System.out.println("\n!! PROMOTION WARNING !! : >> Fri = 10% discount");
		System.out.println("                          >> Weekend = 5% discount");
		System.out.print("\nEnter a day (Mon, Tue, Wed, Thu, Fri, Sat, Sun): ");
		day = scan.next();
		while (day != null) {
			switch (day) {
			case "Mon":
			case "Tue":
			case "Wed":
			case "Thu":
			case "Fri":
			case "Sat":
			case "Sun":
				return day;
			default:
				System.out.print("\nEnter a day (Mon, Tue, Wed, Thu, Fri, Sat, Sun): ");
				day = scan.next();
				break;
			}
		}
		return day;
	}

	/**
	 * Require input for choice to get quantity/ to print total/ to end the
	 * program. (It depends on the choice that the customer choose.)
	 **/
	public static void getOrderReply() {
		int quantity = 0;
		while (true) {
			System.out.print("\nEnter your Choice: ");
			if (scan.hasNextInt()) {
				int choice = scan.nextInt();
				if (choice >= 1 && choice <= menu.length) {
					System.out.print("Enter Quantity: ");
					quantity = scan.nextInt();
					for (int ch = 1; ch <= price.length; ch++) {
						if (choice == ch) {
							quantities[ch - 1] = quantities[ch - 1] + quantity;
							if (quantities[ch - 1] < 0) {
								quantities[ch - 1] = 0;
							}
							choices[ch - 1] = quantities[ch - 1] * price[ch - 1];
						}
					}
				}
			} else {
				String inChoice = scan.next();
				if (inChoice.equals("p")) {
					printTotal(choices, quantities);
				}
				if (inChoice.equals("q")) {
					System.out.println("\n===== Thank you =====");
					break;
				}
			}
		}
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
	 * Print subtotal value, discount value, vat value and calculate the total
	 * price value.
	 * 
	 * @param day is the day that the customer make the order.
	 */
	public static void computeOrderTotal(String day) {
		double vat, discount;
		if (day.equals("Fri")) {
			discount = (subtotal * 10) / 100;
			vat = vat(subtotal);
			total = subtotal + vat - discount;
			System.out.println("+--------------------------+---------+-----------+");
			System.out.printf("|   SUPER GREAT FRIDAY :)            |           |\n");
			System.out.printf("| Subtotal :                         |%9.2f  |\n", subtotal);
			System.out.printf("| Discount 10%% :                     |%9.2f  |\n", discount);
			System.out.printf("| Vat 7%% :                           |%9.2f  |\n", vat);
			System.out.printf("| Total :                            |%9.2f  |\n", total);
			System.out.println("+------------------------------------+-----------+");
		} else if (day.equals("Sat") || day.equals("Sun")) {
			discount = (subtotal * 5) / 100;
			vat = vat(subtotal);
			total = subtotal + vat - discount;
			System.out.println("+--------------------------+---------+-----------+");
			System.out.printf("|   REALLY DELICIOUS WEEKEND *[]*    |           |\n");
			System.out.printf("| Subtotal :                         |%9.2f  |\n", subtotal);
			System.out.printf("| Discount 5%% :                      |%9.2f  |\n", discount);
			System.out.printf("| VAT 7%% :                           |%9.2f  |\n", vat);
			System.out.printf("| Total :                            |%9.2f  |\n", total);
			System.out.println("+------------------------------------+-----------+");
		} else {
			vat = vat(subtotal);
			total = subtotal + vat;
			System.out.println("+--------------------------+---------+-----------+");
			System.out.printf("| Subtotal :                         |%9.2f  |\n", subtotal);
			System.out.printf("| VAT 7%% :                           |%9.2f  |\n", vat);
			System.out.printf("| Total :                            |%9.2f  |\n", total);
			System.out.println("+------------------------------------+-----------+");
		}
	}

	/**
	 * Print all details of the customer's order (Like a receipt from common
	 * restaurant), one menu details per line.
	 * 
	 * @param choices is the set of the items data that customer order.
	 * @param quantities is the set of the quantity data that customer input.
	 * @return total price of the order
	 */
	public static double printTotal(double[] choices, double[] quantities) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");
		LocalDateTime now = LocalDateTime.now();

		System.out.println("\nDate & Time : " + dtf.format(now));
		System.out.println("\n+---------- Menu ----------+-- Qty --+-- Price --+");
		for (int k = 1; k <= menu.length; k++) {
			if (quantities[k - 1] != 0 && quantities[k - 1] > 0) {
				System.out.printf("| %-25s|%7.0f  |%9.2f  |\n", menu[k - 1], quantities[k - 1], choices[k - 1]);
				subtotal = subtotal + choices[k - 1];
			}
		}
		computeOrderTotal(day);
		subtotal = 0.00;
		return total;
	}

	public static void beforeMain() {
		printMenuList();
		getDay();
		getOrderReply();
	}

	public static void main(String[] args) {
		beforeMain();
	}

}
