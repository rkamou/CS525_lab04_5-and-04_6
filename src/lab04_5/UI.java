package lab04_5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.util.*;

public class UI extends JFrame
{
	protected Container contentPane = getContentPane();
	protected Tabs tabs;


	class ProductPanel extends JPanel
	{
		ProductRecord productRecord;
		ProductButtons productButtons;

		public ProductPanel()
		{
			super(new BorderLayout());
			productRecord = new ProductRecord();
			add(productRecord, BorderLayout.NORTH);

			add(new JSplitPane(JSplitPane.VERTICAL_SPLIT), BorderLayout.CENTER);

			productButtons = new ProductButtons();
			add(productButtons, BorderLayout.SOUTH);

			productRecord.showObject(0);	// Show first one (if exists)
		}

		private class ProductRecord extends JPanel
		{
			int currentIndex = 0;	// Current product index
			Product curProd;		// Current Product object

			ProductField name;		// Product name's label and value
			ProductField desc;		// Product description's label and value
			ProductCalcValue range;	// Product's price range

			public ProductRecord()
			{
				super(new GridLayout(3,1,5,5));
				addFields();
			}


			private void addFields()
			{
				name = new ProductField("Name");
				add(name);

				desc = new ProductField("Description");
				add(desc);

				range = new ProductCalcValue("Price Range:");
				add(range);
			}


			private class ProdUIEntry extends JPanel
			{
				protected JLabel label;

				public ProdUIEntry(String labelName)
				{
					super(new GridLayout(1,2,5,5));
					label = new JLabel(labelName, JLabel.RIGHT);
					label.setForeground(new Color(0x660000));
					add(label);
				}

			}

			private class ProductField extends ProdUIEntry
			{
				protected JTextField text;

				public ProductField(String labelName)
				{
					super(labelName);
					text = new JTextField(20);
					add(text);
				}

				public void setValue(String value)
				{
					text.setText(value);
				}

				public String getValue()
				{
					return text.getText();
				}
			}

			private class ProductCalcValue extends ProdUIEntry
			{
				protected JLabel value;		// Calculated Value

				public ProductCalcValue(String labelName)
				{
					super(labelName);
					value = new JLabel("", JLabel.LEFT);
					value.setForeground(Color.black);
					add(value);
				}

				public void setValue(String val)
				{
					value.setText(val);
				}

			}

			public void readRecord(int recNumb)
			{
				curProd = (Product) Product.getManager().getObjectAt(recNumb);
				name.setValue(curProd.getName());
				desc.setValue(curProd.getDescription());
				range.setValue(curProd.getPriceRange());
			}

			public void saveCurrentRecord()
			{
				curProd.setName(name.getValue());
				curProd.setDescription(desc.getValue());
			}

			private int maxInd()
			{
				return Product.getManager().numberOfObjects() - 1;
			}

			public void showObject(int i)
			{
				if (i >= 0 && i <= maxInd())
					{
					readRecord(currentIndex = i);
					productButtons.enableButtons(currentIndex, maxInd());
					}
			}

			public void nextProduct()
			{
				if (currentIndex < maxInd())
					readRecord(++currentIndex);

				productButtons.enableButtons(currentIndex, maxInd());
			}

			public void previousProduct()
			{
				if (currentIndex > 0)
					readRecord(--currentIndex);

				productButtons.enableButtons(currentIndex, maxInd());
			}

			public void deleteRecord()
			{
				Product.getManager().delete(curProd);
				currentIndex = currentIndex <= maxInd() ? currentIndex : 0;
				showObject(currentIndex);
			}

		}	// End of ProductRecord

		private class ProductButtons extends JPanel
		{

			DeleteButton delete;
			NextButton next;
			PreviousButton prev;
			SaveButton save;

			public ProductButtons()
			{
				createButtons();
			}

			private void createButtons()
			{
				prev = (PreviousButton) add(new PreviousButton());
				next = (NextButton) add(new NextButton());
				save = (SaveButton) add(new SaveButton());
				delete = (DeleteButton) add(new DeleteButton());
			}

			public void enableButtons(int curIndex, int maxIndex)
			{
				prev.setEnabled(!(curIndex <= 0));
				next.setEnabled(!(curIndex >= maxIndex));
			}

			class PreviousButton extends JButton implements ActionListener
			{
				PreviousButton()
				{
					super("Previous");
					addActionListener(this);
				}

				public void actionPerformed(ActionEvent e)
				{
					productRecord.previousProduct();
				}
			}

			class NextButton extends JButton implements ActionListener
			{
				NextButton()
				{
					super("Next");
					addActionListener(this);
				}

				public void actionPerformed(ActionEvent e)
				{
					productRecord.nextProduct();
				}
			}

			class SaveButton extends JButton implements ActionListener
			{
				SaveButton()
				{
					super("Save");
					addActionListener(this);
				}

				public void actionPerformed(ActionEvent e)
				{
					productRecord.saveCurrentRecord();
				}
			}

			class DeleteButton extends JButton implements ActionListener
			{
				DeleteButton()
				{
					super("Delete");
					addActionListener(this);
				}

				public void actionPerformed(ActionEvent e)
				{
					productRecord.deleteRecord();
				}
			}

		}	// End of ProductButtons

	}	// End of ProductPanel


	private class Tabs extends JTabbedPane
	{
		String [] tabNames =
		{
			"Customers", "Products", "Deals"
		};


		Tabs()
		{
			JPanel [] panels =
			{
				new JPanel(), new ProductPanel(), new JPanel()
			};

			for (int i = 0; i < tabNames.length; i++)
				addTab(tabNames[i], panels[i]);
		}

	}

	public UI()
	{
		contentPane.setLayout(new FlowLayout());
		contentPane.add(tabs = new Tabs());
		setWindowProperties();
	}



	private void setWindowProperties()
	{
	setBounds(100, 100, 500, 200);
	setResizable(true);
	setVisible(true);

	setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	addWindowListener(
						new WindowAdapter()
							{
								public void windowClosed(WindowEvent e)
								{
									dispose();
									System.exit(0);
								}
							}
					 );
	}



}	// End UI class

