package mid2.generic.ex4;

import mid2.generic.animal.Animal;

public class CompleteBox<T extends Animal> {

    private T animal;
    public void set(T animal) {
        this.animal = animal;
    }

    public <T> T printAndReturn(T t) {
        System.out.println("animal.className: " + animal.getClass().getName());
        System.out.println("t.className: " + t.getClass().getName());

        // 컴파일 오류, 제네릭 메서드의 타입 파라미터는 Object 취급이므로
        //t.getName();
        //t.getSize();
        return t;
    }
}
