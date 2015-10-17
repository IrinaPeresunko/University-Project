package ua.kture.addFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
//import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ua.kture.swing.mainFrame.MainFrame;

@SuppressWarnings("serial")
public class AddFrame extends JFrame{
	
	private static JFrame addWindow;
//	private static JList viewList = new JList();
//	private static DefaultListModel<String> productData = new DefaultListModel();
	
	JLabel label = new JLabel("What you want to add?");
	
	JRadioButton book = new JRadioButton("Book",false);
	JRadioButton magazine = new JRadioButton("Magazine",false);
	JRadioButton newspaper = new JRadioButton("Newspaper",false);
	
	ButtonGroup group = new ButtonGroup();
	
	JButton ok = new JButton("Add");
	JButton cancel = new JButton("Cancel");
	
	static JTextField name = new JTextField();
	static JTextField price = new JTextField();
	static JTextField genre = new JTextField();
	static JTextField coverType = new JTextField();
	static JTextField theYearOfPublishing = new JTextField();
	static JTextField numberOfIssue = new JTextField();
	static JTextField type = new JTextField();
	static JTextField hasAdditionalGift = new JTextField();
	static JTextField hasProgram = new JTextField();
	
	JLabel labelName = new JLabel("name");
	JLabel labelPrice = new JLabel("price");
	JLabel labelGenre = new JLabel("genre");
	JLabel labelCoverType = new JLabel("type of cover");
	JLabel labelTheYearOfPublishing = new JLabel("year of publishing");
	JLabel labelNumberOfIssue = new JLabel("number of issue");
	JLabel labelType = new JLabel("type");
	JLabel labelHasAdditionalGift = new JLabel("Does magazine have gift?");
	JLabel labelHasProgram = new JLabel("Does newsppr have program?");

	/*
	 * method to return uniqueInstance of class 
	 */
	public static JFrame getInstance() {
			if (addWindow == null) {
				addWindow = new JFrame("Add product");
			}
			return addWindow;
	}
	
	public AddFrame(){
		
		AddFrame.getInstance();
		
		addWindow.setBounds(100, 100, 600, 400);
		addWindow.setLayout(null);
		addWindow.setResizable(false);
		addWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		addWindow.getContentPane().add(imagePanel);
//		addWindow.pack();
		
		label.setBounds(230, 20, 200, 20);
		
		addWindow.add(label);
		
		group.add(book);
		group.add(magazine);
		group.add(newspaper);
		
		addWindow.add(book);
		addWindow.add(magazine);
		addWindow.add(newspaper);
		
		book.setBounds(250, 50, 100, 20);
		magazine.setBounds(250, 70, 100, 20);
		newspaper.setBounds(250, 90, 100, 20);
		
		addWindow.setVisible(true);
		
		labelName.setBounds(220, 120, 180, 25);
		labelPrice.setBounds(220, 140, 180, 25);
		labelGenre.setBounds(220, 160, 180, 25); 
		labelCoverType.setBounds(190, 180, 180, 25); 
		labelTheYearOfPublishing.setBounds(160, 200, 180, 25); 
		labelNumberOfIssue .setBounds(170, 220, 180, 25);
		labelType.setBounds(220, 240, 180, 25); 
		labelHasAdditionalGift.setBounds(120, 260, 180, 25); 
		labelHasProgram.setBounds(90, 280, 180, 25); 
		
		name.setBounds(270, 120, 180, 25);
		price.setBounds(270, 140, 180, 25);
		genre.setBounds(270, 160, 180, 25);
		coverType.setBounds(270, 180, 180, 25);
		theYearOfPublishing.setBounds(270, 200, 180, 25);
		numberOfIssue.setBounds(270, 220, 180, 25);
		type.setBounds(270, 240, 180, 25);
		hasAdditionalGift.setBounds(270, 260, 180, 25); 
		hasProgram.setBounds(270, 280, 180, 25); 
		
		addWindow.add(labelName);
		addWindow.add(labelPrice);
		addWindow.add(labelGenre);
		addWindow.add(labelCoverType);
		addWindow.add(labelTheYearOfPublishing);
		addWindow.add(labelNumberOfIssue);
		addWindow.add(labelType);
		addWindow.add(labelHasAdditionalGift);
		addWindow.add(labelHasProgram);
		
		addWindow.add(name);
		addWindow.add(price);
		addWindow.add(genre);
		addWindow.add(coverType);
		addWindow.add(theYearOfPublishing);
		addWindow.add(numberOfIssue);
		addWindow.add(type);
		addWindow.add(hasAdditionalGift);
		addWindow.add(hasProgram);
		
		ok.setBounds(200, 330, 80, 20);
		cancel.setBounds(300, 330, 100, 20);
		
		addWindow.add(ok);
		addWindow.add(cancel);
		
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
		
		ok.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){ 
				 
				if(book.isSelected()){
					MainFrame.add(new ua.kture.printedProducts.Book(name.getText(),Double.parseDouble(price.getText()),
							genre.getText(),coverType.getText(),Integer.parseInt(theYearOfPublishing.getText())));
					
					name.setText(null);
					price.setText(null);
					genre.setText(null);
					coverType.setText(null);
					theYearOfPublishing.setText(null);
				}
				else if(magazine.isSelected()){
					MainFrame.add(new ua.kture.printedProducts.Magazine(name.getText(),Double.parseDouble(price.getText()),
							Integer.parseInt(numberOfIssue.getText()),type.getText(),
							Boolean.parseBoolean(hasAdditionalGift.getText())));
					name.setText(null);
					price.setText(null);
					numberOfIssue.setText(null);
					type.setText(null);
					hasAdditionalGift.setText(null);
				}
				else if(newspaper.isSelected()){
					MainFrame.add(new ua.kture.printedProducts.Newspaper(name.getText(),Double.parseDouble(price.getText()),
							Integer.parseInt(numberOfIssue.getText()),Boolean.parseBoolean(hasProgram.getText())));
					name.setText(null);
					price.setText(null);
					numberOfIssue.setText(null);
					hasProgram.setText(null);
					
				}	
				group.clearSelection();
				book.setSelected(false);
				magazine.setSelected(false);
				newspaper.setSelected(false);
				addWindow.setVisible(false);
				
			}
		});
		
		cancel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				
				cleandAfterCompleteing();
				
				group.clearSelection();
				book.setSelected(false);
				magazine.setSelected(false);
				newspaper.setSelected(false);
				
				addWindow.setVisible(false);		
			}
		});
		
	}
	
	public static void cleandAfterCompleteing(){
		name.setText(null);
		price.setText(null);
		genre.setText(null);
		coverType.setText(null);
		theYearOfPublishing.setText(null);
		numberOfIssue.setText(null);
		type.setText(null);
		hasAdditionalGift.setText(null);
		hasProgram.setText(null);
	}
	
}

