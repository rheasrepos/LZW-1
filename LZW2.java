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

	ArrayList<String> strOutput; 
	ArrayList<Integer> intOutput; 

	public LZW2(String filename) throws FileNotFoundException
	{
		
		strOutput = new ArrayList<String>(); 
		intOutput = new ArrayList<Integer>(); 
	
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
		 reader.close(); // notes - rhea - they read the file into a string rather than just doing it as they read the file
		
	}

	public void NextNum()
	{
		currentNum += 1; 
	}
	



	public void compress()
    {
        char currentChar = '\0'; //noteRhea - what?
        String previous = ""; 

        String previousPlusCurrent = "";

        for(int index = 0; index <full.length(); index ++)
        {
            currentChar = full.charAt(index); 
            previousPlusCurrent = previous+currentChar; 
            if(dictionary.containsKey(previousPlusCurrent))
            {
                previous = previousPlusCurrent;
            }
            else
            {	
                if(previous != "")
                {
                    strOutput.add(previous); 
                }
                //dictionary.put(previousPlusCurrent,this.AsciiToBinary(previousPlusCurrent)); 
                dictionary.put(previousPlusCurrent,currentNum); 
                //				dictionary.put(previousPlusCurrent,Integer.toBinaryString(currentNum)); 

                this.NextNum();
                previous = ""+currentChar;

            }
        }

        for(int i = 0; i < strOutput.size(); i ++)
        {
            Integer okay = (Integer) dictionary.get(strOutput.get(i));

            intOutput.add(okay);

        }

        for(int i = 0; i < intOutput.size(); i++)
        {

            strOutput.set(i, Integer.toBinaryString(intOutput.get(i))); 

        }

        for(int i = 0; i < intOutput.size(); i++)
        {

            binaryString += strOutput.get(i); 

        }
        /*
        BinaryOut out = new BinaryOut("output.dat");
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '0') {
                out.write(false);
            } else {
                out.write(true);
            }
        }
        out.flush();*/

    }

    public void decode()
    {
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        for(int letter= 0;letter<256;letter++)
        {
            map.put(letter, ""+(char)letter); 

        }// note rhea , initalizes ascii values that already exist

        int counter = 256;
        String firstLetOfNxt = "";

        for(int i = 0; i < intOutput.size()-1; i++)
        {
            Integer currInt = intOutput.get(i);
            String currStr = map.get(currInt);
            Integer nextInt = intOutput.get(i+1);
            String nextStr = map.get(nextInt);

            
            //have to add case of 262 
            if(!map.containsKey(nextInt)) {
            	currStr = map.get(currInt);
            	currStr += firstLetOfNxt;
            }
            else {
            	currStr = map.get(nextInt);
            }
            
             firstLetOfNxt = currStr.substring(0,1);
             map.put(counter, currStr+ firstLetOfNxt);
             counter++;
             
        }
        
        
        String output = "";

        for(int i = 0; i < intOutput.size(); i++)
        {
            int o = intOutput.get(i);
            output += map.get(o);
        }
        System.out.print(output);
    }
	
	public String full()
	{
		return this.full; 
	}
	
	public ArrayList strOutput()
	{
		return this.strOutput; 
	}
	
	public HashMap dictionary()
	{
		return this.dictionary; 
	}
}