package ua.kture.containerOfProducts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import ua.kture.printedProducts.PrintedProduct;

public class ContainerOfPrintedProducts {
	
	private static ContainerOfPrintedProducts uniqueInstance;
	private final ArrayList<PrintedProduct> containerOfProducts; 
	
	private ContainerOfPrintedProducts(){
		this.containerOfProducts = new ArrayList<PrintedProduct>();
	}
	
	/*
	 * method to return uniqueInstance of class 
	 */
	public static ContainerOfPrintedProducts getInstance() {
			if (uniqueInstance == null) {
				uniqueInstance = new ContainerOfPrintedProducts();
			}
			return uniqueInstance;
	}
	
	/*
	 * method for adding items to the container 
	 */
	public void add(PrintedProduct product){
		containerOfProducts.add(product);
	}
	
	/*
	 * method to get the count of items in the container
	 */
	public int count(){
		return containerOfProducts.size();
	}
	
	/*
	 * method to get element by index
	 */
	public PrintedProduct getElementByIndex(int index){
		return containerOfProducts.get(index);
	}
	
	/*
	 * method to sort elements in the container. 
	 * If value of comparator is null - use standard method of sorting
	 * that contained in the basic class. Otherwise - used comparator
	 */
	public void sort(Comparator<PrintedProduct> comparator){
		if(comparator == null){
			Collections.sort(containerOfProducts);
		}
		else{
			containerOfProducts.sort(comparator);
		}
	}
	
	/*
	 * method to remove element in the container
	 */
	public void remove(int index){
		containerOfProducts.remove(index);
	}
	
	/*
	 * method to print all items in the container
	 */
	public void print(){
		for(PrintedProduct product : containerOfProducts){
			System.out.println(product);
		}
	}
	
	/*
	 * method to calculate the cost of all products
	 */
	public double calculateCost(){
		double cost = 0;
		
		for(PrintedProduct product : containerOfProducts){
			cost+=product.getPrice();
		}
		
		return cost;
	}
	
	/*
	 * method to calculate the average cost of all products
	 */
	public double calculateAverageCost() {
		return  calculateCost()/count();
	}
	
	/*
	 * method to clear all items in the container, used for tests
	 */
	public void clear(){
		containerOfProducts.clear();
	}
	
	/*
	 * method to create iterator
	 */
	public Iterator<PrintedProduct> iterator(){
		return new ContainerIterator();
	}
	
	private class ContainerIterator implements Iterator<PrintedProduct>{
		
		private int innerCounter = 0;
		private boolean wasRemoved = false;
		
		@Override
		public boolean hasNext() {
			if(innerCounter<count()) return true;
			return false;
		}

		@Override
		public PrintedProduct next() throws NullPointerException{
			if(hasNext()){
				innerCounter++;
				wasRemoved = false;
				return containerOfProducts.get(innerCounter-1);
			}
			return null;
		}

		@Override
		public void remove() throws IllegalStateException {
			if(wasRemoved){
		        System.out.println("You can't remove element twice in a row");
		        throw new IllegalStateException();
		    }
			if(innerCounter==0){
				containerOfProducts.remove(innerCounter);
			}
			else{
				containerOfProducts.remove(innerCounter-1);
			}
			wasRemoved = true;
			innerCounter--;	
		}
	}
	
}
