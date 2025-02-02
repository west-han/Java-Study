package mid1.lang.object.equals;

public class EqualsMainV1 {

    public static void main(String[] args) {
        UserV1 user1 = new UserV1("id-100");
        UserV1 user2 = new UserV1("id-100");

        System.out.println("identity = " + (user1 == user2)); // false
        System.out.println("equality = " + (user1.equals(user2))); // false
        // Object 클래스의 equals() 메서드는 참조값을 비교
    }
}
