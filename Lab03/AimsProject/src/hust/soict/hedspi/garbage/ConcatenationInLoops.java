package hust.soict.hedspi.garbage;
import java.util.Random;

public class ConcatenationInLoops {
	public static void main(String[] args) {
		//STRING
		System.out.println("STRING");
		Random r = new Random(123);
		long start = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < 65536; i++)
			s += r.nextInt(2);
		System.out.println(System.currentTimeMillis() - start); 
		//STRING BUILDER
		System.out.println("STRING BUILDER");
		r = new Random(123);
		start = System. currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 65536; i++)
			sb.append(r.nextInt(2));
		s = sb.toString();
		System.out.println(System.currentTimeMillis() - start);
		//STRING BUFFER
		System.out.println("STRING BUFFER");
		r = new Random(123);
		start = System. currentTimeMillis();
		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < 65536; i++)
		    sb1.append(r.nextInt(2));
		s = sb1.toString();
		System.out.println(System.currentTimeMillis() - start);
	}
}