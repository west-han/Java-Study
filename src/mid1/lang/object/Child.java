package mid1.lang.object;

// 명시적으로 Parent를 상속받았기 때문에 Object를 상속하지 않음
public class Child extends Parent {

    public void childMethod() {
        System.out.println("Child.childMethod");
    }
}
