package ua.kture.searchFrame;

import ua.kture.printedProducts.*;

public class ComparingAndSearching {
	
	public int compareByNameOfNeededClass(PrintedProduct product,String nameOfClass){
		System.out.println(product.getClass().getSimpleName());
		if(product.getClass().getSimpleName().equals(nameOfClass) || nameOfClass.equals("All")){
			return 0;
		}
		return 1;
	}
	public int compareByName(PrintedProduct product,String name){
		if(name!=null){
			if(product.getNameOfProduct().equals(name)){
				return 0;
			}
			return 1;
		}
		return -1;
	}
	public int compareByPrice(PrintedProduct product,double price){
		if(price > 0){
			if(product.getPrice() == price){
				return 0;
			}	
		return 1;
		}
		return -1;
	}
	public int compareByGenre(PrintedProduct product,String genre){
		if(genre!=null){
			if((((Book) product).getGenre()).equals(genre)){
				return 0;
			}
			return 1;
		}
		return -1;
	}
	public int compareByCoverType(PrintedProduct product,String coverType){
		if(coverType!=null){
			if(((Book) product).getCoverType().equals(coverType)){
				return 0;
			}
			return 1;
		}
		return -1;
	}
	public int compareByYearOfPublishing(PrintedProduct product,int theYearOfPublishing){
		if(theYearOfPublishing > 0){
			if(((Book) product).getTheYearOfPublishing() == theYearOfPublishing){
				return 0;
			}	
		return 1;
		}
		return -1;
	}
	public int compareByNumberOfIssueOfMagazine(PrintedProduct product,int numberOfIssue){
		if(numberOfIssue > 0){
			if(((Magazine) product).getNumberOfIssue() == numberOfIssue){
				return 0;
			}	
		return 1;
		}
		return -1;
	}
	public int compareByNumberOfIssueOfNewspaper(PrintedProduct product,int numberOfIssue){
		if(numberOfIssue > 0){
			if(((Newspaper) product).getNumberOfIssue() == numberOfIssue){
				return 0;
			}	
		return 1;
		}
		return -1;
	}
	public int compareByType(PrintedProduct product,String type){
		if(type!=null){
			if(((Magazine) product).getType().equals(type)){
				return 0;
			}
		return 1;
		}
		return -1;
	}
	public int compareByIfHasAdditionalGift(PrintedProduct product,boolean ifHasAdditionalGift){
		if(((Magazine) product).getIfMagazineHasAdditionalGift()==ifHasAdditionalGift){
			return 0;
		}
		return 1;
	}
	public int compareByIfHasProgram(PrintedProduct product,boolean ifHasProgram){
		if(((Newspaper) product).isHasProgram()==ifHasProgram){
			return 0;
		}
		return 1;
	}
	
	public boolean search(String definition,PrintedProduct product,InputParameters parameters){
		
		switch(definition){
			case "Book": return searchBook(product,parameters); 
			case "Magazine" : return searchMagazine(product,parameters);
			case "Newspaper" : return searchNewspaper(product,parameters);
			case "All": return searchAll(product,parameters);
		}
		return false;
	}
	public boolean searchBook(PrintedProduct product, InputParameters parameters){
		if(compareByNameOfNeededClass(product,parameters.getDefinition())!=1){
			if(compareByName(product,parameters.getName())!=1 ||
					product.getNameOfProduct().contains(parameters.getName())){
				if(compareByPrice(product,parameters.getPrice())!=1){
					if(compareByGenre(product,parameters.getGenre())!=1){
						if(compareByCoverType(product,parameters.getCoverType())!=1){
							if(compareByYearOfPublishing(product,parameters.getTheYearOfPublishing())!=1){
								return true;
							}
							return false;
						}
						return false;
					}
				return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	public boolean searchMagazine(PrintedProduct product, InputParameters parameters){
		if(compareByNameOfNeededClass(product,parameters.getDefinition())!=1){
			if(compareByName(product,parameters.getName())!=1 ||
					product.getNameOfProduct().contains(parameters.getName())){
				if(compareByPrice(product,parameters.getPrice())!=1){
					if(compareByNumberOfIssueOfMagazine(product,parameters.getNumberOfIssue())!=1){
						if(compareByType(product,parameters.getType())!=1){
							if(compareByIfHasAdditionalGift(product,parameters.isIfHasAdditionalGift())!=1){
								return true;
							}
							return false;
						}
						return false;
					}
				return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	public boolean searchNewspaper(PrintedProduct product, InputParameters parameters){
		if(compareByNameOfNeededClass(product,parameters.getDefinition())!=1){
			if(compareByName(product,parameters.getName())!=1 ||
					product.getNameOfProduct().contains(parameters.getName())){
				if(compareByPrice(product,parameters.getPrice())!=1){
					if(compareByNumberOfIssueOfNewspaper(product,parameters.getNumberOfIssue())!=1){
						if(compareByIfHasProgram(product,parameters.isIfHasProgram())!=1){
							return true;
						}
					return false;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	public boolean searchAll(PrintedProduct product, InputParameters parameters){
		if(compareByName(product,parameters.getName())!=1 ||
				product.getNameOfProduct().contains(parameters.getName())){
			if(compareByPrice(product,parameters.getPrice())!=1){
				return true;
			}
			return false;
		}
		return false;
	}
	
}
