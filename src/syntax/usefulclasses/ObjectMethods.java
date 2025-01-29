package syntax.usefulclasses;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TestClass {
    int value;

    public TestClass(int value) {
        this.value = value;
    }
}

class Person {
    long id;

    public Person(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Person) {
            return this.id == ((Person) obj).id;
        }
        return false;
    }
}

class Point implements Cloneable {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    // clone 재정의 시에는 Cloneable 인터페이스 구현(Object 클래스의 clone 메서드가 protected -> public 으로 변경하기 위함)
    // 공변 반환타입: JDK 1.5 이후로 부모 메서드의 반환형을 자식 타입으로 변경해서 반환 가능
    public Point clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (Point)obj;
    }
}

public class ObjectMethods {
    public static void main(String[] args) {
        // -- equals() --
        TestClass t1 = new TestClass(1);
        TestClass t2 = new TestClass(1);
        Person p1 = new Person(1);
        Person p2 = new Person(1);
        System.out.println(t1.equals(t2)); // 참조변수 값 비교(Object 클래스의 equals 메서드 기본 동작)
        System.out.println(p1.equals(p2)); // 필드 값 비교(재정의)
        // -- equals() --

        System.out.println();

        // -- hashCode() --
        // Object 클래스의 hashCode() 메서드는 기본적으로 객체의 주소를 기반으로 해싱
        // 따라서 해싱 기법을 사용하는 컬렉션에 저장할 객체라면 반드시 hashCode() 메서드를 적절하게 재정의 해야 한다.
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode()); // String 클래스의 hashCode() 메서드는 문자열 내용을 해싱하도록 오버라이딩 되어 있음
        System.out.println(str2.hashCode());
        System.out.println(System.identityHashCode(str1)); // Object 클래스의 hashCode()처럼 객체의 주소값으로 해시코드 생성
        System.out.println(System.identityHashCode(str2));
        // -- hashCode() --

        System.out.println();

        // -- toString() --
        // 메서드 인스턴스에 대한 정보를 문자열 형식으로 제공하기 위한 목적의 메서드
        // 기본 동작은 클래스명@해시코드 형식(hashCode() 호출 결과)
        System.out.println(new Object().toString());
        System.out.println(new Object().toString());
        System.out.println(t1.toString());
        System.out.println(new Date());
        // -- toString() --

        System.out.println();

        // -- clone() --
        // 인스턴스가 자신을 복제한 새로운 인스턴스를 생성해서 반환하는 메서드
        // Object 클래스의 clone() 메서드는 기본적으로 인스턴스 변수의 값을 복사 -> 얕은 복사
        Point point = new Point(3, 5);
        Point clone = (Point)point.clone();
        System.out.println("original: " + point);
        System.out.println("clone: " + clone);
        // -- clone() --

        // -- getClass() --
        // 클래스에 대한 모든 정보를 저장하는 Class 객체르 반환
        // Class 객체는 클래스 당 1개만 존재하며, 클래스 파일이 클래스 로더에 의해 메모리에 로드될 때 자동으로 생성
        Class clazz = Person.class; // 클래스 리터럴(*.class)로부터 클래스 객체 참조 얻기
        clazz = new Person(5).getClass(); // 생성된 객체로부터 클래스 객체 참조 얻기
        try {
            clazz = Class.forName("Person"); // 클래스 이름으로부터 클래스 객체 참조 얻기
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // -- getClass() --

        // -- Objects --
        // Object 클래스의 보조 클래스, 객체 비교나 널 체크에 유용
        System.out.println(Objects.isNull(null));
        System.out.println(Objects.nonNull(null));
        try {
            Objects.requireNonNull(null);
        } catch (NullPointerException e) {
            System.out.println("requireNonNull(): null 전달되면 예외 발령");
        }
        // 대소 비교
        System.out.println(Objects.compare(p1, p2, (a, b) -> Math.toIntExact(a.id - b.id)));
        System.out.println(Objects.equals(p1, p2)); // null 체크 불필요
        System.out.println(Objects.deepEquals(p1, p2)); // 재귀적 비교
        // -- Objects --

        // -- Random --
        // Math.random()은 내부적으로 Random 클래스의 인스턴스를 생성해서 nextDouble() 메서드 호출
        // 생성자 Random은 System.currentTimeMillis()를 seed 값으로 사용
        // -- Random --

        // -- java.util.regex 패키지 --
        Pattern p = Pattern.compile("[0-9]*"); // 정규식 정의
        Matcher m = p.matcher("검증할 문자열"); // 정규식(패턴)을 데이터와 비교하ㅏ기 위한 객체
        System.out.println(m.matches()); // 소스가 패턴과 일치하면 true
        // 정규식 패턴을 (0\\ㅇ{1,2})-(\\ㅇ{3,4})-(\\d{4}) 와 같이 설정한 경우, 괄호로 묶은 부분들이 그룹화
        System.out.println(m.group()); // 그룹으로 나누지 않은 전체 문자열
        System.out.println(m.group(1)); // 첫 번쨰 그룹
        System.out.println(m.group(2)); // 두 번쨰 그룹
        System.out.println(m.find()); // 주어진 소스 내에서 패턴과 일치하는 부분을 찾아내면 true, 찾은 위치 기억 후 다시 호출하면 다음으로 일치하는 부분 기억
        System.out.println(m.start()); // find()로 찾은 부분의 시작 위치
        System.out.println(m.end()); // find()로 찾은 부분이 끝나는 위치
        // -- java.util.regex 패키지 --

        // -- StringTokenizer 클래스 --
        // 문자열 토큰화에 사용, 대용랑 데이터 처리 시 String 객체의 split() 보다 빠르게 동작
        String str = "abc, def, ghi, jkl";
        StringTokenizer st = new StringTokenizer(str, ",", false); // 마지막 인자 true이면 구분자도 토큰으로 간주
        System.out.println(st.countTokens());
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        // -- StringTokenizer 클래스 --

        // -- BigInteger --
        // long 타입의 범위를 넘어서는 정수 표현을 위한 클래스(내부적으로 int 배열 사용, immutable)
        BigInteger val = new BigInteger("12345678901234567890");
        System.out.println(val.toString(2)); // 특정 진법의 문자열로 변환
        val = new BigInteger("FFFF", 16); // n진수 문자열 생성
        val = BigInteger.valueOf(1234567890L); // 숫자로 생성
        System.out.println(val.intValue());
        System.out.println(val.longValue());
        System.out.println(val.floatValue());
        System.out.println(val.doubleValue());
        val.add(BigInteger.ONE);
        val.subtract(BigInteger.ONE);
        val.multiply(BigInteger.ONE);
        val.divide(BigInteger.ONE);
        val.remainder(BigInteger.ONE);

        // 비트 연산 메서드도 있음
        val.bitCount();
        val.bitLength();
        // -- BigInteger --

        // -- BigDecimal --
        // double 타입의 정밀도 문제를 해결하기 위한 클래스
        BigDecimal decimal = new BigDecimal("12.345");
        System.out.println(decimal.unscaledValue()); // 12345
        System.out.println(decimal.scale()); // 2 (소수점 이하 자릿수)
        System.out.println(decimal.precision()); // 5 (정수 전체 자릿수)

        decimal.intValue();
        decimal.longValue();
        decimal.floatValue();
        decimal.doubleValue();

        decimal.add(BigDecimal.ONE);
        decimal.subtract(BigDecimal.ONE);
        decimal.multiply(BigDecimal.ONE);
        decimal.divide(BigDecimal.ONE);
        decimal.remainder(BigDecimal.ONE);

        decimal.divide(BigDecimal.ONE, 3, RoundingMode.DOWN); // 반올림 모드, 자릿수 등 설정해서 처리 가능
        decimal.divide(BigDecimal.ONE, new MathContext(2, RoundingMode.HALF_UP)); // 반올림 설정을 묶기 위한 객체
        // -- BigDecimal --

    }
}
