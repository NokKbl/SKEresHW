package Homework;

import java.util.Scanner;

public class ImproveSKErestaurant {

	static int quantity1, quantity2, quantity3, quantity4, quantity5, quantity6, quantity7, quantity8, quantity9, quantity10, quantity11, quantity12, quantity13;
	static int choice1, choice2, choice3, choice4, choice5, choice6, choice7, choice8, choice9, choice10, choice11, choice12, choice13;
	static int total;
	static String day;
	static Scanner scan = new Scanner(System.in);

	public static void printMenuList() {
		System.out.println("--------- Welcome to SKE Restaurant ---------");
		System.out.println("\n>> Menu List <<");
		System.out.println("\t1.) Pizza                    250 Baht.");
		System.out.println("\t2.) Chickens                 120 Baht.");
		System.out.println("\t3.) Ham Spaghetti            149 Baht.");
		System.out.println("\t4.) Sausage Chili Spaghetti  169 Baht.");
		System.out.println("\t5.) Garlic Bread              75 Baht.");
		System.out.println("\n>> Desserts <<");
		System.out.println("\t6.) SKE's Pizzokie (NEW!!)   109 Baht.");
		System.out.println("\t7.) Chocolate Lava Cake       75 Baht.");
		System.out.println("\t8.) Cosmic Brownies           75 Baht.");
		System.out.println("\t9.) Ice-Cream                 25 Baht.");
		System.out.println("\n>> Beverages <<");
		System.out.println("\t10.) Soft Drink               45 Baht.");
		System.out.println("\t11.) Juice                    45 Baht.");
		System.out.println("\t12.) Italian Soda             45 Baht.");
		System.out.println("\t13.) Water                    20 Baht.");
		System.out.println("\nNote : If you want to delete some order, you just");
		System.out.println("       put ' - ' before your new quantity.");
		System.out.println("\n>> 14.) Total");
		System.out.println(">> 15.) Exit");
	}

	public static String getDay(){
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
					if (choice == 1) {
						int pizza = 250;
						quantity1 = quantity1 + quantity;
						choice1 = pizza * quantity1;
					}
					if (choice == 2) {
						int chick = 120;
						quantity2 = quantity2 + quantity;
						choice2 = chick * quantity2;
					}
					if (choice == 3) {
						int ham = 149;
						quantity3 = quantity3 + quantity;
						choice3 = ham * quantity3;
					}
					if (choice == 4) {
						int sausage = 169;
						quantity4 = quantity4 + quantity;
						choice4 = sausage * quantity4;
					}
					if (choice == 5) {
						int bread = 75;
						quantity5 = quantity5 + quantity;
						choice5 = bread * quantity5;
					}
					if (choice == 6) {
						int pizzokie = 109;
						quantity6 = quantity6 + quantity;
						choice6 = pizzokie * quantity6;
					}
					if (choice == 7) {
						int choccake = 75;
						quantity7 = quantity7 + quantity;
						choice7 = choccake * quantity7;
					}
					if (choice == 8) {
						int brownies = 75;
						quantity8 = quantity8 + quantity;
						choice8 = brownies * quantity8;
					}
					if (choice == 9) {
						int icecream = 25;
						quantity9 = quantity9 + quantity;
						choice9 = icecream * quantity9;
					}
					if (choice == 10) {
						int soft_drink = 45;
						quantity10 = quantity10 + quantity;
						choice10 = soft_drink * quantity10;
					}
					if (choice == 11) {
						int juice = 45;
						quantity11 = quantity11 + quantity;
						choice11 = juice * quantity11;
					}
					if (choice == 12) {
						int italian_soda = 45;
						quantity12 = quantity12 + quantity;
						choice12 = italian_soda * quantity12;
					}
					if (choice == 13) {
						int water = 20;
						quantity13 = quantity13 + quantity;
						choice13 = water * quantity13;
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
		if (quantity1 != 0) {
			System.out.printf("| Pizza                    |%7d  |%9d  |\n", quantity1, choice1);
		}
		if (quantity2 != 0) {
			System.out.printf("| Chickens                 |%7d  |%9d  |\n", quantity2, choice2);
		}
		if (quantity3 != 0) {
			System.out.printf("| Ham Spaghetti            |%7d  |%9d  |\n", quantity3, choice3);
		}
		if (quantity4 != 0) {
			System.out.printf("| Sausage Chili Spaghetti  |%7d  |%9d  |\n", quantity4, choice4);
		}
		if (quantity5 != 0) {
			System.out.printf("| Garlic Bread             |%7d  |%9d  |\n", quantity5, choice5);
		}
		if (quantity6 != 0) {
			System.out.printf("| SKE's Pizzokie (NEW!!)   |%7d  |%9d  |\n", quantity6, choice6);
		}
		if (quantity7 != 0) {
			System.out.printf("| Chocolate Lava Cake      |%7d  |%9d  |\n", quantity7, choice7);
		}
		if (quantity8 != 0) {
			System.out.printf("| Cosmic Brownies          |%7d  |%9d  |\n", quantity8, choice8);
		}
		if (quantity9 != 0) {
			System.out.printf("| Ice-Cream                |%7d  |%9d  |\n", quantity9, choice9);
		}
		if (quantity10 != 0) {
			System.out.printf("| Soft Drink               |%7d  |%9d  |\n", quantity10, choice10);
		}
		if (quantity11 != 0) {
			System.out.printf("| Juice                    |%7d  |%9d  |\n", quantity11, choice11);
		}
		if (quantity12 != 0) {
			System.out.printf("| Italian Soda             |%7d  |%9d  |\n", quantity12, choice12);
		}
		if (quantity13 != 0) {
			System.out.printf("| Water                    |%7d  |%9d  |\n", quantity13, choice13);
		}
		computeOrderTotal();
		return total;
	}

	public static void computeOrderTotal() {
		int subtotal, vat, beforetotal, discount;
		if (day.equalsIgnoreCase("Fri")) {
			beforetotal = choice1 + choice2 + choice3 + choice4 + choice5 + choice6 + choice7 + choice8 + choice9 + choice10 + choice11 + choice12 + choice13;
			discount = (beforetotal * 10) / 100;
			vat = (beforetotal * 7) / 100;
			total = beforetotal + vat - discount;
			System.out.println("+--------------------------+---------+-----------+");
			System.out.printf("|   SUPER GREAT FRIDAY :)            |           |\n");
			System.out.printf("| Subtotal :                         |%9d  |\n", beforetotal);
			System.out.printf("| Discount 10%% :                     |%9d  |\n", discount);
			System.out.printf("| Vat 7%% :                           |%9d  |\n", vat);
			System.out.printf("| Total :                            |%9d  |\n", total);
			System.out.println("+------------------------------------+-----------+");
		} else if (day.equalsIgnoreCase("Sat") || day.equalsIgnoreCase("Sun")) {
			beforetotal = choice1 + choice2 + choice3 + choice4 + choice5 + choice6 + choice7 + choice8 + choice9 + choice10 + choice11 + choice12 + choice13;
			discount = (beforetotal * 5) / 100;
			vat = (beforetotal * 7) / 100;
			total = beforetotal + vat - discount;
			System.out.println("+--------------------------+---------+-----------+");
			System.out.printf("|   REALLY DELICIOUS WEEKEND *[]*    |           |\n");
			System.out.printf("| Subtotal :                         |%9d  |\n", beforetotal);
			System.out.printf("| Discount 5%% :                      |%9d  |\n", discount);
			System.out.printf("| Vat 7%% :                           |%9d  |\n", vat);
			System.out.printf("| Total :                            |%9d  |\n", total);
			System.out.println("+------------------------------------+-----------+");
		} else {
			subtotal = choice1 + choice2 + choice3 + choice4 + choice5 + choice6 + choice7 + choice8 + choice9 + choice10 + choice11 + choice12 + choice13;
			vat = (subtotal * 7) / 100;
			total = subtotal + vat;
			System.out.println("+--------------------------+---------+-----------+");
			System.out.printf("| Subtotal :                         |%9d  |\n", subtotal);
			System.out.printf("| Vat 7%% :                          |%9d  |\n", vat);
			System.out.printf("| Total :                            |%9d  |\n", total);
			System.out.println("+------------------------------------+-----------+");
		}
	}

	public static void beforeMain(){
		printMenuList();
		getDay();
		getReply();
	}
	
	public static void main(String[] args) {
		beforeMain();
	}

}