package advanced2.io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static advanced2.io.buffered.BufferedConst.*;

public class ReadFileV2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int size;
        byte[] buffer = new byte[BUFFER_SIZE];

        while ((size = fis.read(buffer)) != -1) {
            fileSize += size;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("File created: " + FILE_NAME);
        System.out.println("File size: " + fileSize / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}