package Model;

import java.util.ArrayList;

public class BookManagementModel {
	private ArrayList<BookInformation> arrBookInformations;
	
	public BookManagementModel() {
		// TODO Auto-generated constructor stub
		this.arrBookInformations = new ArrayList<BookInformation>();
	}
	
	public BookManagementModel (ArrayList<BookInformation> arrayBookInformations) {
		this.arrBookInformations = arrayBookInformations;
	}

	public ArrayList<BookInformation> getArrBookInformations() {
		return arrBookInformations;
	}

	public void setArrBookInformations(ArrayList<BookInformation> arrBookInformations) {
		this.arrBookInformations = arrBookInformations;
	}
	
	public void insert(BookInformation bookInformation) {
		this.arrBookInformations.add(bookInformation);
	}
	
	public void delete(BookInformation bookInformation) {
		this.arrBookInformations.remove(bookInformation);
	}
	
	public void update(BookInformation bookInformation) {
		this.arrBookInformations.remove(bookInformation);
		this.arrBookInformations.add(bookInformation);
	}
}
