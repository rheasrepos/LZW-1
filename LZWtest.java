import java.io.FileNotFoundException;

public class LZWtest {
	public static void main (String [] args) throws FileNotFoundException
	{
	LZW2 hello = new LZW2("text.txt");
//	System.out.println(hello.full()); 
	hello.compress();
	long startTime = System.nanoTime();
	hello.decode();
	long endTime = System.nanoTime();
	
	
	//224 //then 228
	
	//time without changes 1506250/ 1308208 / 1314791
//	with chnages 1200708 and 1043167 so overall lower times ??
	
    long timeElapsed = endTime - startTime;

    System.out.println("Execution time in nanoseconds: " + timeElapsed);
    System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);

	}
}
