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
	
	public void readCategories (Scanner read)
	{
		categoryName = read.nextLine();
	}
	
	public String toString ()
	{
		return ("Category Name: " + categoryName);
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
