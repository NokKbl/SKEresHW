

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * System for manager to get the menu list, price list and record order to file.
 * 
 * @author Kunyaruk Katebunlu
 */
public class RestaurantManager {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> menuItems = new ArrayList<>();
	static ArrayList<Double> prices = new ArrayList<>();
	static final String menuFile = "data/menu.txt";
	static final String writeOrder = "src/data/writeOrder.txt";
	
	/**
	 * Read the data (menu and price) from file and add those data to list.
	 */
	static void init(){
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
	
	/**
	 * Write the data (include date, time, menu, quantity, price and total) into a file.
	 * 
	 * @param dayTime is date and time when customer get the receipt.
	 * @param allOrder is all order that customer ordered and total price of the order.
	 * @throws IOException when file cannot be opened.
	 */
	static void writeToFile(String dayTime, String allOrder) throws IOException{
		  File output = new File(writeOrder);
		  FileOutputStream out;
		  try {
		      out = new FileOutputStream(output, true);
		      out.write(dayTime.getBytes());	
		      out.write(allOrder.getBytes());
		  } catch (FileNotFoundException ex) {
		      System.out.println("Couldn't open output file " + output);
		      return;
		  }
		  out.close();
	}
	
	/**
	 * To change array list of menu items into array
	 * 
	 * @return array of menu items
	 */
	public static String[] getMenuItems() {
		ArrayList<String> listMenu = menuItems;
		String[] items = listMenu.toArray(new String[listMenu.size()]);
		return items;
	}

	/**
	 * To change array list of prices into array
	 * 
	 * @return array of prices
	 */
	public static double[] getPrices() {
		ArrayList<Double> listPrice = prices;
		double[] menuPrice = new double[listPrice.size()];
		for (int i = 0; i < menuPrice.length; i++) {
			menuPrice[i] = listPrice.get(i);
		}
		return menuPrice;
	}

}
