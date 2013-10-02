import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class CategoryList extends CategoryNode
{
	/**
	 * This class will create linkedlist of categories for food items
	 * @author yeotaJMU
	 */
	
	LinkedList<CategoryNode> allCategories = new LinkedList<CategoryNode> ();
	LinkedList<FoodItem> linkedFoods = new LinkedList<FoodItem> ();
//	LinkedList<LinkedList> doubleLink = new LinkedList<LinkedList> ();
	Scanner keyboard = new Scanner (System.in);
	
	//constructor
	public CategoryList ()
	{
		super();
	}
	
	//read each category from file
	public void readCategoriesFile (Scanner read)
	{	
		int entryNumber = 1; //initialize entry
		numCatEntries = read.nextInt();
		read.nextLine();
		while (entryNumber <= numCatEntries)//read in one food item at a time
		{
			CategoryNode c = new CategoryNode ();
			c.readCategories(read);
			allCategories.add(c);
			entryNumber++;
		}
	}
	
	public void readCategoryList (String file)
	{
		Scanner scanFile = TextFileIO.createTextRead(file);
		readCategoriesFile(scanFile);
	}
	
//	//this method will convert the categories into a linked list of linked fooditems
//	public void matchedList ()
//	{
//		LinkedListClass l = new LinkedListClass ();
//		l.readFoodList(l, "foodlist.txt");
//		linkedFoods.clear();
//		doubleLink.clear();
//		int index = 0;
//		for (CategoryNode c : allCategories)
//		{
//			System.out.println("category read test");
//			for (FoodItem f : l.food)
//			{
//				System.out.println("Food read test");
//				if (f.getCategory().equalsIgnoreCase(c.getCategoryName()))
//
//				{
//					linkedFoods.add(f);
//				}
//			}
//			System.out.println("LINKED FOODS:\n" + linkedFoods.toString());
//			doubleLink.add(index, linkedFoods);
//			linkedFoods.clear();
//			System.out.println("DOUBLE LIST: \n" + doubleLink.toString());
//		}
////		System.out.println(doubleLink.toString());
//		index++;
//	}

	//add a new category
	public void addCategory ()
	{
		CategoryNode c = new CategoryNode();
		String catName = JOptionPane.showInputDialog("Enter the new category:");
		c.setCategoryName(catName);
//		c.setCategoryName(keyboard.nextLine());
		allCategories.add(c);
		rewriteAddCat();
		System.out.println("CATEGORY ADDED:\n" + c.toString());
		JOptionPane.showMessageDialog(null,"Add Successful!");
	}
	
	//method to delete category
	public void deleteCategory ()
	{
		LinkedListClass l = new LinkedListClass();
		l.readFoodList(l, "foodlist.txt");
		String catName = JOptionPane.showInputDialog("Enter the name of the category to remove:");
		int index = 0;
		boolean match = false;
		for (CategoryNode cn : allCategories)
		{
			if (catName.equalsIgnoreCase(cn.getCategoryName()))//find appropriate item to delete
			{
				int a = JOptionPane.showConfirmDialog(null, "This will permanently delete " + catName.toUpperCase() + " and all included inventory. Continue?");
				if (a == 0)
				{
					System.out.println("CATEGORY DELETED:\n" + allCategories.get(index).toString());
					allCategories.remove(index);
					rewriteCatDelete();//rewrites the file to match updated inventory
					l.deleteNode(catName);
					JOptionPane.showMessageDialog(null, "Delete successful!");
					match = true;
					break;
				}
				if (a !=0)
				{
					JOptionPane.showMessageDialog(null, "Delete Cancelled!");
				}
			}
			index++;
		}
		if (match == false)
		{
			throw new ItemNotFoundException("Category not found.");
		}
	}
	
	//update category
	public void updateCategory ()
	{
		LinkedListClass l = new LinkedListClass();
		l.readFoodList(l, "foodlist.txt");
		String catUpdate = JOptionPane.showInputDialog("Enter the category you wish to update:");
		boolean match = false;
		String newName = "";
		for (CategoryNode cn : allCategories)
		{
			if (catUpdate.equalsIgnoreCase(cn.getCategoryName()))
			{
				newName = JOptionPane.showInputDialog("Enter the updated category name:");
				cn.setCategoryName(newName);//new name for category
				System.out.println("CATEGORY UPDATED:\n" + cn.toString());
				match = true;
				break;
			}
		}
		for (FoodItem f : l.food)//update food items to match
		{
			if (catUpdate.equalsIgnoreCase(f.getCategory()))
			{
				f.setCategory(newName);
				System.out.println("ITEM UPDATED:\n" + f.toString());
			}
		}
		if (match == false)
		{
			throw new ItemNotFoundException("Catgory Not Found.");
		}
		l.rewriteUpdate();//rewrite the file to match all items in that category
		rewriteUpdateCat();
		JOptionPane.showMessageDialog(null, "Update Successful!");
	}
	
	//search category and return inventory items
	public void searchCategory (String search)
	{
		LinkedListClass l = new LinkedListClass ();
		l.readFoodList(l, "foodlist.txt");
		linkedFoods.clear();
		boolean match = false;
		for (FoodItem f : l.food)
		{
			if (f.getCategory().equalsIgnoreCase(search))
			{
				linkedFoods.add(f);
				match = true;
			}
		}
		if (match == false)//catch if category not found
		{
			throw new ItemNotFoundException("Category Not Found.");
		}
		else 
			System.out.println("SEARCH RESULTS:");
		for (FoodItem fi : linkedFoods)//for better display to console
		{
			System.out.println(fi.toString());
		}
		
	}
	
	//rewrite file to add category
	public void rewriteAddCat ()
	{
		PrintWriter outStream = TextFileIO.createTextWrite("categories.txt");
		numCatEntries = numCatEntries + 1;
		outStream.println(numCatEntries);
		for (CategoryNode cn: allCategories)
		{
			outStream.println(cn.getCategoryName());
		}
		outStream.close();
	}
	
	//rewrite file to delete category
	public void rewriteCatDelete ()
	{
		PrintWriter outStream = TextFileIO.createTextWrite("categories.txt");
		numCatEntries = numCatEntries - 1;
		outStream.println(numCatEntries);
		for (CategoryNode cn: allCategories)
		{
			outStream.println(cn.getCategoryName());
		}
		outStream.close();
	}
	
	//rewrite file for update category
	public void rewriteUpdateCat ()
	{
		PrintWriter outStream = TextFileIO.createTextWrite("categories.txt");
		numCatEntries = numCatEntries;
		outStream.println(numCatEntries);
		for (CategoryNode cn: allCategories)
		{
			outStream.println(cn.getCategoryName());
		}
		outStream.close();
	}
	
	//getters and setters
	public LinkedList<CategoryNode> getAllCategories() {
		return allCategories;
	}

	public void setAllCategories(LinkedList<CategoryNode> allCategories) {
		this.allCategories = allCategories;
	}
}
