import java.util.Scanner; 
import java.util.LinkedList;

public class LinkedListNode 
{
	/**
	 * Using FoodItem class, will fill information for 1 node
	 * @author yeotaJMU
	 *
	 */
	
	protected LinkedList <FoodItem> food = new LinkedList<FoodItem> ();
	protected int numItemEntries;
	
	//constructor
	public LinkedListNode ()
	{
		new FoodItem();
	}
	
	//will read individual items into one linked list
	public void readFile(Scanner read)
	{	
		int entryNumber = 1; //initialize entry
		numItemEntries = read.nextInt();
		read.nextLine();
		while (entryNumber <= numItemEntries)//read in one food item at a time
		{
			FoodItem f = new FoodItem ();
			f.readItem(read);
			food.add(f);
			entryNumber++;
		}
	}

	public LinkedList<FoodItem> getFood() {
		return food;
	}

	public void setFood(LinkedList<FoodItem> food) {
		this.food = food;
	}

	public int getNumItemEntries() {
		return numItemEntries;
	}

	public void setNumItemEntries(int numItemEntries) {
		this.numItemEntries = numItemEntries;
	}
	
	
}
