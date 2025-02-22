package mid2.collection.link;

public class MyLinkedListV1 {

    private Node first;
    private int size = 0;

    public void add(Object e) {
        Node newNode = new Node(e);
        if (first == null) {
            first = newNode;
        } else {
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    private Node getLastNode() {
        return getNode(size - 1);
    }

    private Node getNode(int index) {
        Node findNode = first;
        for (int i = 0; i < index; i++) {
            findNode = findNode.next;
        }
        return findNode;
    }

    public Object set(int index, Object element) {
        Node x = getNode(index);
        Object oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    public Object get(int index) {
        return getNode(index).item;
    }

    public int indexOf(Object e) {
        Node findNode = first;
        int i = 0;
        while (findNode != null && !e.equals(findNode.item)) {
            findNode = findNode.next;
            i++;
        }
        return findNode == null ? -1 : i;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}
