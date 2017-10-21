
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * User interface for a menu and ordering system, using console interface.
 * 
 * @author Kunyaruk Katebunlu
 */
public class RestaurantManager {
	static Scanner scan = new Scanner(System.in);
//	static ArrayList<String> menuItems = new ArrayList<>();
//	static ArrayList<Double> prices = new ArrayList<>();
//	static double[] quantities = new double[menuItems.size()];
//	static double[] choices = new double[menuItems.size()];
	static double total, subtotal = 0.00;
	static int orderNumber;
	static String day;

	static void loadMenu() {
		String menuFile = "data/menu.txt";
		ClassLoader loader = RestaurantManager.class.getClassLoader();

		InputStream in = loader.getResourceAsStream(menuFile);
		if (in == null) {
			System.out.println("Could not access file " + menuFile);
			return;
		}

		Scanner scanFile = new Scanner(in);

		while (scanFile.hasNextLine()) {
			String line = scanFile.nextLine();
			if (line.startsWith("#") || line.startsWith(" #") || line.equals("")) {
				continue;
			}

			String[] array = line.split("; ");
			menuItems.add(array[0]);
			prices.add(Double.parseDouble(array[1]));
		}
		scanFile.close();
	}
	
	public static String[] getMenuItems() {
		loadMenu();
		ArrayList<String> listMenu = menuItems;
		String[] items = listMenu.toArray(new String[listMenu.size()]);
		return items;
	}

	public static double[] getPrice() {
		ArrayList<Double> listPrice = prices;
		double[] menuPrice = new double[listPrice.size()];
		for (int i = 0; i < menuPrice.length; i++) {
			menuPrice[i] = listPrice.get(i);
		}
		return menuPrice;
	}

	/**
	 * Print the list of available menu, other choices, and some guide to change
	 * the quantity of the order.
	 **/
	public static void printMenuList() {
		String[] menu = getMenuItems();
		double[] price = getPrice();
		System.out.println("--------- Welcome to SKE Restaurant ---------");
		System.out.println("\n>> Menu Items List <<");
		for (int n = 0; n <= menu.length - 1; n++) {
			System.out.printf("\t%2d. ", n + 1);
			for (int k = n; k <= n; k++) {
				System.out.printf("%-27s %6.2f Baht.\n", menu[k], price[k]);
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

	static ArrayList<String> menuItems = new ArrayList<>();
	static ArrayList<Double> prices = new ArrayList<>();
	static double[] quantities = new double[menuItems.size()];
	static double[] choices = new double[menuItems.size()];
	/**
	 * Require input for choice to get quantity/ to print total/ to end the
	 * program. (It depends on the choice that the customer choose.)
	 **/
	public static void recordOrder(int orderNumber) {
		System.out.println(choices.length);
		int quantity = 0;
		double[] price = getPrice();
		quantities = new double[menuItems.size()];
		choices = new double[menuItems.size()];
		
		while (true) {
			System.out.print("\nEnter your Choice: ");
			if (scan.hasNextInt()) {
				orderNumber = scan.nextInt();
				if (orderNumber >= 1 && orderNumber <= menuItems.size()) {
					System.out.print("Enter Quantity: ");
					quantity = scan.nextInt();
					for (int ch = 1; ch <= price.length; ch++) {
						if (orderNumber == ch) {
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
					String[] menu = getMenuItems();
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");
					LocalDateTime now = LocalDateTime.now();

					System.out.println("\nDate & Time : " + dtf.format(now));
					System.out.println("\n+--------------- Menu ---------------+-- Qty --+---- Price ----+");
					for (int k = 1; k <= choices.length; k++) {
						if (quantities[k - 1] != 0 && quantities[k - 1] > 0) {
							System.out.printf("| %-35s|%7.0f  |%13.2f  |\n", menu[k - 1], quantities[k - 1], choices[k - 1]);
							subtotal = subtotal + choices[k - 1];
						}
					}
					computeOrderTotal(day);
					subtotal = 0.00;
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
			System.out.println("+------------------------------------+---------+---------------+");
			System.out.printf("|   SUPER GREAT FRIDAY :)                      |               |\n");
			System.out.printf("| Subtotal :                                   |%13.2f  |\n", subtotal);
			System.out.printf("| Discount 10%% :                               |%13.2f  |\n", discount);
			System.out.printf("| Vat 7%% :                                     |%13.2f  |\n", vat);
			System.out.printf("| Total :                                      |%13.2f  |\n", total);
			System.out.println("+----------------------------------------------+---------------+");
		} else if (day.equals("Sat") || day.equals("Sun")) {
			discount = (subtotal * 5) / 100;
			vat = vat(subtotal);
			total = subtotal + vat - discount;
			System.out.println("+------------------------------------+---------+---------------+");
			System.out.printf("|   REALLY DELICIOUS WEEKEND *[]*              |               |\n");
			System.out.printf("| Subtotal :                                   |%13.2f  |\n", subtotal);
			System.out.printf("| Discount 5%% :                                |%13.2f  |\n", discount);
			System.out.printf("| VAT 7%% :                                     |%13.2f  |\n", vat);
			System.out.printf("| Total :                                      |%13.2f  |\n", total);
			System.out.println("+----------------------------------------------+---------------+");
		} else {
			vat = vat(subtotal);
			total = subtotal + vat;
			System.out.println("+------------------------------------+---------+---------------+");
			System.out.printf("| Subtotal :                                   |%13.2f  |\n", subtotal);
			System.out.printf("| VAT 7%% :                                     |%13.2f  |\n", vat);
			System.out.printf("| Total :                                      |%13.2f  |\n", total);
			System.out.println("+----------------------------------------------+---------------+");
		}
	}

	public static void init() {
		printMenuList();
		getDay();
		recordOrder(orderNumber);
	}

	public static void main(String[] args) {
		RestaurantManager.init();
	}

}
