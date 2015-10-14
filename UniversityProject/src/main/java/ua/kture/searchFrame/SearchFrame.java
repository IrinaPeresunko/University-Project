package ua.kture.searchFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ua.kture.containerOfProducts.ContainerOfPrintedProducts;
import ua.kture.printedProducts.*;
import ua.kture.swing.mainFrame.MainFrame;

@SuppressWarnings("serial")
public class SearchFrame extends JFrame{
	private static JFrame searchWindow;
	
	JLabel label = new JLabel("What you want to search?");
	
	JRadioButton book = new JRadioButton("Book",false);
	JRadioButton magazine = new JRadioButton("Magazine",false);
	JRadioButton newspaper = new JRadioButton("Newspaper",false);
	JRadioButton all = new JRadioButton("All",false);
	
	ButtonGroup group = new ButtonGroup();
	
	JButton search = new JButton("Search");
	JButton cancel = new JButton("Cancel");
	
	JTextField name = new JTextField();
	JTextField price = new JTextField();
	JTextField genre = new JTextField();
	JTextField coverType = new JTextField();
	JTextField theYearOfPublishing = new JTextField();
	JTextField numberOfIssue = new JTextField();
	JTextField type = new JTextField();
	JTextField hasAdditionalGift = new JTextField();
	JTextField hasProgram = new JTextField();
	
	JLabel labelName = new JLabel("name");
	JLabel labelPrice = new JLabel("price");
	JLabel labelGenre = new JLabel("genre");
	JLabel labelCoverType = new JLabel("type of cover");
	JLabel labelTheYearOfPublishing = new JLabel("year of publishing");
	JLabel labelNumberOfIssue = new JLabel("number of issue");
	JLabel labelType = new JLabel("type");
	JLabel labelHasAdditionalGift = new JLabel("Does magazine have gift?");
	JLabel labelHasProgram = new JLabel("Does newsppr have program?");
	
	 JComboBox<String> resultListOfProducts = new JComboBox<String>();
	 
	String gettingName = null;
	double gettingPrice = 0;
		
	String gettingGenre = null;
	String gettingCoverType = null;
	int gettingTheYearOfPublishing = 0;
	int gettingNumberOfIssue = 0;
	String gettingType = null;
	boolean gettingIfHasAdditionalGift = false;
	boolean gettingIfHasProgram = false;

	/*
	 * method to return uniqueInstance of class 
	 */
	public static JFrame getInstance() {
			if (searchWindow == null) {
				searchWindow = new JFrame("Search product");
			}
			return searchWindow;
	}
	
	public SearchFrame(){
		
		SearchFrame.getInstance();
		
		searchWindow.setBounds(100, 100, 600, 400);
		searchWindow.setLayout(null);
		searchWindow.setResizable(false);
		searchWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		addWindow.getContentPane().add(imagePanel);
//		addWindow.pack();
		
		label.setBounds(230, 20, 200, 20);
		
		searchWindow.add(label);
		
		group.add(book);
		group.add(magazine);
		group.add(newspaper);
		group.add(all);
		
		searchWindow.add(book);
		searchWindow.add(magazine);
		searchWindow.add(newspaper);
		searchWindow.add(all);
		
		book.setBounds(130, 50, 100, 20);
		magazine.setBounds(230, 50, 100, 20);
		newspaper.setBounds(330, 50, 100, 20);
		all.setBounds(450, 50, 100, 20);
		
		searchWindow.setVisible(true);
		
		labelName.setBounds(70, 90, 180, 25);
		labelPrice.setBounds(350, 90, 180, 25);
		
		labelGenre.setBounds(70, 120, 180, 25); 
		labelCoverType.setBounds(35, 150, 180, 25); 
		labelTheYearOfPublishing.setBounds(10, 180, 180, 25); 
		
		labelNumberOfIssue.setBounds(295, 120, 180, 25);
		labelType.setBounds(360, 150, 180, 25); 
		labelHasAdditionalGift.setBounds(150, 210, 180, 25); 
		labelHasProgram.setBounds(120, 240, 180, 25); 
		
		name.setBounds(110, 90, 180, 25);
		price.setBounds(390, 90, 180, 25);
		
		genre.setBounds(110, 120, 180, 25);
		coverType.setBounds(110, 150, 180, 25);
		theYearOfPublishing.setBounds(110, 180, 180, 25);
		
		numberOfIssue.setBounds(390, 120, 180, 25);
		type.setBounds(390, 150, 180, 25);
		hasAdditionalGift.setBounds(300, 210, 180, 25); 
		hasProgram.setBounds(300, 240, 180, 25); 
		
		resultListOfProducts.setBounds(5,310,585,25);
		searchWindow.add(resultListOfProducts);
		
		searchWindow.add(labelName);
		searchWindow.add(labelPrice);
		searchWindow.add(labelGenre);
		searchWindow.add(labelCoverType);
		searchWindow.add(labelTheYearOfPublishing);
		searchWindow.add(labelNumberOfIssue);
		searchWindow.add(labelType);
		searchWindow.add(labelHasAdditionalGift);
		searchWindow.add(labelHasProgram);
		
		searchWindow.add(name);
		searchWindow.add(price);
		searchWindow.add(genre);
		searchWindow.add(coverType);
		searchWindow.add(theYearOfPublishing);
		searchWindow.add(numberOfIssue);
		searchWindow.add(type);
		searchWindow.add(hasAdditionalGift);
		searchWindow.add(hasProgram);
		
		search.setBounds(200, 280, 80, 20);
		cancel.setBounds(300, 280, 100, 20);
		
		searchWindow.add(search);
		searchWindow.add(cancel);
		
		book.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) { 
	        	 
	        	labelNumberOfIssue.setVisible(false);
		     	labelType.setVisible(false);
		     	labelHasAdditionalGift.setVisible(false);
		     	labelHasProgram.setVisible(false);
	        	 
	        	numberOfIssue.setVisible(false);
	     		type.setVisible(false);
	     		hasAdditionalGift.setVisible(false);
	     		hasProgram.setVisible(false);
	     	
	         }
	         
		});
		
		magazine.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) { 
	        	 
	        	labelGenre.setVisible(false);
	     		labelCoverType.setVisible(false);
	     		labelTheYearOfPublishing.setVisible(false);
		     	labelHasProgram.setVisible(false);
	        	 
		     	genre.setVisible(false);
				coverType.setVisible(false);
				theYearOfPublishing.setVisible(false);
	     		hasProgram.setVisible(false);
	     		
	         }
		});
		
		newspaper.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) { 
	        	 
	        	labelGenre.setVisible(false);
	     		labelCoverType.setVisible(false);
	     		labelTheYearOfPublishing.setVisible(false);
	     		labelType.setVisible(false);
		     	labelHasAdditionalGift.setVisible(false);
		     	
	        	 
		     	genre.setVisible(false);
				coverType.setVisible(false);
				theYearOfPublishing.setVisible(false);
				type.setVisible(false);
	     		hasAdditionalGift.setVisible(false);
	         }
		});
		
		all.addItemListener(new ItemListener() {
	         public void itemStateChanged(ItemEvent e) { 
	        	 
	        	labelGenre.setVisible(false);
	     		labelCoverType.setVisible(false);
	     		labelTheYearOfPublishing.setVisible(false);
	     		labelType.setVisible(false);
		     	labelHasAdditionalGift.setVisible(false);
		     	labelHasProgram.setVisible(false);
		     	labelNumberOfIssue.setVisible(false);
		     	
	        	 
		     	genre.setVisible(false);
				coverType.setVisible(false);
				theYearOfPublishing.setVisible(false);
				type.setVisible(false);
	     		hasAdditionalGift.setVisible(false);
	     		hasProgram.setVisible(false);
	     		numberOfIssue.setVisible(false);
	         }
		});
		
		search.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){ 
			
				resultListOfProducts.removeAllItems();
				ContainerOfPrintedProducts products = MainFrame.getListOfProducts();
				Iterator<PrintedProduct> iterator = products.iterator();
				
				InputParameters parameters = null;
				ComparingAndSearching searching = new ComparingAndSearching();
				String definition = null;
	
			if(book.isSelected()){
				fillBook();
				definition = "Book";			
			}
			else if(magazine.isSelected()){
				fillMagazine();
				definition = "Magazine";		
			}
			else if(newspaper.isSelected()){
				fillNewspaper();
				definition = "Newspaper";
			}
			else if(all.isSelected()){
				fillAll();
				definition = "All";
				//System.out.println(definition);
			}
			
			while(iterator.hasNext()){
				PrintedProduct product = iterator.next();
				
				String nameOfClass = product.getClass().getSimpleName();
				validationOfInputData(nameOfClass,product);
				
				parameters = getParameters(definition);
				parameters.setDefinition(definition);
				
				boolean flag = searching.search(parameters.getDefinition(),product,parameters);
				if(flag==true){
					resultListOfProducts.addItem(product.toString());
				}
		}
		}
	});
	
		cancel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				name.setText(null);
				price.setText(null);
				genre.setText(null);
				coverType.setText(null);
				theYearOfPublishing.setText(null);
				numberOfIssue.setText(null);
				type.setText(null);
				hasAdditionalGift.setText(null);
				hasProgram.setText(null);
				
				group.clearSelection();
				book.setSelected(false);
				magazine.setSelected(false);
				newspaper.setSelected(false);
				
				resultListOfProducts.removeAllItems();
				searchWindow.setVisible(false);	
			}
		});
	
	}
	
	public void fillBook(){
		if(!name.getText().equals("")){
			gettingName=name.getText();
		}
		if(!price.getText().equals("")){
			gettingPrice=Double.parseDouble(price.getText());
		}
		if(!genre.getText().equals("")){
			gettingGenre=genre.getText();
		}
		if(!coverType.getText().equals("")){
			gettingCoverType=coverType.getText();
		}
		if(!theYearOfPublishing.getText().equals("")){
			gettingTheYearOfPublishing=Integer.parseInt(theYearOfPublishing.getText());
		}
	}
	
	public void fillMagazine(){
		if(!name.getText().equals("")){
			gettingName=name.getText();
		}
		if(!price.getText().equals("")){
			gettingPrice=Double.parseDouble(price.getText());
		}
		if(!numberOfIssue.getText().equals("")){
			gettingNumberOfIssue=Integer.parseInt(numberOfIssue.getText());
		}
		if(!type.getText().equals("")){
			gettingType=type.getText();
		}
		if(!hasAdditionalGift.getText().equals("")){
			gettingIfHasAdditionalGift=Boolean.parseBoolean(hasAdditionalGift.getText());
		}
	}
	
	public void fillNewspaper(){
		if(!name.getText().equals("")){
			gettingName=name.getText();
		}
		if(!price.getText().equals("")){
			gettingPrice=Double.parseDouble(price.getText());
		}
		if(!numberOfIssue.getText().equals("")){
			gettingNumberOfIssue=Integer.parseInt(numberOfIssue.getText());
		}
		if(!hasProgram.getText().equals("")){
			gettingIfHasProgram=Boolean.parseBoolean(hasProgram.getText());
		}
	}
	
	public void fillAll(){
		if(!name.getText().equals("")){
			gettingName=name.getText();
		}
		if(!price.getText().equals("")){
			gettingPrice=Double.parseDouble(price.getText());
		}
	}
	public void validationOfInputData(String nameOfClass, PrintedProduct product){
		if(hasProgram.getText().equals("") && nameOfClass.equals("Newspaper")){
			gettingIfHasProgram = ((Newspaper) product).isHasProgram();
		}
		if(hasAdditionalGift.getText().equals("") && nameOfClass.equals("Magazine")){
			gettingIfHasAdditionalGift = ((Magazine) product).getIfMagazineHasAdditionalGift();
		}
	}
	
	public InputParameters getParameters(String definition){
		switch(definition){
			case "Book": return new InputParameters(gettingName,gettingPrice,gettingGenre,
							gettingCoverType,gettingTheYearOfPublishing);
			case "Magazine": return new InputParameters(gettingName,gettingPrice,gettingNumberOfIssue,
								gettingType, gettingIfHasAdditionalGift);
			case "Newspaper": return new InputParameters(gettingName,gettingPrice,gettingNumberOfIssue,
								gettingIfHasProgram);
			case "All": return new InputParameters(gettingName,gettingPrice);
		}
		return null;
	}
}
