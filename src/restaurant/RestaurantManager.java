package restaurant;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * System for manager to get the menu list and price list.
 * 
 * @author Kunyaruk Katebunlu
 */
public class RestaurantManager {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> menuItems = new ArrayList<>();
	static ArrayList<Double> prices = new ArrayList<>();
	private static String menuFile = "data/menu.txt";

	static void setMenu() {
		String filename = menuFile;
		ClassLoader loader = RestaurantManager.class.getClassLoader();

		InputStream in = loader.getResourceAsStream(filename);
		if (in == null) {
			System.out.println("Could not access file " + filename);
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

}
