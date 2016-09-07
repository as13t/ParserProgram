import java.util.Scanner;


public class MainParser 
{

	/**
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
/*		ParseText pText = new ParseText();
		
		Scanner input = new Scanner(System.in);
		String delim = "\\s";
		String phrase;
		
		System.out.println("Enter a phrase: ");
		phrase = input.nextLine();
		
		pText.setPhrase(phrase, delim);
		pText.parsePhrase();*/
		
		MainGui mGui = new MainGui();
		mGui.createFrame();
	}

}
