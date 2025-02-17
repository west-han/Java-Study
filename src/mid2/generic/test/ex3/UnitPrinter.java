package mid2.generic.test.ex3;

import mid2.generic.test.ex3.unit.BioUnit;
import mid2.generic.test.ex3.unit.Shuttle;

public class UnitPrinter {
    public static <T extends BioUnit> void printV1(Shuttle<T> shuttle) {
        T unit = shuttle.out();
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }

    // Shuttle의 제네릭 파라미터에 이미 상한이 정해져 있으므로 와일드카드 상한 지정 불필요
    public static void printV2(Shuttle<?> shuttle) {
        BioUnit unit = shuttle.out();
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }
}
