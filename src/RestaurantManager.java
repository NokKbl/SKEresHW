

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
	static private String[] menuItems;
	static private double[] prices;
	static final String menuFile = "data/menu.txt";
	static final String writeOrder = "data/writeOrder.txt";
	
	/**
	 * Read the data (menu and price) from file and add those data to list.
	 */
	static void init(){
		ClassLoader loader = RestaurantManager.class.getClassLoader();
		ArrayList<String> menuItemsList = new ArrayList<>();
		ArrayList<Double> pricesList = new ArrayList<>();

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
			menuItemsList.add(array[0]);
			pricesList.add(Double.parseDouble(array[1]));
		}
		
		menuItems = new String[menuItemsList.size()];
		menuItemsList.toArray(menuItems);
		
		prices = new double[pricesList.size()];
		for(int n = 0; n < pricesList.size(); n++) prices[n] = pricesList.get(n);
		
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
	 * To get and return array of menu items
	 * 
	 * @return array of menu items
	 */
	public static String[] getMenuItems() {
		return menuItems;
	}

	/**
	 * To get and return array of menu prices
	 * 
	 * @return array of prices
	 */
	public static double[] getPrices() {
		return prices;
	}

}
