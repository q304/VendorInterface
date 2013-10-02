import java.util.Scanner;
import java.text.DecimalFormat;
	
public class FoodItem 
{
	/**
	 * Defines 1 food item
	 * @author yeotaJMU
	 */

	private String category;
	private String name;
	private double price;
	private int quantity;
	private String description;
	private String size;
	private int entryNumber;
	
	DecimalFormat m = new DecimalFormat("##.00");//for money
	
	//constructor
	public FoodItem ()
	{
		category = "";
		name = "";
		price = 0.0;
		quantity = 0;
		description = "";
		size = "";
	}
	
	//read an item from binary file
	public void readItem (Scanner read)
	{
		category = read.nextLine();
		name = read.nextLine();
		price = read.nextDouble();
		read.nextLine();
		quantity = read.nextInt();
		read.nextLine();
		description = read.nextLine();
		size = read.nextLine();
	}

	//to string method
	public String toString()
	{
		return ("Name: " + name +
				"\nPrice: $" + m.format(price) +
				"\nQuantity: " + quantity +
				"\nDescription: " + description +
				"\nSize: " + size +
				"\n");
				
	}
	
	//getters and setters
	public String getName() {
		return name;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getEntryNumber() {
		return entryNumber;
	}

	public void setEntryNumber(int entryNumber) {
		this.entryNumber = entryNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
