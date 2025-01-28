package syntax.linkedList;

import java.util.Iterator;

public class MyList {
    private final MyNode head;

    public MyList(MyNode head) {
        this.head = head;
    }

    public MyNode findNode(String name) {
        MyNode tmp = head.getNext();
        while(tmp != null) {
            if(tmp.getKey().compareTo(name) == 0)
                return tmp;

            tmp = tmp.getNext();
        }

        return null;
    }

    public void addNewNode(MyNode newNode) {
        if(findNode(newNode.getKey()) != null)
            return;

        newNode.setNext(head.getNext());
        head.setNext(newNode);
    }

    public boolean removeNode(String name) {
        MyNode prev = head;
        MyNode toDelete = null;

        while(prev.getNext() != null) {
            toDelete = prev.getNext();

            if(toDelete.getKey().compareTo(name) == 0) {
                prev.setNext(toDelete.getNext());
                onRemove();
                return true;
            }

            prev = prev.getNext();
        }

        return false;
    }

    protected void onRemove() { }

    public Iterator<MyNode> iterator() {
        return new Iterator<MyNode>() {
            private MyNode tmp = head;
            @Override
            public boolean hasNext() {
                return tmp.getNext() != null;
            }

            @Override
            public MyNode next() {
                tmp = tmp.getNext();
                return tmp.getNode();
            }
        };
    }
}
