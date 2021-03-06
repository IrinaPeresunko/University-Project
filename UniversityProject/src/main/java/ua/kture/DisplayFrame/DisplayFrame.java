package ua.kture.DisplayFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ua.kture.comparator.SortingByTypeOfClassByAscendingWay;
import ua.kture.editFrame.EditFrame;
import ua.kture.printedProducts.Book;
import ua.kture.printedProducts.Magazine;
import ua.kture.printedProducts.Newspaper;
//import ua.kture.comparator.SortingByPriceByDescendingWay;
import ua.kture.printedProducts.PrintedProduct;
import ua.kture.swing.mainFrame.MainFrame;


public class DisplayFrame {
	
	private static JFrame displayWindow;
	private static PrintedProduct productForEditing;
	
	private static JList<String> viewList = new JList<String>();
	private static DefaultListModel<String> productData = new DefaultListModel<String>();
	
	JPanel buttonPanel = new JPanel();
	
	JButton buttonEdit = new JButton("Edit");
	JButton buttonDelete = new JButton("Delete");
	JButton buttonClear = new JButton("Clear");
	JButton buttonSort = new JButton("Sort by price");
	JButton buttonOrder = new JButton("Order");
	JButton buttonCalculateCost = new JButton("Calculate cost");

	/*
	 * method to return uniqueInstance of class 
	 */
	public static JFrame getInstance() {
			if (displayWindow == null) {
				displayWindow = new JFrame("Registration Book");
			}
			return displayWindow;
	}
	
	public DisplayFrame(){
		
		DisplayFrame.getInstance();
		
		//MainFrame.fillContainer();
		for(int i=0;i<MainFrame.getListOfProducts().count();i++){
			productData.addElement(MainFrame.getListOfProducts().getElementByIndex(i).toString());
		}
		
		displayWindow.setBounds(100, 100, 600, 400);
		displayWindow.setLayout(new BorderLayout());
		displayWindow.setResizable(false);
		displayWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttonPanel.setLayout(new FlowLayout());
		
		buttonPanel.add(buttonEdit);
		buttonPanel.add(buttonDelete);
		buttonPanel.add(buttonCalculateCost);
		buttonPanel.add(buttonOrder);
		buttonPanel.add(buttonSort);
		buttonPanel.add(buttonClear);
		
		displayWindow.add(buttonPanel, BorderLayout.SOUTH);
		
		displayWindow.setVisible(true);
		
		displayWindow.add(viewList, BorderLayout.CENTER);
		viewList.setModel(productData);
		
		buttonEdit.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				productForEditing = MainFrame.getListOfProducts().
						getElementByIndex(viewList.getSelectedIndex());
				new EditFrame(productForEditing);	
			}
		});
		
		buttonDelete.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				if(MainFrame.getListOfProducts().count() == 0) throw new IllegalStateException("List is empty");
					MainFrame.getListOfProducts().remove(viewList.getSelectedIndex());
					productData.remove(viewList.getSelectedIndex());
				
			}
		});
		
		buttonCalculateCost.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				//new CalculateCostFrame();
				JOptionPane.showMessageDialog(null, getResultTextForLabel(
						MainFrame.getListOfProducts().count(),
						MainFrame.getListOfProducts().calculateCost(),
						MainFrame.getListOfProducts().calculateAverageCost()));

			}
		});
		
		buttonOrder.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				MainFrame.getListOfProducts().sort(new SortingByTypeOfClassByAscendingWay());
				productData.clear();
				
				Iterator<PrintedProduct> iterator = MainFrame.getListOfProducts().iterator();
				while(iterator.hasNext()){
					PrintedProduct product = iterator.next();
					productData.addElement(product.toString());
				}
			}
		});
		
		buttonSort.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				//MainFrame.getListOfProducts().sort(new SortingByPriceByDescendingWay());
				MainFrame.getListOfProducts().sort(null);
				productData.clear();
				
				Iterator<PrintedProduct> iterator = MainFrame.getListOfProducts().iterator();
				while(iterator.hasNext()){
					PrintedProduct product = iterator.next();
					productData.addElement(product.toString());
				}
			}
		});
		
		buttonClear.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				if(MainFrame.getListOfProducts().count() == 0) throw new IllegalStateException("List is empty");
				MainFrame.clearList();
				productData.clear();
			}
		});
	}
	
	public static void editBook(String inputName,double inputPrice,String inputGenre,String inputCoverType,
			int inputTheYearOfPublishing){
		
		int index = viewList.getSelectedIndex();
		Book book = (Book) MainFrame.getListOfProducts().getElementByIndex(index);
		
			book.setNameOfProduct(inputName);
			book.setPrice(inputPrice);
			book.setGenre(inputGenre);
			book.setCoverType(inputCoverType);
			book.setTheYearOfPublishing(inputTheYearOfPublishing);
			
			productData.insertElementAt(book.toString(), index);
			productData.remove(index+1);
		
	}
	
	public static void editMagazine(String inputName,double inputPrice,int inputNumberOfIssue,String inputType,
			boolean inputHasAdditionalGift){
		
		int index = viewList.getSelectedIndex();
		Magazine magazine = (Magazine) MainFrame.getListOfProducts().getElementByIndex(index);
		
			magazine.setNameOfProduct(inputName);
			magazine.setPrice(inputPrice);
			magazine.setNumberOfIssue(inputNumberOfIssue);
			magazine.setType(inputType);
			magazine.setIfMagazineHasAdditionalGift(inputHasAdditionalGift);

			productData.insertElementAt(productForEditing.toString(), index);
			productData.remove(index+1);
		
	}
	
	public static void editNewspaper(String inputName,double inputPrice,int inputNumberOfIssue,
			boolean inputHasProgram){
		
		int index = viewList.getSelectedIndex();
		Newspaper newspaper = (Newspaper) MainFrame.getListOfProducts().getElementByIndex(index);
		
			newspaper.setNameOfProduct(inputName);
			newspaper.setPrice(inputPrice);
			newspaper.setNumberOfIssue(inputNumberOfIssue);
			newspaper.setHasProgram(inputHasProgram);
		
			productData.insertElementAt(productForEditing.toString(), index);
			productData.remove(index+1);
	}
	
	public String getResultTextForLabel(int counOfProducts, double cost, double averageCost){
		StringBuilder builder = new StringBuilder();
		builder.append("The count of printed product that are registred in the registration book is ")
		.append(counOfProducts).append("."+"\n").append("The final cost of all products is ").append(cost)
		.append("."+"\n").append("The average cost is ").append(averageCost);
		return builder.toString();
	}
	
}

