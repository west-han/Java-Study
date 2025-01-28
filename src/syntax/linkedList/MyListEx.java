package syntax.linkedList;

import java.util.Iterator;

public class MyListEx extends MyList {
    public MyListEx(MyNode head) {
        super(head);
    }

    @Override
    protected void onRemove() {
        Iterator<MyNode> iter = super.iterator();
        while (iter.hasNext()) {
            MyNode tmp = iter.next();
            System.out.print(tmp.getKey() + "\t");
        }
        System.out.println();
    }
}
