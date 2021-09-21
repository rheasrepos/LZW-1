import java.io.FileNotFoundException;

public class LZWtest {
	public static void main (String [] args) throws FileNotFoundException
	{
	LZW2 hello = new LZW2("text.txt");
	long startTime, endTime;
//	System.out.println(hello.full()); 
	hello.compress();
	 startTime = System.currentTimeMillis();
	hello.decode();
	endTime = System.currentTimeMillis();
	float time  = (endTime- startTime);
	System.out.println("sup");
	System.out.println(time);
	
	
	//224 //then 228
	
	//time without changes 1506250/ 1308208 / 1314791
//	with chnages 1200708 and 1043167 so overall lower times ??
	

	}
}
