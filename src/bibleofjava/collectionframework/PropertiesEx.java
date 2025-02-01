package bibleofjava.collectionframework;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesEx {
    public static void main(String[] args) {
        // Properties는 Hashtable의 하위 클래스이며 키와 값이 모두 String 타입으로, 애플리케이션 환경설정과 관련된 속성을 저장하는데 주로 사용된다.
        Properties prop = new Properties();

        // prop에 키와 값(key, value) 저장
        prop.setProperty("timeout", "30");
        prop.setProperty("language", "kr");
        prop.setProperty("size", "10");
        prop.setProperty("capacity", "10");

        Enumeration en = prop.propertyNames();

        while (en.hasMoreElements()) {
            String keyu = (String) en.nextElement();
            String value = (String) prop.getProperty(keyu);
            System.out.println(keyu + "=" + value);
        }

        prop.setProperty("language", "en");
        System.out.println(prop.getProperty("language"));
        System.out.println(prop.getProperty("loadFactor")); // property가 없으면 null
        System.out.println(prop.getProperty("loadFactor", "0.75")); // 기본값을 함께 넘기면 null인 경우 기본값

        prop.list(System.out);

        System.out.println("== Properties 파일 ==");
        String filename = "test.properties";
        Properties pr = new Properties();
        try {
            pr.load(new FileInputStream(filename));
        } catch (IOException e) {
            pr.setProperty("name", "name");
            pr.setProperty("testValue", "30");
            try {
                pr.store(new FileWriter(filename), "주석");
                pr.storeToXML(new FileOutputStream(filename), "주석");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        String name = pr.getProperty("name", "defaultName");
        String testValue = pr.getProperty("testValue", "10");
        Enumeration<?> enumeration = pr.propertyNames();
        while (enumeration.hasMoreElements()) {
            String keyu = (String) enumeration.nextElement();
            String value = (String) pr.getProperty(keyu);
            System.out.println(keyu + "=" + value);
        }
    }
}
