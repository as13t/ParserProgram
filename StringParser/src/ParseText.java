
public class ParseText 
{
	private String textPhrase;
	private String delim;
	
	public void setPhrase(String text, String delim)
	{
		textPhrase = text;
		this.delim = delim;
	}
	
	public void parsePhrase()
	{
		String[] token = textPhrase.split(delim);
		ParserStructure pStruct= new ParserStructure();
		
		for(int i = 0; i < token.length; i++)
		{
			pStruct.addItem(token[i]);
		}
		
		pStruct.displayMap();
	}
}
