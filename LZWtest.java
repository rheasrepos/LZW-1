import java.io.FileNotFoundException;

public class LZWtest {
	public static void main (String [] args) throws FileNotFoundException
	{
	LZW2 hello = new LZW2("text.txt");
//	System.out.println(hello.full()); 
	hello.compress();
	hello.decode();
	
	System.out.println(hello.dictionary());

	
	
	//224 //then 228
	}
}
