package mid2.collection.link;

public class MyLinkedListV3<E> {

    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Node<E> current = this;
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

    private Node<E> first;
    private int size = 0;

    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (first == null) {
            first = newNode;
        } else {
            Node<E> lastNode = getLastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    private Node<E> getLastNode() {
        return getNode(size - 1);
    }

    private Node<E> getNode(int index) {
        Node<E> findNode = first;
        for (int i = 0; i < index; i++) {
            findNode = findNode.next;
        }
        return findNode;
    }

    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> target = getNode(index - 1);
            newNode.next = target.next;
            target.next = newNode;
        }
        size++;
    }

    public E remove(int index) {
        Node<E> removeNode = getNode(index);
        E retElem = removeNode.item;

        if (index == 0) {
            first = removeNode.next;
        } else {
            Node<E> previous = getNode(index - 1);
            previous.next = removeNode.next;
        }
        removeNode.item = null;
        removeNode.next = null;
        size--;
        return retElem;
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        Node<E> x = getNode(index);
        Object oldValue = x.item;
        x.item = element;
        return (E) oldValue;
    }

    public E get(int index) {
        return getNode(index).item;
    }

    public int indexOf(E e) {
        Node<E> findNode = first;
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
