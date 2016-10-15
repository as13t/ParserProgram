import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// This will be using the hashmap to keep a running count of all words parsed within the given text.

public class ParserStructure 
{
	HashMap<String,Integer> hm = new HashMap<String,Integer>();
	
	String word;
	int count;
	
	public void addItem(String word)
	{
		if(hm.containsKey(word))
		{
			count = hm.get(word);
			count = count + 1;
			
			hm.put(word, count);
		}
		else
		{
			hm.put(word, 1);
		}
	}
	
	public void displayMap()
	{
		/*for(String key: hm.keySet())
		{
			System.out.println(key + " = " + hm.get(key));
		}*/
		JFrame dFrame = new JFrame();
		JPanel pt = new JPanel();
		DefaultTableModel dtm = new DefaultTableModel();
		
		dtm.addColumn("Word");
		dtm.addColumn("Count");
		
		JTable tb = new JTable(dtm);
		
		for(String key: hm.keySet())
		{
			dtm.addRow(new Object[] {key, hm.get(key)});
		}
		
		pt.add(tb);
		dFrame.add(pt);
		
		dFrame.setSize(600, 600);
		dFrame.setVisible(true);
		dFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
