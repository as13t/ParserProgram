import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MainGui
{
	private JFrame mFrame;
	private JPanel mPanel;
	private JTextArea inputText;
	private JButton clearText;
	private JButton parseText;
	private JButton exitParse;
	
	public void createFrame()
	{
		mFrame = new JFrame();
		addItems();
		
		mFrame.setSize(300, 300);
		mFrame.setVisible(true);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void addItems()
	{
		mPanel = new JPanel();
		
		inputText = new JTextArea(10, 20);
		clearText = new JButton("Clear");
		clearText.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						inputText.setText(null);
					}
				});
		
		parseText = new JButton("Execute");
		parseText.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					ParseText pText = new ParseText();
					String delim = "\\s";
					
					pText.setPhrase(inputText.getText(), delim);
					pText.parsePhrase();
				}
			});
		
		exitParse = new JButton("Exit");
		exitParse.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}
				});
		
		mFrame.add(mPanel);
		mPanel.add(inputText);
		mPanel.add(clearText);
		mPanel.add(exitParse);
		mPanel.add(parseText);
		
		
	}
}
