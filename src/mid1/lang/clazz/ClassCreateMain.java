package mid1.lang.clazz;

import java.lang.reflect.InvocationTargetException;

public class ClassCreateMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class helloClass = Class.forName("mid1.lang.clazz.Hello");
        Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance(); // 생성자 선택, 선택한 생성자 기반으로 인스턴스 생성
        String result = hello.hello();
        System.out.println("result = " + result);
    }
}
