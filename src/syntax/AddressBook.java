package syntax;

import syntax.linkedList.MyList;
import syntax.linkedList.MyListEx;

public class AddressBook {
    public static void main(String[] args) {
        UserData head = new syntax.UserData("Dummy", "Dummy");
        MyList list = new MyListEx(head);
        new UserInterface(list).run();
    }
}

