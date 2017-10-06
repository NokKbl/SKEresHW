package Homework;

/**
 * User interface for a menu and ordering system,
 * using console interface.
 * @author Kunyaruk Katebunlu
 */

import java.util.Scanner;

public class SKErestaurantArrays {
	static String[] menu = { "Pizza", "Chickens", "Ham Spaghetti", "Sausage Chili Spaghetti", "Garlic Bread",
			"SKE's Pizzokie", "Chocolate Lava Cake", "Cosmic Brownies", "Ice-Cream", "Soft Drink", "Juice",
			"Italian Soda", "Water" };
	static int[] price = { 250, 120, 149, 169, 75, 109, 75, 75, 25, 45, 45, 45, 20 };
	static int[] quantities = new int[13];
	static int[] choices = new int[13];
	static int subtotal = 0, total;
	static String day;
	static Scanner scan = new Scanner(System.in);

	public static void printMenuList() {
		System.out.println("--------- Welcome to SKE Restaurant ---------");
		System.out.println("\n>> Menu List <<");
		for (int n = 0; n <= 4; n++) {
			System.out.printf("\t%2d.) ", n + 1);
			for (int k = n; k <= n; k++) {
				System.out.printf("%-23s %4d Baht.\n", menu[k], price[k]);
			}
		}
		System.out.println(">> Desserts <<");
		for (int n = 5; n <= 8; n++) {
			System.out.printf("\t%2d.) ", n + 1);
			for (int k = n; k <= n; k++) {
				System.out.printf("%-23s %4d Baht.\n", menu[k], price[k]);
			}
		}
		System.out.println(">> Beverages <<");
		for (int n = 9; n <= 12; n++) {
			System.out.printf("\t%2d.) ", n + 1);
			for (int k = n; k <= n; k++) {
				System.out.printf("%-23s %4d Baht.\n", menu[k], price[k]);
			}
		}
		System.out.println("\nNote : If you want to delete some order, you just");
		System.out.println("       put ' - ' before your new quantity.");
		System.out.println("\n>> 14.) Total");
		System.out.println(">> 15.) Exit");
	}

	public static String getDay() {
		System.out.println("\n!! PROMOTION WARNING !! : >> FRI = 10% discount");
		System.out.println("                          >> Weekend = 5% discount");
		System.out.print("\nEnter a day (Mon, Tue, Wed, Thu, Fri, Sat, Sun): ");
		return day = scan.next();
	}

	public static void getReply() {
		int choice, quantity = 0;
		do {
			do {
				System.out.print("\nEnter your Choice: ");
				choice = scan.nextInt();
				if (choice >= 1 && choice <= 13) {
					System.out.print("Enter Quantity: ");
					quantity = scan.nextInt();
					for (int ch = 1; ch <= 14; ch++) {
						if (choice == ch) {
							for (int k = ch - 1; k <= ch - 1; k++) {
								quantities[k] = quantities[k] + quantity;
								choices[k] = quantities[k] * price[k];
							}
						}
					}
				}
			} while (choice >= 1 && choice <= 13);
			if (choice == 14) {
				printTotal(choice, quantity);
			}
		} while (choice != 15);
		System.out.println("\n===== Thank you =====");
	}

	public static int printTotal(int choice, int quantity) {
		System.out.println("+---------- Menu ----------+-- Qty --+-- Price --+");
		for (int k = 1; k <= 13; k++) {
			if (quantities[k - 1] != 0) {
				System.out.printf("| %-25s|%7d  |%9d  |\n", menu[k - 1], quantities[k - 1], choices[k - 1]);
				subtotal = subtotal + choices[k - 1];
			}
		}
		computeOrderTotal();
		subtotal = 0;
		return total;
	}

	public static void computeOrderTotal() {
		int vat, discount;
		if (day.equalsIgnoreCase("Fri")) {
			discount = (subtotal * 10) / 100;
			vat = (subtotal * 7) / 100;
			total = subtotal + vat - discount;
			System.out.println("+--------------------------+---------+-----------+");
			System.out.printf("|   SUPER GREAT FRIDAY :)            |           |\n");
			System.out.printf("| Subtotal :                         |%9d  |\n", subtotal);
			System.out.printf("| Discount 10%% :                     |%9d  |\n", discount);
			System.out.printf("| Vat 7%% :                           |%9d  |\n", vat);
			System.out.printf("| Total :                            |%9d  |\n", total);
			System.out.println("+------------------------------------+-----------+");
		} else if (day.equalsIgnoreCase("Sat") || day.equalsIgnoreCase("Sun")) {
			discount = (subtotal * 5) / 100;
			vat = (subtotal * 7) / 100;
			total = subtotal + vat - discount;
			System.out.println("+--------------------------+---------+-----------+");
			System.out.printf("|   REALLY DELICIOUS WEEKEND *[]*    |           |\n");
			System.out.printf("| Subtotal :                         |%9d  |\n", subtotal);
			System.out.printf("| Discount 5%% :                      |%9d  |\n", discount);
			System.out.printf("| Vat 7%% :                           |%9d  |\n", vat);
			System.out.printf("| Total :                            |%9d  |\n", total);
			System.out.println("+------------------------------------+-----------+");
		} else {
			vat = (subtotal * 7) / 100;
			total = subtotal + vat;
			System.out.println("+--------------------------+---------+-----------+");
			System.out.printf("| Subtotal :                         |%9d  |\n", subtotal);
			System.out.printf("| Vat 7%% :                          |%9d  |\n", vat);
			System.out.printf("| Total :                            |%9d  |\n", total);
			System.out.println("+------------------------------------+-----------+");
		}
	}

	public static void beforeMain() {
		printMenuList();
		getDay();
		getReply();
	}

	public static void main(String[] args) {
		beforeMain();
	}

}
