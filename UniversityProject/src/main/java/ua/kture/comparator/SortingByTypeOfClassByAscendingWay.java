package ua.kture.comparator;

import java.util.Comparator;

import ua.kture.printedProducts.PrintedProduct;

public class SortingByTypeOfClassByAscendingWay implements Comparator<PrintedProduct>{

	@Override
	public int compare(PrintedProduct p1, PrintedProduct p2) {
		return p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());
	}

}
