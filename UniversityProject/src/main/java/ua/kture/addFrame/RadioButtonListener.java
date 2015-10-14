package ua.kture.addFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RadioButtonListener implements ActionListener{
	
	JTextField name = new JTextField("name");
	JTextField price = new JTextField("price");
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton button = (JRadioButton) e.getSource();
		
		String value = button.getText();
		
		switch(value){
			case "Book": createFieldsForBook();break;
			case "Magazine": createFieldsForMagazine(); break;
			case "Newspaper": createFieldsForNewspaper(); break;
		}
		
	}
	
	public void createFieldsForBook(){
		
		JTextField genre = new JTextField("genre");
		JTextField coverType = new JTextField("type of cover");
		JTextField theYearOfPublishing = new JTextField("year of publishing");
		
		name.setBounds(250, 100, 100, 20);
		price.setBounds(250, 120, 100, 20);
		genre.setBounds(250, 140, 100, 20);
		coverType.setBounds(250, 160, 100, 20);
		theYearOfPublishing.setBounds(250, 180, 100, 20);
	}
	
	public void createFieldsForMagazine(){
		
		JTextField numberOfIssue = new JTextField("number of issue");
		JTextField type = new JTextField("type");
		JTextField hasAdditionalGift = new JTextField("Does magazine have gift?");
	}
	
	public void createFieldsForNewspaper(){
		
		JTextField numberOfIssue = new JTextField("number of issue");
		JTextField hasProgram = new JTextField("Does newspaper have program?");
	}
}
