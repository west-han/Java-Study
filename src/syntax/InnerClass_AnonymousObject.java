package syntax;

class Outer {
    private int data = 5;
    private static int staticData = 10;

    int getInnerData() {
        Inner inner = new Inner();
        return inner.getInData();
    }

    static class StaticInner {
        private int inData = 50;
        private static int inStaticData = 100;

        int getInData() { return inData; }
        int getOuterStaticData() {
            return Outer.staticData;
        }
    }

    class Inner {
        private int inData = 500;
        private static int inStaticData = 1000;

        int getInData() { return inData; }
        int getOuterData() {
            return Outer.this.data;
        }
        int getOuterStaticData() {
            return Outer.staticData;
        }
    }
}

public class InnerClass_AnonymousObject {
     static void testFunc(Object object) {
         System.out.println(object.toString());
     }

    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.getInnerData());

        // static inner class는 outer class와 별개로 존재, 외부 클래스의 인스턴스를 생성하지 않고도 정적 내부 클래스의 인스턴스 생성 가능
        System.out.println("== static inner class ==");
        Outer.StaticInner staticInner = new Outer.StaticInner();
        System.out.println(staticInner.getOuterStaticData()); // 외부 정적 필드 접근
        System.out.println(staticInner.getInData());

        System.out.println("== inner class ==");
        Outer.Inner inner = outer.new Inner(); // 외부 클래스 인스턴스가 생성되어 있어야만 내부 클래스의 인스턴스 생성 가능
        System.out.println(inner.getInData());
        System.out.println(inner.getOuterData()); // 외부 인스턴스 필드 접근
        System.out.println(inner.getOuterStaticData()); // 외부 정적 필드 접근\

        System.out.println("== local class ==");
        // 지역클래스
        int local = 20;

        class LocalClass {
            int data;
            LocalClass() {
                data = 10;
            }
            void printData() {
                System.out.println(this.data);
                System.out.println(local);
            }
        }

        LocalClass localClass = new LocalClass();
        testFunc(localClass); // grammer.InnerClass_AnonymousObject$1LocalClass@해시코드
        localClass.printData();

        System.out.println("== anonymous object ==");
        Parent p1 = new Child();
        p1.print();

        Parent p2 = new Parent() {
            @Override
            public void print() {
                System.out.println("Anonymous class");
            }
        };
        p2.print();
    }
}

abstract class Parent {
    public void print() {}
}
class Child extends Parent {
    @Override
    public void print() {
        System.out.println("syntax.Child class");
    }
}