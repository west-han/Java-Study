package bibleofjava.syntax.linkedList;

public abstract class MyNode {
    private MyNode next;

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public abstract String getKey();

    public abstract MyNode getNode();
}
