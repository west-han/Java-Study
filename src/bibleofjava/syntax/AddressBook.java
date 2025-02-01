package bibleofjava.syntax;

import bibleofjava.syntax.linkedList.MyList;
import bibleofjava.syntax.linkedList.MyListEx;

public class AddressBook {
    public static void main(String[] args) {
        UserData head = new bibleofjava.syntax.UserData("Dummy", "Dummy");
        MyList list = new MyListEx(head);
        new UserInterface(list).run();
    }
}

