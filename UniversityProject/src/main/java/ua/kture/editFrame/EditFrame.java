package ua.kture.editFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ua.kture.DisplayFrame.DisplayFrame;
import ua.kture.addFrame.AddFrame;
import ua.kture.printedProducts.Book;
import ua.kture.printedProducts.Magazine;
import ua.kture.printedProducts.Newspaper;
import ua.kture.printedProducts.PrintedProduct;

@SuppressWarnings("serial")
public class EditFrame extends JFrame{
	
	private static JFrame editWindow;
	
	JButton edit = new JButton("Edit");
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
	
	private PrintedProduct productForEditing;
	private PrintedProduct book;
	private PrintedProduct magazine;
	private PrintedProduct newspaper;
	
	/*
	 * method to return uniqueInstance of class 
	 */
	public static JFrame getInstance() {
			if (editWindow == null) {
				editWindow = new JFrame("Search product");
			}
			return editWindow;
	}
	
	public EditFrame(PrintedProduct productForEditing){
		
		EditFrame.getInstance();
		
		this.productForEditing = productForEditing;
		final String nameOfClass = productForEditing.getClass().getSimpleName();
		
		editWindow.setBounds(100, 100, 600, 400);
		editWindow.setLayout(null);
		editWindow.setResizable(false);
		editWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		editWindow.setVisible(true);
		
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
		
		editWindow.add(labelName);
		editWindow.add(labelPrice);
		editWindow.add(labelGenre);
		editWindow.add(labelCoverType);
		editWindow.add(labelTheYearOfPublishing);
		editWindow.add(labelNumberOfIssue);
		editWindow.add(labelType);
		editWindow.add(labelHasAdditionalGift);
		editWindow.add(labelHasProgram);
		
		editWindow.add(name);
		editWindow.add(price);
		editWindow.add(genre);
		editWindow.add(coverType);
		editWindow.add(theYearOfPublishing);
		editWindow.add(numberOfIssue);
		editWindow.add(type);
		editWindow.add(hasAdditionalGift);
		editWindow.add(hasProgram);
		
		edit.setBounds(200, 280, 80, 20);
		cancel.setBounds(300, 280, 100, 20);
		
		editWindow.add(edit);
		editWindow.add(cancel);
		
		defineClassThatWasSelected(nameOfClass);
		
		edit.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				switch(nameOfClass){
					case "Book":  DisplayFrame.editBook(name.getText(),Double.parseDouble(price.getText()),
							genre.getText(),coverType.getText(),
							Integer.parseInt(theYearOfPublishing.getText()));break;
					case "Magazine": DisplayFrame.editMagazine(name.getText(),
						Double.parseDouble(price.getText()),
						Integer.parseInt(numberOfIssue.getText()),type.getText(),
						Boolean.parseBoolean(hasAdditionalGift.getText()));break;
					case "Newspaper": DisplayFrame.editNewspaper(name.getText(),
							Double.parseDouble(price.getText()),
							Integer.parseInt(numberOfIssue.getText()),
							Boolean.parseBoolean(hasProgram.getText()));
							
				
				}
				AddFrame.cleandAfterCompleteing();
				
				editWindow.setVisible(false);
		}
	});
	
		cancel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				AddFrame.cleandAfterCompleteing();
				
				editWindow.setVisible(false);	
			}
		});
	
	}
	public void defineClassThatWasSelected(String nameOfClass){
		switch(nameOfClass){
			case "Book": fillBook();break;
			case "Magazine": fillMagazine();break;
			case "Newspaper": fillNewspaper();break;
		}
	}
	public void fillBook(){
		
		enableBook();
 		
		this.book = new Book(productForEditing.getNameOfProduct(),productForEditing.getPrice(),
				((Book) productForEditing).getGenre(),((Book) productForEditing).getCoverType(),
				((Book) productForEditing).getTheYearOfPublishing());
		
		name.setText(book.getNameOfProduct());
		price.setText(String.valueOf(book.getPrice()));
		
		genre.setText(((Book) productForEditing).getGenre());
		coverType.setText(((Book) productForEditing).getCoverType());
		theYearOfPublishing.setText(String.valueOf(((Book) productForEditing).getTheYearOfPublishing()));
	
	}
	
	public void fillMagazine(){
		
		enableMagazine();
		
		this.magazine = new Magazine(productForEditing.getNameOfProduct(),
				productForEditing.getPrice(),
				((Magazine) productForEditing).getNumberOfIssue(),
				((Magazine) productForEditing).getType(),
				((Magazine) productForEditing).getIfMagazineHasAdditionalGift());
		
		name.setText(magazine.getNameOfProduct());
		price.setText(String.valueOf(magazine.getPrice()));
		
		numberOfIssue.setText(String.valueOf(((Magazine) magazine).getNumberOfIssue()));
		type.setText(String.valueOf(((Magazine) magazine).getType()));
		hasAdditionalGift.setText(String.valueOf(((Magazine) magazine).getIfMagazineHasAdditionalGift()));
	}
	
	public void fillNewspaper(){
		
		enableNewspaper();
		
		this.newspaper = new Newspaper(productForEditing.getNameOfProduct(),
				productForEditing.getPrice(),
				((Newspaper) productForEditing).getNumberOfIssue(),
				((Newspaper) productForEditing).isHasProgram());
		
		name.setText(newspaper.getNameOfProduct());
		price.setText(String.valueOf(newspaper.getPrice()));
		
		numberOfIssue.setText(String.valueOf(((Newspaper) newspaper).getNumberOfIssue()));
		hasProgram.setText(String.valueOf(((Newspaper) newspaper).isHasProgram()));
	}
	
	public void enableBook(){
		
		labelNumberOfIssue.setVisible(false);
     	labelType.setVisible(false);
     	labelHasAdditionalGift.setVisible(false);
     	labelHasProgram.setVisible(false);
    	 
    	numberOfIssue.setVisible(false);
 		type.setVisible(false);
 		hasAdditionalGift.setVisible(false);
 		hasProgram.setVisible(false);
 		
	}
	
	public void enableMagazine(){
		
		labelGenre.setVisible(false);
 		labelCoverType.setVisible(false);
 		labelTheYearOfPublishing.setVisible(false);
     	labelHasProgram.setVisible(false);
    	 
     	genre.setVisible(false);
		coverType.setVisible(false);
		theYearOfPublishing.setVisible(false);
 		hasProgram.setVisible(false);
 		
	}
	
	public void enableNewspaper(){
		
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
	
}
