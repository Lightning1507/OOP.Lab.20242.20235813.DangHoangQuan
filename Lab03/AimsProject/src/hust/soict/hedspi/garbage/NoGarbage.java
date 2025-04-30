package hust.soict.hedspi.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage{
    public static void main(String[] args) throws IOException {

        String filename = "C:\\Users\\koyqu\\Downloads\\quiz.pdf";
        byte[] inputBytes = {0};
        long startTime, endTime;
        inputBytes = Files.readAllBytes(Paths.get(filename));

        // String concatenation
        String outputString = "";
        startTime = System.currentTimeMillis();
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String concatenation time: " + (endTime - startTime));

        // StringBuilder
        StringBuilder sb = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (byte b : inputBytes) {
            sb.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endTime - startTime));
        // StringBuffer
        StringBuffer sb1 = new StringBuffer();
        startTime = System.currentTimeMillis();
        for (byte b : inputBytes) {
            sb1.append((char) b);
        }
        outputString = sb1.toString();
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endTime - startTime));
    }
}
