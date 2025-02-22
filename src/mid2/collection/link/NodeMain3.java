package mid2.collection.link;

public class NodeMain3 {
    public static void main(String[] args) {
        // 노드 생성하고 연결하기: A -> B -> C
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");

        System.out.println(first);

        // 모든 노드 탐색하기
        System.out.println("모든 노드 탐색하기");
        pritnAll(first);

        // 마지막 노드 조회하기
        Node lastNode = getLastNode(first);
        System.out.println("lastNode = " + lastNode);

        // 특정 index의 노드 조회하기
        int index = 2;
        Node index2Node = getNode(first, index);
        System.out.println("index2Node = " + index2Node);

        // 데이터 추가하기
        System.out.println("데이터 추가하기");
        add(first, "D");
        System.out.println(first);
        add(first, "E");
        System.out.println(first);
        add(first, "F");
        System.out.println(first);
        add(first, "G");
        System.out.println(first);
    }

    private static void add(Node first, Object data) {
        getLastNode(first).next = new Node(data);
    }

    private static Node getNode(Node node, int index) {
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static Node getLastNode(Node node) {
        Node findNode = node;
        while (findNode.next != null) {
            findNode = findNode.next;
        }
        return findNode;
    }

    private static void pritnAll(Node node) {
        while (node != null) {
            System.out.println(node.item);
            node = node.next;
        }
    }


}
