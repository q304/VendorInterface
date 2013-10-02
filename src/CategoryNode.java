import java.util.Scanner; 
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CategoryNode extends LinkedListNode
{
	/**
	 * Class to read in a single category
	 * @author yeotaJMU
	 */
	protected int numCatEntries;
	private String categoryName;

	//constructor
	public CategoryNode ()
	{
		super();
		categoryName = "";
	}
	
	//read line in file
	public void readCategories (Scanner read)
	{
		categoryName = read.nextLine();
	}
	
	//to string method
	public String toString ()
	{
		return ("Category Name: " + categoryName + "\n");
	}
	
	public int getNumCatEntries() {
		return numCatEntries;
	}

	public void setNumCatEntries(int numCatEntries) {
		this.numCatEntries = numCatEntries;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
