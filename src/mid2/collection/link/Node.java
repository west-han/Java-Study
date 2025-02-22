package mid2.collection.link;

public class Node {
    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    /*
    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = this;
        while (current != null) {
            sb.append(current.item);
            current = current.next;
            if (current != null) {
                sb.append("->");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
