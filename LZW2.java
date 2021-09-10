import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.math.BigInteger;

public class LZW2 {
	HashMap dictionary = new HashMap(); 
//	char previousChar; //P
//	char currentChar; //C
	int currentNum = 256; 
	String full = ""; 
	String binaryString = ""; 
	
	String output3; 

	ArrayList<String> output; 
	ArrayList<Integer> output1; 

	public LZW2(String filename) throws FileNotFoundException
	{
		
		output = new ArrayList<String>(); 
		output1 = new ArrayList<Integer>(); 
	
		output3 = ""; 
		String output1 = ""; 
		for(int letter= 0;letter<256;letter++)
		{
			//dictionary.put(letter, (int)letter);
			dictionary.put(""+(char)letter,letter); 
			
		}
		
		Scanner reader = new Scanner(new File(filename)); 
		 while (reader.hasNextLine())
		 {
			 full += reader.nextLine(); 
		 }
		 reader.close();
		this.compress(); 
		
	}

	public void NextNum()
	{
		currentNum += 1; 
	}
	



	public void compress()
	{
		char currentChar = '\0'; 
		String previous = ""; 
		
		String previousPlusCurrent = "";

		for(int index = 0; index <full.length(); index ++)
		{
			 currentChar = full.charAt(index); 
			 System.out.println(currentChar); 
			 previousPlusCurrent = previous+currentChar; 
			 if(dictionary.containsKey(previousPlusCurrent))
			 {
				 previous = previousPlusCurrent;
			 }
			 
			 else
			 {	
				 if(previous != "")
				 {
				 output.add(previous); 
				 System.out.println(previous);
//				 output3+=(currentNum); 
				 
//				 output1+= dictionary.get(previous);
				
				 char [] ascii = new char[previousPlusCurrent.length()];
				 for(int i = 0; i< previousPlusCurrent.length(); i ++) {
					 ascii[i] = previousPlusCurrent.charAt(i); 
				 }
				 }
				 //dictionary.put(previousPlusCurrent,this.AsciiToBinary(previousPlusCurrent)); 
				dictionary.put(previousPlusCurrent,currentNum); 
//				dictionary.put(previousPlusCurrent,Integer.toBinaryString(currentNum)); 
				 
				 this.NextNum();
				 previous = ""+currentChar;
				 
			 }
		}
		
		for(int i = 0; i < output.size(); i ++)
		{
			Integer okay = (Integer) dictionary.get(output.get(i));
			
			output1.add(okay);
			
		}
		
		for(int i = 0; i < output1.size(); i++)
		{
		
			output.set(i, Integer.toBinaryString(output1.get(i))); 
			
			
		}
		
		
		for(int i = 0; i < output1.size(); i++)
		{
		
			binaryString += output.get(i); 
			
			
		}
		
		BinaryOut out = new BinaryOut("output.dat");
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '0') {
                out.write(false);
            } else {
                out.write(true);
            }
        }
        out.flush();
		
	
	}
	
	public String full()
	{
		return this.full; 
	}
	
	public ArrayList output()
	{
		return this.output; 
	}
	
	public HashMap dictionary()
	{
		return this.dictionary; 
	}



	
}