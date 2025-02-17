package mid2.generic.ex5;

import mid2.generic.animal.Animal;
import mid2.generic.animal.Cat;
import mid2.generic.animal.Dog;

public class WildcardMain1 {
    public static void main(String[] args) {
        Box<Object> objBox = new Box<Object>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<Cat>();

        dogBox.set(new Dog("멍멍이", 100));

        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printWildcardV1(dogBox);

        WildcardEx.printGenericV2(dogBox);
        WildcardEx.printWildcardV2(dogBox);
//        WildcardEx.printWildcardV2(objBox); // 컴파일 오류

        Dog dog = WildcardEx.printAndReturnGeneric(dogBox);

        catBox.set(new Cat("야옹이", 200));
        Cat cat = WildcardEx.printAndReturnGeneric(catBox);

        Animal animal = WildcardEx.printAndReturnWildcard(dogBox);
    }
}
