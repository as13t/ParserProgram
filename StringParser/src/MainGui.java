
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MainGui
{
	private JFrame mFrame;
	private JPanel mPanel, importPanel;
	private JTextArea inputText;
	private JTextField fLocation;
	private JButton clearText;
	private JButton clearFileText;
	private JButton parseText;
	private JButton exitParse;
	private JButton fileButton;
	private JButton execButton;
	private GridLayout gridLayout;
	private String fileLoc;
	private Scanner input;
	private JFileChooser jf = new JFileChooser();
	
	public void createFrame()
	{
		mFrame = new JFrame();
		gridLayout = new GridLayout(3,1);
		mFrame.setLayout(gridLayout);
		addItems();
		
		mFrame.setSize(300, 650);
		mFrame.setLocationByPlatform(true);
		mFrame.setVisible(true);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void addItems()
	{
		mPanel = new JPanel();
		importPanel = new JPanel();

		fLocation = new JTextField(20);
		inputText = new JTextArea(10, 20);
		
		//This clears the entry
		clearText = new JButton("Clear");
		clearText.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						inputText.setText(null);
					}
				});
		
		//This parses the text in the text area
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
		
		//This exits the application
		exitParse = new JButton("Exit");
		exitParse.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}
				});
		
		fileButton = new JButton("File");
		fileButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						fLocation.setText(getFileLocation());
					}
				});
		execButton = new JButton("Execute");
		execButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						openFile(fileLoc);
						readFile();
					}
				});
		clearFileText = new JButton("Clear");
		clearFileText.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						fLocation.setText(null);
					}
				});
		
		mFrame.add(mPanel);
		mPanel.add(inputText);
		mPanel.add(exitParse);
		mPanel.add(clearText);
		mPanel.add(parseText);
		
		//This adds a the option to import a file
		mFrame.add(importPanel);
		importPanel.add(fLocation);
		importPanel.add(fileButton);
		importPanel.add(execButton);
		importPanel.add(clearFileText);
	}
	
	private String getFileLocation()
	{
		jf.setCurrentDirectory(new File(System.getProperty("user.home")));
		
		int result = jf.showOpenDialog(mFrame);
		
		if(result == JFileChooser.APPROVE_OPTION)
		{
			fileLoc = jf.getSelectedFile().getAbsolutePath();
		}
		
		return fileLoc;
	}
	
	private void openFile(String fName)
	{
		try
		{
			input = new Scanner(new File(fName));
		}
		catch(IOException ioException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}
	
	private void readFile()
	{
		while(input.hasNext())
		{
			ParseText pText = new ParseText();
			String delim = "\\s";
			
			pText.setPhrase(input.nextLine(), delim);
			pText.parsePhrase();
		}
	}
	
}
