package syntax;

import syntax.linkedList.MyList;
import syntax.linkedList.MyNode;

import java.util.Iterator;
import java.util.Scanner;

public class UserInterface {
    private final Scanner s = new Scanner(System.in);
    private final MyList list;

    public UserInterface(MyList list) {
        this.list = list;
    }

    private int printUi() {
        System.out.println("[1] Add\t[2] Search\t[3] Print all\t[4] Remove\t[0] Exit");
        System.out.print(": ");
        int input = s.nextInt();
        s.nextLine();
        return input;
    }

    public void addUser() {
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Phone: ");
        String phone = s.nextLine();

        list.addNewNode(new UserData(name, phone));
    }

    public void searchUser() {
        System.out.print("Name: ");
        String name = s.nextLine();

        UserData user = (UserData)list.findNode(name);
        if(user != null) {
            System.out.println("Name: " + user.getName());
            System.out.println("Phone: " + user.getPhone());
        }
        else
            System.out.println("Error: Failed to find " + name);
    }

    public void printAll() {
        Iterator<MyNode> iter = list.iterator();
        while(iter.hasNext()) {
            MyNode tmp = iter.next();
            System.out.println(tmp.getKey() + "\t" + tmp.getKey());
        }
    }

    public void removeUser() {
        System.out.print("Name: ");
        String name = s.nextLine();

        if(list.removeNode(name))
            System.out.println("Removed!");
        else
            System.out.println("Error: Failed to remove " + name);
    }

    public void run() {
        int menu = 0;
        while((menu = printUi()) != 0) {
            switch (menu) {
                case 1:
                    addUser();
                    break;

                case 2:
                    searchUser();
                    break;

                case 3:
                    printAll();
                    break;

                case 4:
                    removeUser();
                    break;
            }
        }
    }
}