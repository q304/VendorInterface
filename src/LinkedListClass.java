import java.io.PrintWriter; 
import java.util.Scanner;
import javax.swing.JOptionPane;

public class LinkedListClass extends LinkedListNode
{
	/**
	 * Will create a linked list of all food items
	 * @author yeotaJMU
	 */
	
	Scanner keyboard = new Scanner (System.in);
	
	//constructor
	public LinkedListClass ()
	{
		super();
	}
	
	//read in from the file the entire list of food items
	public void readFoodList (LinkedListNode l, String file)
	{
		Scanner scanFile = TextFileIO.createTextRead(file);
		l.readFile(scanFile);
	}
	
	//method to add a node
	public void addNode ()
	{
		CategoryList c = new CategoryList ();//instantiate to check for category match
		c.readCategoryList("categories.txt");
		boolean match = false;
		FoodItem n = new FoodItem ();
		String cat = JOptionPane.showInputDialog("Enter a category for the new item:");
		for (CategoryNode cl : c.allCategories)
		{
			if (cat.equalsIgnoreCase(cl.getCategoryName()))
			{
				match = true;
				break;
			}
		}
		if (match == false)
		{
			throw new ItemNotFoundException ("Category Does Not Exist.");
		}
		else
			n.setCategory(cat);
		String na = JOptionPane.showInputDialog("Enter a name for the new item:");
		n.setName(na);
		double cost = Double.parseDouble(JOptionPane.showInputDialog("Enter a price for the new item:"));
		n.setPrice(cost);
		int quan = Integer.parseInt(JOptionPane.showInputDialog("Enter a quantity for the new item:"));
		n.setQuantity(quan);
		String des = JOptionPane.showInputDialog("Enter a description for the new item:");
		n.setDescription(des);
		String si = JOptionPane.showInputDialog("Enter a size for the new item:");
		n.setSize(si);
		food.add(n);
		rewriteAdd();
		System.out.println("ITEM ADDED:\n" + n.toString());
		JOptionPane.showMessageDialog(null,"Add successful!");
	}
	
	//method to delete a node
	public void deleteNode ()
	{
		String name = JOptionPane.showInputDialog("Enter the name of the item to remove:");
		int index = 0;
		boolean match = false;
		for (FoodItem f : food)
		{
			if (name.equalsIgnoreCase(f.getName()))//find appropriate item to delete
			{
				int a = JOptionPane.showConfirmDialog(null, "This will permanently delete item " + name.toUpperCase() + ". Continue?");
				if (a == 0)
				{
					System.out.println("ITEM DELETED:\n" + food.get(index).toString());
					food.remove(index);
					rewriteDelete();//rewrites the file to match updated inventory
					JOptionPane.showMessageDialog(null, "Delete successful!");
					match = true;
					break;
				}
				if (a != 0)
				{
					JOptionPane.showMessageDialog(null, "Delete Cancelled!");
					match = true;
					break;
				}
			}
			index++;
		}
		if (match == false)
		{
			throw new ItemNotFoundException("Item not found in inventory.");
		}
	}
	
	//helper method if category is deleted
	public void deleteNode (String name)
	{
		int index = 0;
		int cycles = numItemEntries;
		while (index < cycles)
		{
			for (FoodItem f : food)
			{
				if (name.equalsIgnoreCase(f.getCategory()))//find appropriate item to delete
				{
					System.out.println("ITEM DELETED:\n" + f.toString());
					food.remove();
					break;
				}
			}
		index++;
		}
		rewriteDelete();//update inventory file
	}

	//search linked list for matching item name
	public void searchNode (String search)
	{
		boolean match = false;
		for (FoodItem f: food)
		{
			if (search.equalsIgnoreCase(f.getName()))
			{
				System.out.println("SEARCH RESULTS:");
				System.out.println(f.toString());
				match = true;
				break;
			}
		}
		if (match == false)
		{
			throw new ItemNotFoundException("Item not found in inventory.");
		}
	}
	
	//method to update the node
	public void updateNode ()
	{
		String update = JOptionPane.showInputDialog("Enter the name of the item you wish to update:");
		boolean match = false;
		for (FoodItem f: food)
		{
			if (update.equalsIgnoreCase(f.getName()))
			{
				String change = JOptionPane.showInputDialog("Enter the information you desire to change:");
				switch (change.toLowerCase())//category to change
				{
				case "name":
					String newName = JOptionPane.showInputDialog("Enter the new name:");
					f.setName(newName);
					System.out.println("ITEM UPDATED:\n" + f.toString());
					rewriteUpdate();
					JOptionPane.showMessageDialog(null, "Update successful!");
					break;
				case "price":
					double newPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter the new price:"));
					f.setPrice(newPrice);
					System.out.println("ITEM UPDATED:\n" + f.toString());
					rewriteUpdate();
					JOptionPane.showMessageDialog(null, "Update successful!");
					break;
				case "quantity":
					int newQuant = Integer.parseInt(JOptionPane.showInputDialog("Enter the new quantity:"));
					f.setQuantity(newQuant);
					System.out.println("ITEM UPDATED:\n" + f.toString());
					rewriteUpdate();
					JOptionPane.showMessageDialog(null, "Update successful!");
					break;
				case "description":
					String newDes = JOptionPane.showInputDialog("Enter a new description:");
					f.setDescription(newDes);
					System.out.println("ITEM UPDATED:\n" + f.toString());
					rewriteUpdate();
					JOptionPane.showMessageDialog(null, "Update successful!");
					break;
				case "size":
					String newSize = JOptionPane.showInputDialog("Enter a new size:");
					f.setSize(newSize);
					System.out.println("ITEM UPDATED:\n" + f.toString());
					rewriteUpdate();
					JOptionPane.showMessageDialog(null, "Update successful!");
					break;
				default:
					new ItemNotFoundException("Information category does not exist.");
				}
				match = true;
				break;
			}
		}
		if (match == false)//to catch if not found
		{
			throw new ItemNotFoundException("Item not found in inventory.");
		}
		
	}
	
	//rewrite methods update the list of nodes in the binary file
	private void rewriteAdd ()
	{
		PrintWriter outStream = TextFileIO.createTextWrite("foodlist.txt");
		numItemEntries = food.size();
		outStream.println(numItemEntries);
		for (FoodItem fi: food)
		{
			outStream.println(fi.getCategory());
			outStream.println(fi.getName());
			outStream.println(fi.getPrice());
			outStream.println(fi.getQuantity());
			outStream.println(fi.getDescription());
			outStream.println(fi.getSize());
		}
		outStream.close();
	}
	
	private void rewriteDelete ()
	{
		PrintWriter outStream = TextFileIO.createTextWrite("foodlist.txt");
		numItemEntries = food.size();
		outStream.println(numItemEntries);
		for (FoodItem fi: food)
		{
			outStream.println(fi.getCategory());
			outStream.println(fi.getName());
			outStream.println(fi.getPrice());
			outStream.println(fi.getQuantity());
			outStream.println(fi.getDescription());
			outStream.println(fi.getSize());
		}
		outStream.close();
	}
	
	protected void rewriteUpdate ()//protected so it can be used after category update
	{
		PrintWriter outStream = TextFileIO.createTextWrite("foodlist.txt");
		numItemEntries = food.size();
		outStream.println(numItemEntries);
		for (FoodItem fi: food)
		{
			outStream.println(fi.getCategory());
			outStream.println(fi.getName());
			outStream.println(fi.getPrice());
			outStream.println(fi.getQuantity());
			outStream.println(fi.getDescription());
			outStream.println(fi.getSize());
		}
		outStream.close();
	}
}
