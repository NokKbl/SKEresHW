package Homework;
import java.util.Scanner;
public class SKErestaurant {

			static int qt1, qt2, qt3, qt4, qt5, qt6, qt7, qt8, qt9, qt10, qt11, qt12, qt13;
			static int cq1, cq2, cq3, cq4, cq5, cq6, cq7, cq8, cq9, cq10, cq11, cq12, cq13;
			static int subtotal, vat, total, before, dis, after;
			static String day;
			static Scanner scan = new Scanner(System.in);
			public static int total14(int choice, int qty) {
				System.out.println("+---------- Menu ----------+-- Qty --+-- Price --+");
				if (qt1 != 0) {
					System.out.printf("| Pizza                    |%7d  |%9d  |\n", qt1, cq1);
				}
				if (qt2 !=0) {
					System.out.printf("| Chickens                 |%7d  |%9d  |\n", qt2, cq2);
				}
				if (qt3 != 0) {
					System.out.printf("| Ham Spaghetti            |%7d  |%9d  |\n", qt3, cq3);
				}
				if (qt4 != 0) {
					System.out.printf("| Sausage Chili Spaghetti  |%7d  |%9d  |\n", qt4, cq4);
				}
				if (qt5 !=0) {
					System.out.printf("| Garlic Bread             |%7d  |%9d  |\n", qt5, cq5);
				}
				if (qt6 != 0) {
					System.out.printf("| SKE's Pizzokie (NEW!!)   |%7d  |%9d  |\n", qt6, cq6);
				}
				if (qt7 != 0) {
					System.out.printf("| Chocolate Lava Cake      |%7d  |%9d  |\n", qt7, cq7);
				}
				if (qt8 !=0) {
					System.out.printf("| Cosmic Brownies          |%7d  |%9d  |\n", qt8, cq8);
				}
				if (qt9 != 0) {
					System.out.printf("| Ice-Cream                |%7d  |%9d  |\n", qt9, cq9);
				}
				if (qt10 != 0) {
					System.out.printf("| Soft Drink               |%7d  |%9d  |\n", qt10, cq10);
				}
				if (qt11 !=0) {
					System.out.printf("| Juice                    |%7d  |%9d  |\n", qt11, cq11);
				}
				if (qt12 != 0) {
					System.out.printf("| Italian Soda             |%7d  |%9d  |\n", qt12, cq12);
				}
				if (qt13 != 0) {
					System.out.printf("| Water                    |%7d  |%9d  |\n", qt13, cq13);
				}
				totalt();
				return total;
			}
			public static void totalt(){
				if (day.equalsIgnoreCase("Fri")){
					before = cq1+cq2+cq3+cq4+cq5+cq6+cq7+cq8+cq9+cq10+cq11+cq12+cq13;
					dis = (before*10)/100;
					vat = (before*7)/100;
					total= before+vat-dis;
					System.out.println("+--------------------------+---------+-----------+");
					System.out.printf("|   SUPER GREAT FRIDAY :)            |           |\n");
					System.out.printf("| Subtotal :                         |%9d  |\n", before);
					System.out.printf("| Discount 10%% :                     |%9d  |\n", dis);
					System.out.printf("| Vat 7%% :                           |%9d  |\n", vat);
					System.out.printf("| Total :                            |%9d  |\n", total);
					System.out.println("+------------------------------------+-----------+");
				}else if (day.equalsIgnoreCase("Sat") || day.equalsIgnoreCase("Sun")){
					before = cq1+cq2+cq3+cq4+cq5+cq6+cq7+cq8+cq9+cq10+cq11+cq12+cq13;
					dis = (before*5)/100;
					vat = (before*7)/100;
					total= before+vat-dis;
					System.out.println("+--------------------------+---------+-----------+");
					System.out.printf("|   REALLY DELICIOUS WEEKEND *[]*    |           |\n");
					System.out.printf("| Subtotal :                         |%9d  |\n", before);
					System.out.printf("| Discount 5%% :                      |%9d  |\n", dis);
					System.out.printf("| Vat 7%% :                           |%9d  |\n", vat);
					System.out.printf("| Total :                            |%9d  |\n", total);
					System.out.println("+------------------------------------+-----------+");
				}else{
					subtotal = cq1+cq2+cq3+cq4+cq5+cq6+cq7+cq8+cq9+cq10+cq11+cq12+cq13;
					vat = (subtotal*7)/100;
					total= subtotal+vat;
					System.out.println("+--------------------------+---------+-----------+");
					System.out.printf("| Subtotal :                         |%9d  |\n", subtotal);
					System.out.printf("| Vat 7%% :                          |%9d  |\n", vat);
					System.out.printf("| Total :                            |%9d  |\n", total);
					System.out.println("+------------------------------------+-----------+");
				}
			}
			public static void menuList(){
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
			public static void choices(){
				int choice, qty=0;
				do {
						do {
						System.out.print("\nEnter your Choice: ");
						choice = scan.nextInt();
						if (choice >= 1 && choice <= 13) {
							System.out.print("Enter Quantity: ");
							qty = scan.nextInt();
							if (choice == 1) {
								qt1 = qt1+qty;
								cq1 = 250 * qt1;
							}
							if (choice == 2) {
								qt2 = qt2+qty;
								cq2 = 120 * qt2;
							}
							if (choice == 3) {
								qt3 = qt3+qty;
								cq3 = 149 * qt3;
							}
							if (choice == 4) {
								qt4 = qt4+qty;
								cq4 = 169 * qt4;
							}
							if (choice == 5) {
								qt5 = qt5+qty;
								cq5 = 75 * qt5;
							}
							if (choice == 6) {
								qt6 = qt6+qty;
								cq6 = 109 * qt6;
							}
							if (choice == 7) {
								qt7 = qt7+qty;
								cq7 = 75 * qt7;
							}
							if (choice == 8) {
								qt8 = qt8+qty;
								cq8 = 75 * qt8;
							}
							if (choice == 9) {
								qt9 = qt9+qty;
								cq9 = 25 * qt9;
							}
							if (choice == 10) {
								qt10 = qt10+qty;
								cq10 = 45 * qt10;
							}
							if (choice == 11) {
								qt11 = qt11+qty;
								cq11 = 45 * qt11;
							}
							if (choice == 12) {
								qt12 = qt12+qty;
								cq12 = 45 * qt12;
							}
							if (choice == 13) {
								qt13 = qt13+qty;
								cq13 = 20 * qt13;
							}
						}
					} while (choice >= 1 && choice <= 13);
					if (choice == 14) {
						total14(choice, qty);
					}
				} while (choice != 15);
				System.out.println("\n===== Thank you =====");
			}
			public static void main(String[] args) {
				menuList();
				System.out.println("\n!! PROMOTION WARNING !! : >> FRI = 10% discount");
				System.out.println("                          >> Weekend = 5% discount");
				
				System.out.print("\nEnter a day (Mon, Tue, Wed, Thu, Fri, Sat, Sun): ");
				day = scan.next();
				choices();
	}

}
