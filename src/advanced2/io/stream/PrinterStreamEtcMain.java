package advanced2.io.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrinterStreamEtcMain {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp/print.txt");
        PrintStream ps = new PrintStream(fos);
        ps.println("Hello World");
        ps.println(10);
        ps.println(true);
        ps.printf("hello %s", "java");
        ps.close();
    }
}
