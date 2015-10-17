package ua.kture.swing.mainFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ua.kture.DisplayFrame.DisplayFrame;
import ua.kture.addFrame.AddFrame;
import ua.kture.containerOfProducts.ContainerOfPrintedProducts;
import ua.kture.deleteFrame.DeleteFrame;
import ua.kture.printedProducts.Book;
import ua.kture.printedProducts.Magazine;
import ua.kture.printedProducts.Newspaper;
import ua.kture.printedProducts.PrintedProduct;
import ua.kture.searchFrame.SearchFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	private static JFrame mainWindow;
	private static ContainerOfPrintedProducts listOfProducts = ContainerOfPrintedProducts.getInstance();
	
	JPanel buttonPanel = new JPanel();
	JPanel picturePanel = new JPanel();
	
	JButton buttonAdd = new JButton("Add product");
	JButton buttonDisplay = new JButton("Display list of products");

	JButton buttonSearch = new JButton("Search product");
	JButton buttonDelete = new JButton("Delete product");
	
	ImagePanel imagePanel = new ImagePanel(
            new ImageIcon("image2.jpg").getImage());

	/*
	 * method to return uniqueInstance of class 
	 */
	public static JFrame getInstance() {
			if (mainWindow == null) {
				mainWindow = new JFrame("Registration Book");
			}
			return mainWindow;
	}
	
	public MainFrame(){
		
		MainFrame.getInstance();
		fillContainer();
		
		mainWindow.setBounds(100, 100, 600, 400);
		mainWindow.setLayout(new BorderLayout());
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainWindow.getContentPane().add(imagePanel);
		mainWindow.pack();
		
		buttonPanel.setLayout(new FlowLayout());
		
		buttonPanel.add(buttonAdd);
		buttonPanel.add(buttonDisplay);
		buttonPanel.add(buttonSearch);
		buttonPanel.add(buttonDelete);
		
		mainWindow.add(buttonPanel, BorderLayout.SOUTH);
		
		mainWindow.setVisible(true);
		
		buttonAdd.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				new AddFrame();
			}
		});
		buttonSearch.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				new SearchFrame();
			}
		});
		buttonDelete.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				new DeleteFrame();
			}
		});
		buttonDisplay.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				new DisplayFrame();
			}
		});
		
	}
	
	public static void fillContainer(){
		PrintedProduct[] arrayOfProducts = new PrintedProduct[7];
		
		arrayOfProducts[0] = new Book("Core Java",500,"programming","hardcover",2015);
		arrayOfProducts[1] = new Book("Effective Java 2",800,"programming","softcover",2008);
		arrayOfProducts[2] = new Magazine("Dr.Dobb's Journal", 200, 3,"programming",false);
		arrayOfProducts[3] = new Magazine("Java Developer's",300,11,"programming",false);
		arrayOfProducts[4] = new Newspaper("Week's news",15,45,true);
		arrayOfProducts[5] = new Newspaper("TV Show",30,13,true);
		arrayOfProducts[6] = new Magazine("Vogue",250,13,"fashion",true);
		
		for(int i=0; i<arrayOfProducts.length;i++){
			listOfProducts.add(arrayOfProducts[i]);
		}
	}
	public static void add(PrintedProduct product){
		listOfProducts.add(product);
		listOfProducts.print();
	}
	public static ContainerOfPrintedProducts getListOfProducts(){
		return listOfProducts;
	}
	public static void clearList(){
		listOfProducts.clear();
	}
	
	
}
