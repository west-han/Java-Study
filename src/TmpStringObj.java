public class TmpStringObj {
    public static void main(String[] args) {
        // "hello"는 JVM 메모리 상에서 Runtime Constant Pool에 위치
        String hello = "hello";
        hello += "World"; // "hello"와 "World"가 접합된 임시 객체가 반환되어 hello 참조변수에 할당
        System.out.println(hello);

        // "helloWorld"와 "TempObj"가 합쳐진 임시객체 반환, 해당 객체의 concat 메서드 호출
        System.out.println(
                (hello + " TempObj").concat(" Test")
        );

        // 문자열 접합 연산의 성능
        String tmp = "0123456789";
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1024; i++) {
            tmp = tmp + "0123456789";
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");

        begin = System.currentTimeMillis();
        for (int i = 0; i < 1024 * 10; i++) {
            tmp = tmp + "0123456789";
        }
        end = System.currentTimeMillis();
        System.out.println(end - begin + "ms"); // loop 횟수는 10배 늘었지만 실제 소요된 시간은 20~40배 이상, 비용이 기하급수적 상승

        // String vs StringBuilder
        tmp = "0123456789";
        begin = System.currentTimeMillis();
        for (int i = 0; i < 1024 * 100; i++) {
            tmp = tmp + "0123456789";
        }
        end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");

        StringBuilder sb = new StringBuilder("0123456789");
        begin = System.currentTimeMillis();
        for (int i = 0; i < 1024 * 100; i++) {
            sb.append("0123456789");
        }
        end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");
    }
}
