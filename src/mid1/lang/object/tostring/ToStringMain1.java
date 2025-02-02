package mid1.lang.object.tostring;

public class ToStringMain1 {

    public static void main(String[] args) {
        Object object = new Object();
        String string = object.toString();

        // toString() 반환값 출력: 클래스명@해시코드
        System.out.println(string);

        // object 직접 출력: println() 메서드 내부적으로 toString() 호출
        System.out.println(object);
    }
}
