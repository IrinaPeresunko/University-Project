package ua.kture.searchFrame;

public class InputParameters {
	
	private String definition = null;
	
	private String name = null;
	private double price = 0;
	
	private String genre = null;
	private String coverType = null;
	private int theYearOfPublishing = 0;
	private int numberOfIssue = 0;
	private String type = null;
	private boolean ifHasAdditionalGift = false;
	private boolean ifHasProgram = false;
	
	public InputParameters(String name,double price,String genre,String coverType,int theYearOfPublishing){
		this.name = name;
		if(price>0){
			this.price = price;
		}
		else{
			this.price = 0;
		}
		this.genre = genre;
		this.coverType = coverType;
		if(theYearOfPublishing>0){
			this.theYearOfPublishing = theYearOfPublishing;
		}
		else{
			this.theYearOfPublishing = 0;
		}
	}
	
	public InputParameters(String name,double price,int numberOfIssue,String type,boolean hasAdditionalGift){
		this.name = name;
		if(price>0){
			this.price = price;
		}
		else{
			this.price = 0;
		}
		if(numberOfIssue>0){
			this.numberOfIssue = numberOfIssue;
		}
		else{
			this.numberOfIssue = 0;
		}
		this.type = type;
		this.ifHasAdditionalGift = hasAdditionalGift; 
	}
	
	public InputParameters(String name,double price,int numberOfIssue,boolean hasProgram){
		this.name = name;
		if(price>0){
			this.price = price;
		}
		else{
			this.price = 0;
		}
		if(numberOfIssue>0){
			this.numberOfIssue = numberOfIssue;
		}
		else{
			this.numberOfIssue = 0;
		}
		this.ifHasProgram = hasProgram;  
	}
	
	public InputParameters(String name,double price){
		this.name = name;
		if(price>0){
			this.price = price;
		}
		else{
			this.price = 0;
		} 
	}
			
	public String getName() {
		return name;
	}
	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCoverType() {
		return coverType;
	}
	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}
	public int getTheYearOfPublishing() {
		return theYearOfPublishing;
	}
	public void setTheYearOfPublishing(int theYearOfPublishing) {
		this.theYearOfPublishing = theYearOfPublishing;
	}
	public int getNumberOfIssue() {
		return numberOfIssue;
	}
	public void setNumberOfIssue(int numberOfIssue) {
		this.numberOfIssue = numberOfIssue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isIfHasAdditionalGift() {
		return ifHasAdditionalGift;
	}
	public void setIfHasAdditionalGift(boolean ifHasAdditionalGift) {
		this.ifHasAdditionalGift = ifHasAdditionalGift;
	}
	public boolean isIfHasProgram() {
		return ifHasProgram;
	}
	public void setIfHasProgram(boolean ifHasProgram) {
		this.ifHasProgram = ifHasProgram;
	}

}
