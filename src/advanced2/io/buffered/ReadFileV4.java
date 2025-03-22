package advanced2.io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static advanced2.io.buffered.BufferedConst.*;

public class ReadFileV4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int size;

        byte[] bytes = fis.readAllBytes();
        fis.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File created: " + FILE_NAME);
        System.out.println("File size: " + bytes.length / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}