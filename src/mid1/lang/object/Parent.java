package mid1.lang.object;

// 모든 클래스는 부모가 없으면 묵시적으로 Object 클래스를 상속
public class Parent /* extends Object */ {

    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}
