import java.util.HashMap;

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
		for(String key: hm.keySet())
		{
			System.out.println(key + " = " + hm.get(key));
		}
	}
	
}
