import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VendorGUI  extends JPanel
{
	/**
	 * GUI interface for Vendor Administrator
	 * @author yeotaJMU
	 */
	//initialize JPanel
	JPanel titlePanel = new JPanel();
	JPanel itemSearchPanel = new JPanel();
	JPanel categorySearchPanel = new JPanel();
	JPanel addButtonPanel = new JPanel();
	JPanel deleteButtonPanel = new JPanel();
	JPanel updateButtonPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	
	//initialize JLabel
	JLabel titleLabel = new JLabel();
	JLabel itemSearchLabel = new JLabel();
	JLabel categorySearchLabel = new JLabel();
	JLabel addButtonLabel = new JLabel ();
	JLabel deleteButtonLabel = new JLabel ();
	JLabel updateButtonLabel = new JLabel ();	
	JLabel bottomLabel = new JLabel ();
	
	//initialize JButton
	JButton itemSearchButton = new JButton();
	JButton categorySearchButton = new JButton();
	JButton addItemButton = new JButton();
	JButton addCategoryButton = new JButton();
	JButton deleteItemButton = new JButton();
	JButton deleteCategoryButton = new JButton ();
	JButton updateItemButton = new JButton();
	JButton updateCategoryButton = new JButton();
	JButton clearButton = new JButton();

	//initialize textfield
	JTextField searchTextField = new JTextField(15);
	JTextField searchTextField1 = new JTextField(15);

	//constructor; Variables are given initial values
	public VendorGUI() 
	{ 
		//set panel layout
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		itemSearchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		categorySearchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addButtonPanel.setLayout(new FlowLayout (FlowLayout.CENTER));
		deleteButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		updateButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//set font and size
		Font quizBigFont = new Font("Helvetica Bold", Font.BOLD, 30);
		Font quizMidFont = new Font("Helvetica Bold", Font.BOLD, 20);
		titleLabel.setFont(quizBigFont);
		itemSearchPanel.setFont(quizMidFont);
		categorySearchPanel.setFont(quizMidFont);
		searchTextField.setFont(quizMidFont);
		searchTextField1.setFont(quizMidFont);
		
		//set up labels
		titleLabel.setText("Vendor Administrator Interface");
		itemSearchLabel.setText("Search Inventory:");
		categorySearchLabel.setText("Search Category:");
		clearButton.setText(" Clear ");
		itemSearchButton.setText(" Search ");
		categorySearchButton.setText(" Search ");
		addItemButton.setText(" Add Item ");
		addCategoryButton.setText(" Add Category ");
		addItemButton.setBackground(Color.GREEN);
		addCategoryButton.setBackground(Color.GREEN);
		deleteItemButton.setText(" Delete Item" );
		deleteCategoryButton.setText(" Delete Category " );
		deleteItemButton.setBackground(Color.RED);
		deleteCategoryButton.setBackground(Color.RED);
		updateItemButton.setText(" Update Item ");
		updateCategoryButton.setText( " Update Category");
		updateItemButton.setBackground(Color.YELLOW);
		updateCategoryButton.setBackground(Color.YELLOW);
		
		//adding actionlistener to each button
		itemSearchButton.addActionListener(new itemSearchButton());
		categorySearchButton.addActionListener(new categorySearchButton());
		addItemButton.addActionListener(new addItemButton());
		addCategoryButton.addActionListener(new addCategoryButton());
		deleteItemButton.addActionListener(new deleteItemButton());
		deleteCategoryButton.addActionListener(new deleteCategoryButton());
		updateItemButton.addActionListener(new updateItemButton());
		updateCategoryButton.addActionListener(new updateCategoryButton());
		clearButton.addActionListener(new clearButton());

		//add items to each panel
		titlePanel.add(titleLabel);
		itemSearchPanel.add(itemSearchLabel);
		itemSearchPanel.add(searchTextField);
		itemSearchPanel.add(itemSearchButton);
		categorySearchPanel.add(categorySearchLabel);
		categorySearchPanel.add(searchTextField1);
		categorySearchPanel.add(categorySearchButton);
		addButtonPanel.add(addItemButton);
		addButtonPanel.add(addCategoryButton);
		deleteButtonPanel.add(deleteItemButton);
		deleteButtonPanel.add(deleteCategoryButton);
		updateButtonPanel.add(updateItemButton);
		updateButtonPanel.add(updateCategoryButton);
		bottomPanel.add(clearButton);
		
		//add panels to frame
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(titlePanel);
		add(itemSearchPanel);
		add(categorySearchPanel);
		add(addButtonPanel);
		add(deleteButtonPanel);
		add(updateButtonPanel);
		add(bottomPanel);
	}

	//controls the frame and display
	public void display()
	{ 
		JFrame theFrame = new JFrame("Vendor GUI");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setContentPane(this);
		theFrame.setPreferredSize(new Dimension(490, 380));
		theFrame.pack();
		theFrame.setVisible(true);
	}

	//for item search button
	class itemSearchButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			LinkedListClass l = new LinkedListClass();
			l.readFoodList(l, "foodlist.txt");
			String search = searchTextField.getText();
			l.searchNode(search);
		}
	}
	
	//for class search button
	class categorySearchButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			LinkedListClass l = new LinkedListClass();
			l.readFoodList(l, "foodlist.txt");
			CategoryList c = new CategoryList ();
			c.readCategoryList("categories.txt");
			String search = searchTextField1.getText();
			c.searchCategory(search);
		}
	}

	//for add item button
	class addItemButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			LinkedListClass l = new LinkedListClass ();
			l.readFoodList(l, "foodlist.txt");
			l.addNode();
		}
	}
	
	//for add category button
	class addCategoryButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			CategoryList c = new CategoryList ();
			c.readCategoryList("categories.txt");
			c.addCategory();
		}
	}
	
	//for add item button
	class deleteItemButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			LinkedListClass l = new LinkedListClass();
			l.readFoodList(l, "foodlist.txt");
			l.deleteNode();
		}
	}
	
	//for delete category button
	class deleteCategoryButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			CategoryList c = new CategoryList ();
			c.readCategoryList("categories.txt");
			c.deleteCategory();
		}
	}

	//for update item button
	class updateItemButton implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			LinkedListClass l = new LinkedListClass();
			l.readFoodList(l, "foodlist.txt");
			l.updateNode();
		}
	}
	
	//for update category buton
	class updateCategoryButton implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			CategoryList c = new CategoryList ();
			c.readCategoryList("categories.txt");
			c.updateCategory();
		}
	}
	//for clear button
	class clearButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			searchTextField.setText("");// erases the values of this JTextField
			searchTextField1.setText("");// erases the values of this JTextField
		}
	}
}