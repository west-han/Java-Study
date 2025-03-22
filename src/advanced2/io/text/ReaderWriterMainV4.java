package advanced2.io.text;

import java.io.*;

import static advanced2.io.buffered.BufferedConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV4 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("== Write ==");
        System.out.println(writeString);

        // 파일에 쓰기
        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(writeString);
        bw.close();

        // 파일에서 읽기
        FileReader fr = new FileReader(FILE_NAME, UTF_8);
        BufferedReader br = new BufferedReader(fr);
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = br.readLine()) != null) {
            content.append(line).append("\n");
        }
        fr.close();

        System.out.println("== Read String ==");
        System.out.println(content);
    }
}
