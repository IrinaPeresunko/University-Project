package ua.kture.comparator;

import java.util.Comparator;

import ua.kture.printedProducts.PrintedProduct;

public class SortingByPriceByDescendingWay implements Comparator<PrintedProduct>{
	/*
	 * method to sort element by price by descending way
	 */
	public int compare(PrintedProduct p1, PrintedProduct p2) {
		return p1.getPrice()>p2.getPrice() ? -1 : p1.getPrice()==p2.getPrice() ? 0 : 1;
	}
}
