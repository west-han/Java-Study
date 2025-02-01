package bibleofjava.syntax;

public class Copy {
    static class Address {
        private String address;
        private String phone;

        Address(String address, String phone) {
            this.address = address;
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public String getPhone() {
            return phone;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

    }

    static class User {
        private String name;
        private Address address;

        public User(String name, String address, String phone) {
            this.name = name;
            this.address = new Address(address, phone);
        }

        public String getName() {
            return name;
        }

        public Address getAddress() {
            return address;
        }

        public void copy(User rhs) {
            this.name = rhs.name;
            // shallow copy
//            this.address = rhs.address;
            // deep copy
            this.address.address = rhs.address.address;
            this.address.phone = rhs.address.phone;
        }
    }

    public static void main(String[] args) {
        User user1 = new User("A", "Seoul", "010-1111-1111");
        User user2 = new User("B", "Anyang", "010-2222-2222");

        System.out.println(user1.getName());
        System.out.println(user1.getAddress().getAddress());
        System.out.println(user1.getAddress().getPhone());

        user1.copy(user2);
        user2.getAddress().setPhone("010-3333-3333");
        user2.getAddress().setAddress("Hanam");
        System.out.println(user1.getName());
        System.out.println(user1.getAddress().getAddress());
        System.out.println(user1.getAddress().getPhone());

    }
}
