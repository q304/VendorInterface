
public class Driver 
{
	/**
	 * Driver class will prompt GUI or run as console program as desired
	 * @author yeotaJMU
	 *
	 */
	public static void main(String[] args) 
	{
//		LinkedListClass l = new LinkedListClass();
//		l.readFoodList(l, "foodlist.txt");
//		System.out.println(l.food.toString());
//		l.addNode();
//		l.deleteNode();
//		l.searchNode();
//		l.updateNode();
//		CategoryList c = new CategoryList ();
//		c.readCategoryList("categories.txt");
//		c.addCategory();
//		c.deleteCategory();
//		c.updateCategory();
//		c.searchCategory();
		
		VendorGUI console = new VendorGUI();
		console.display();
	}

}
