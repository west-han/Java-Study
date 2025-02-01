package bibleofjava.syntax;

import bibleofjava.syntax.linkedList.MyNode;

public class UserData extends MyNode {
    public UserData(String name, String phone) {
        super();
        this.name = name;
        this.phone = phone;
    }
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String getKey() {
        return this.name;
    }

    @Override
    public MyNode getNode() {
        return new UserData(this.name, this.phone);
    }
}