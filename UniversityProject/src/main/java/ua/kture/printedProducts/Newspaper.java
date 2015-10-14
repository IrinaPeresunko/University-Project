package ua.kture.printedProducts;

public class Newspaper extends PrintedProduct{

	private int numberOfIssue;
	private boolean hasProgram;
	
	/*
	 * empty constructor
	 */
	public Newspaper(){
		super();
		this.numberOfIssue = 0;
		this.hasProgram = false;
	}
	
	/*
	 * constructor with parameters
	 */
	public Newspaper(String name, double price, int numberOfIssue,boolean hasProgram){
		super(name,price);
		if(numberOfIssue>0){
			this.numberOfIssue = numberOfIssue;
		}
		else{
			this.numberOfIssue = 0;
		}
		this.hasProgram = hasProgram; 
	}
	
	public int getNumberOfIssue() {
		return numberOfIssue;
	}

	public void setNumberOfIssue(int numberOfIssue) {
		this.numberOfIssue = numberOfIssue;
	}

	public boolean isHasProgram() {
		return hasProgram;
	}

	public void setHasProgram(boolean hasProgram) {
		this.hasProgram = hasProgram;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (hasProgram ? 1231 : 1237);
		result = prime * result + numberOfIssue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Newspaper other = (Newspaper) obj;
		if (hasProgram != other.hasProgram)
			return false;
		if (numberOfIssue != other.numberOfIssue)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append("numberOfIssue=").append(numberOfIssue)
				.append(", hasProgram=").append(hasProgram).append("]");
		return builder.toString();
	}

	@Override
	public String getDescriptionOfProduct() {
		StringBuilder builder = new StringBuilder();
		builder.append("The name of newspaper is ").append(this.getNameOfProduct())
			.append(". The price of newspaper is ").append(this.getPrice())
			.append(". The number of issue of newspaper is ")
			.append(this.numberOfIssue).append(". ");
		if(this.hasProgram == true){
			builder.append("This number of issue has the program");
		}
		else{
			builder.append("Unfortunately,this number of issue doesn't have the program");
		}
		return builder.toString();
	}

}
