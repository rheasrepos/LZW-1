import java.io.FileNotFoundException;

public class LZWtest {
	public static void main (String [] args) throws FileNotFoundException
	{
	LZW2 hello = new LZW2("lzw-file.txt");
//	System.out.println(hello.full()); 
	System.out.println(hello.output1); 
	System.out.println(hello.full);
	System.out.println(hello.output().toString()); 
	System.out.println(hello.output); 
	System.out.println(hello.binaryString); 
	
//	System.out.println(hello.dictionary());

	
	
	//224 //then 228
	}
}
