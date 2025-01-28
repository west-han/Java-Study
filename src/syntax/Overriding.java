package syntax;/*
 - 객체지향 프로그래밍을 할 때는 관점과 시점에 주의
 - 관점은 객체의 사용자와 작성자, 시점은 객체를 작성하는 시점으로 과거, 현재, 미래에 대한 구분

 <관점>
 - 사용자와 작성자를 명확히 구분하고, 클래스를 작성할 때는 클래스의 사용자를 반드시 배려해야 한다.
 - 일반적으로 사용자는 객체 자체에 대한 이해도가 현저히 낮으므로, 그런 상태에서 보더라도 직관적으로 이해할 수 있도록 작성해야 한다.
 - 작성자 자신 또한 미래에 사용자 입장이 되기 마련이다.
 - 객체지향에서 작성자와 사용자의 구분이 특히 더 중요한 이유는, 기본적으로 객체는 재사용과 확장을 전제로 만들어지기 때문이다.

 <시점>
 - 시점은 상속과 깊이 관련된다.
 - 어떠한 클래스를 상속해서 새로운 클래스를 작성하는 경우, Base 클래스는 과거에 작성된 것이며 Derived 클래스는 현재 작성중인 것이다.
 - 클래스를 작성하는 현재에는 미래에 클래스를 상속해 작성할 개발자를 고려해서 작성할 수 있다.
 - 즉, 코드를 통해 과거, 현재, 미래가 서로 소통할 수 있음을 의미한다.

 - (참고)다른 클래스를 상속한 클래스는 내부에 부모 클래스의 인스턴스를 포함하며, 메서드가 재정의된 경우 참조변수의 타입보다 실제 인스턴스의 타입이 우선한다.
 - 아래의 grammer.Past 클래스는 항상 true를 반환하는 onSetData 메서드를 가지고 있다.
 - grammer.Past 클래스를 작성하는 시점에서는 아무런 의미가 없는 메서드처럼 보인다.
 - 그러나 누군가가 이 메서드를 재정의해 활용할 가능성이 있겠다는 생각이 든 grammer.Past 개발자는 이 불필요한 호출 코드를 추가함으로써 미래와의 대화를 시도한 것이라고 할 수 있다.
 - setData() 메서드는 final 클래스를 이용해 재정의가 불가능하게 막고, 대신 onSetData() 메서드를 원하는 방식으로 재정의해 특정 조건 하에서 data의 변경을 막을 수 있도록 배려한 것이다.

 - onXXX 같은 이름을 가진 메서드들은 개발자가 직접 호출하는 대신 정해진 시점에 이 메서드가 호출될 것이라는 선입견을 가지고 봐도 좋다.
 - 영어로는 Called by framework, 프레임워크에 의해 호출된다는 의미이다.
 - 더 자세히 풀어 쓰면, Framework 개발자에 의해 정해진 어느 시점에 Framework에 의해 호출된다는 뜻이다.
 - Framework의 확장성을 염두에 둔 설계라고 할 수 있다.
 - 아래 예제와 같은 경우이며, 이러한 내용을 알고 레퍼런스를 읽으면 해당 메서드가 왜, 그리고 언제 호출되는지에 대한 설명에 집중해 이해할 수 있다.
 */

class Past {
    private int data;
    public final void setData(int data) {
        if (onSetData(data)) {
            System.out.println("Data has been set");
            this.data = data;
        } else {
            System.out.println("Data has not been set");
            return;
        }
    }

    protected boolean onSetData(int param) {
        return true;
    }
}

class Present extends Past {
    // final 메서드이므로 재정의 불가
//    public void setData(int data) {}

    @Override
    protected boolean onSetData(int param) {
        return param >= 0;
    }
}

public class Overriding {
    public static void main(String[] args) {
        Past past = new Past();
        Past present = new Present();

        past.setData(-1);
        present.setData(-1);
    }
}
