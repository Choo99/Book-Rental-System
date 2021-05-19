package model;

public class Book {

	private int bookID;
	private String title;
	private String author;
	private String status;
	private int typeID;
	private String typeName;
	private double price;
	private int copyID;
	private String condition;
	private int availableUnit;

	// constructor
	public Book() {
	}

	// All the Getter Setter
	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCopyID() {
		return copyID;
	}

	public void setCopyID(int copyID) {
		this.copyID = copyID;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getAvailableUnit() {
		return availableUnit;
	}

	public void setAvailableUnit(int availableUnit) {
		this.availableUnit = availableUnit;
	}

/////////////////
}
