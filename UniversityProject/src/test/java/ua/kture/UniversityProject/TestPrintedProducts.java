package ua.kture.UniversityProject;

import java.util.Iterator;

import org.junit.Test;

import ua.kture.comparator.SortingByPriceByDescendingWay;
import ua.kture.containerOfProducts.ContainerOfPrintedProducts;
import ua.kture.printedProducts.*;
import ua.kture.searchFrame.ComparingAndSearching;
import ua.kture.searchFrame.InputParameters;
import ua.kture.swing.mainFrame.MainFrame;
import junit.framework.TestCase;

public class TestPrintedProducts extends TestCase{
	
	ContainerOfPrintedProducts container = ContainerOfPrintedProducts.getInstance();
	
	
	/*
	 * test to verify that the value of price field is correct
	 */
	@Test
	public void testSetPrice(){
		PrintedProduct product = new Book();
		
		product.setPrice(10);
		double valueOfPrice = product.getPrice();
		assertEquals("the answer should be 10",10.0,valueOfPrice);
		
		product.setPrice(-10);
		valueOfPrice = product.getPrice();
		assertEquals("the answer should be 0",0.0,valueOfPrice);
		
		product.setPrice(0);
		valueOfPrice = product.getPrice();
		assertEquals("the answer should be 0",0.0,valueOfPrice);
	}
	
	/*
	 * test to check that the average price of product calculated correctly
	 */
	@Test
	public void testCalculateTheAveragePriceOfProducts(){
		
		PrintedProduct.setPriceOfAllProducts(1000);
		PrintedProduct.setCountOfProducts(5);
		double theAveragePriceOfProducts = PrintedProduct.calculateTheAveragePriceOfProducts();
		assertEquals("the answer should be 200",200.0,theAveragePriceOfProducts);
		
		PrintedProduct.setPriceOfAllProducts(1000);
		PrintedProduct.setCountOfProducts(-5);
		theAveragePriceOfProducts = PrintedProduct.calculateTheAveragePriceOfProducts();
		assertEquals("the answer should be 1000",1000.0,theAveragePriceOfProducts);
		
		PrintedProduct.setPriceOfAllProducts(-1000);
		PrintedProduct.setCountOfProducts(5);
		theAveragePriceOfProducts = PrintedProduct.calculateTheAveragePriceOfProducts();
		assertEquals("the answer should be 0",0.0,theAveragePriceOfProducts);
	}
	
	/*
	 * test to check that there is only one instance of class ContainerOfPrintedProducts 
	 */
	@Test
	public void testSingleToneOfContainer(){
		ContainerOfPrintedProducts container2 = ContainerOfPrintedProducts.getInstance();
		
		assertEquals(container,container2);
	}
	
	/*
	 * test to check that method of getting count of items in the container works correctly
	 */
	@Test
	public void testCount(){
		int count = container.count();
		
		assertEquals("the answer should be 0",0,count);
		
		container.add(new Book());
		container.add(new Magazine());
		count = container.count();
		assertEquals("the answer should be 2",2,count);	
		
		container.clear();
	}
	
	/*
	 * test to check that method of getting elements by index works correctly
	 */
	@Test
	public void testGetElementByIndex(){
		
		PrintedProduct book = new Book();
		PrintedProduct magazine = new Magazine();
		container.add(book);
		container.add(magazine);
		
		PrintedProduct product = container.getElementByIndex(1);
		assertEquals(magazine,product);	
		
		container.clear();
	}
	
	/*
	 * test method hasNext() in the class ContainerIterator
	 */
	@Test
	public void testHasNext(){
		Iterator<PrintedProduct> iterator = container.iterator();
		
		assertFalse("Should be false because container is empty",iterator.hasNext());
		
		PrintedProduct book = new Book();
		container.add(book);
		
		assertTrue("Should be true because container starts at first and have 1 element",
				iterator.hasNext());
		iterator.next();
		
		assertFalse("Should be false because container have only 1 element"
				+ " and can't referenced on the other element",
				iterator.hasNext());
		
		container.clear();
		assertFalse("Should be false because container is empty",iterator.hasNext());
	}
	
	/*
	 * test method next() in the class ContainerIterator
	 */
	@Test
	public void testNext(){
		Iterator<PrintedProduct> iterator = container.iterator();
		
		PrintedProduct book = new Book();
		container.add(book);
		
		assertEquals("Should be equals because it's same elements",book,iterator.next());
		
		assertNull("Should be null because container have only 1 element",iterator.next());
		
		container.clear();
	}
	
	/*
	 * test method remove in the class ContainerIterator
	 */
	//@Test(expected = IllegalStateException.class)
	@Test
	public void testRemove(){
		Iterator<PrintedProduct> iterator = container.iterator();
		
		container.add(new Book());
		container.add(new Magazine());
		container.add(new Newspaper());
		
		int size = container.count();
		iterator.remove(); //remove first element
		
		assertEquals("The size should be smaller by 1 than the initial size",
				--size,container.count());
		
		PrintedProduct product = new Magazine();
		assertEquals("The first element after removing should be Magazine",product,
				container.getElementByIndex(0));
		
		try{
			iterator.remove();
			fail("iterator.remove() should return exception");
		}
		catch(IllegalStateException exception){}
		container.clear();
	}
	
	/*
	 * test to check that method of sorting elements by ascending,
	 * that contained in the basic class, works correctly 
	 */
	@Test
	public void testSortByAscending(){
		
		PrintedProduct[] arrayOfProducts = new PrintedProduct[4];
		arrayOfProducts[0] = new Book("Core Java",500,"programming","hardcover",2015);
		arrayOfProducts[1] = new Book("Effective Java 2",800,"programming","softcover",2008);
		arrayOfProducts[2] = new Magazine("Dr. Dobb's Journal", 200, 3,"programming",false);
		arrayOfProducts[3] = new Magazine("Java Developer's Journal",300,11,"programming",false);
		
		for(int i=0; i<arrayOfProducts.length;i++){
			container.add(arrayOfProducts[i]);
		}
		
		container.sort(null);
		
		PrintedProduct[] expectedPositionOfElement = {
				arrayOfProducts[2],arrayOfProducts[3],arrayOfProducts[0],arrayOfProducts[1]
		};
		PrintedProduct[] positionOfElementAfterSorting = new PrintedProduct[arrayOfProducts.length];
		for(int i=0;i<arrayOfProducts.length;i++){
			positionOfElementAfterSorting[i] = container.getElementByIndex(i);
		}
		assertTrue("Arrays are equal", java.util.Arrays
				.equals(expectedPositionOfElement,positionOfElementAfterSorting));
		
		container.clear();
	}
	
	/*
	 * test to check that method of sorting elements by descending,
	 * using comparator, works correctly 
	 */
	@Test
	public void testSortByDescending(){
		
		PrintedProduct[] arrayOfProducts = new PrintedProduct[4];
		arrayOfProducts[0] = new Book("Core Java",500,"programming","hardcover",2015);
		arrayOfProducts[1] = new Book("Effective Java 2",800,"programming","softcover",2008);
		arrayOfProducts[2] = new Magazine("Dr. Dobb's Journal", 200, 3,"programming",false);
		arrayOfProducts[3] = new Magazine("Java Developer's Journal",300,11,"programming",false);
		
		for(int i=0; i<arrayOfProducts.length;i++){
			container.add(arrayOfProducts[i]);
		}
		
		container.sort(new SortingByPriceByDescendingWay());
		
		PrintedProduct[] expectedPositionOfElement = {
				arrayOfProducts[1],arrayOfProducts[0],arrayOfProducts[3],arrayOfProducts[2]
		};
		PrintedProduct[] positionOfElementAfterSorting = new PrintedProduct[arrayOfProducts.length];
		for(int i=0;i<arrayOfProducts.length;i++){
			positionOfElementAfterSorting[i] = container.getElementByIndex(i);
		}
		assertTrue("Arrays are equal", java.util.Arrays
				.equals(expectedPositionOfElement,positionOfElementAfterSorting));
		
		container.clear();
	}
	
	/*
	 * test to check that AddWindow worked correctly and add elements in the container correctly
	 */
	@Test
	public void testAddElement(){
		PrintedProduct product = new Magazine("Vogue",50,11,"fashion",true);
		
		MainFrame.add(product);
		
		PrintedProduct expectedProduct = container.getElementByIndex(container.count()-1);
		assertEquals("The elements should be equals because"
				+ " product adds in the container using AddWindow",
				product,expectedProduct);
		
		container.clear();
	}
	
	/*
	 * test to check method of comparing of Book
	 */
	@Test
	public void testCompareItemsOfBook(){
		PrintedProduct product = new Book("TestBook",100,"testing","hardcover",2015);
		ComparingAndSearching compare = new ComparingAndSearching();
		
		int result = compare.compareByNameOfNeededClass(product,"Book");
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByName(product,"TestBook");
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByPrice(product,100);
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByGenre(product,"testing");
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByCoverType(product,"hardcover");
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByYearOfPublishing(product,2015);
		assertEquals("The result should be equals 0 because are the same",0,result);
	}
	
	/*
	 * test to check method of comparing of Magazine
	 */
	@Test
	public void testCompareItemsOfMagazine(){
		PrintedProduct product = new Magazine("TestMagazine",100,1,"testing",true);
		ComparingAndSearching compare = new ComparingAndSearching();
		
		int result = compare.compareByNameOfNeededClass(product,"Magazine");
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByName(product,"TestMagazine");
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByPrice(product,100);
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByNumberOfIssueOfMagazine(product,1);
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByType(product,"testing");
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByIfHasAdditionalGift(product,true);
		assertEquals("The result should be equals 0 because are the same",0,result);
	}
	
	/*
	 * test to check method of comparing of Newspaper
	 */
	@Test
	public void testCompareItemsOfNewspaper(){
		PrintedProduct product = new Newspaper("TestNewspaper",100,15,true);
		ComparingAndSearching compare = new ComparingAndSearching();
		
		int result = compare.compareByNameOfNeededClass(product,"Newspaper");
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByName(product,"TestNewspaper");
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByPrice(product,100);
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByNumberOfIssueOfNewspaper(product,15);
		assertEquals("The result should be equals 0 because are the same",0,result);
		
		result = compare.compareByIfHasProgram(product,true);
		assertEquals("The result should be equals 0 because are the same",0,result);
	}
	
	/*
	 * test to check method of searching Book
	 */
	@Test
	public void testToSearchBook(){
		PrintedProduct product = new Book("TestBook",100,"testing","hardcover",2015);
		InputParameters parameters = new InputParameters(null,100,null,"hardcover",0);
		parameters.setDefinition("Book");
		ComparingAndSearching search = new ComparingAndSearching();
		
		boolean result = search.searchBook(product, parameters);
		assertTrue("Should be true because searching parameters are equals to product"
				+ " and some of them there are in the constructor of product",result);
	}
	
	/*
	 * test to check method of searching Magazine
	 */
	@Test
	public void testToSearchMagazine(){
		PrintedProduct product = new Magazine("TestMagazine",100,1,"testing",true);
		InputParameters parameters = new InputParameters(null,100,0,"testing",true);
		parameters.setDefinition("Magazine");
		ComparingAndSearching search = new ComparingAndSearching();
		
		boolean result = search.searchMagazine(product, parameters);
		assertTrue("Should be true because searching parameters are equals to product"
				+ " and some of them there are in the constructor of product",result);
	}
	
	/*
	 * test to check method of searching Newspaper
	 */
	@Test
	public void testToSearchNewspaper(){
		PrintedProduct product = new Newspaper("TestNewspaper",100,1,true);
		InputParameters parameters = new InputParameters(null,100,0,true);
		parameters.setDefinition("Newspaper");
		ComparingAndSearching search = new ComparingAndSearching();
		
		boolean result = search.searchNewspaper(product, parameters);
		assertTrue("Should be true because searching parameters are equals to product"
				+ " and some of them there are in the constructor of product",result);
	}
	
	/*
	 * test to check method of searching all items
	 */
	@Test
	public void testToSearchAll(){
		PrintedProduct product1 = new Book("TestBook",100,"testing","hardcover",2015);
		PrintedProduct product2= new Magazine("TestMagazine",200,1,"testing",true);
		PrintedProduct product3 = new Newspaper("TestNewspaper",300,1,true);
		
		InputParameters parameters = new InputParameters("Test",0);
		parameters.setDefinition("All");
		ComparingAndSearching search = new ComparingAndSearching();
		
		boolean result = search.searchAll(product1, parameters);
		assertTrue("Should be true because searching parameters are equals to product"
				+ " and some of them there are in the constructor of product",result);
		
		result = search.searchAll(product2, parameters);
		assertTrue("Should be true because searching parameters are equals to product"
				+ " and some of them there are in the constructor of product",result);
		
		result = search.searchAll(product3, parameters);
		assertTrue("Should be true because searching parameters are equals to product"
				+ " and some of them there are in the constructor of product",result);
		
	}
}
