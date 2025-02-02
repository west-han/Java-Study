package basic;

class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    private boolean hasEmptySpace() {
        return itemCount < items.length;
    }

    public void addItem(Item item) {
        if (hasEmptySpace()) {
            items[itemCount++] = item;
        }
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        for (int i = 0; i < itemCount; i++) {
            int totalPrice = items[i].getTotalPrice();
            System.out.printf("상품명:%s, 합계:%d\n", items[i].getName(), totalPrice);
        }
        int totalPrice = calculateTotalPrice();
        System.out.println("전체 가격 합: " + totalPrice);
    }

    private int calculateTotalPrice() {
        int totalAmount = 0;
        for (int i = 0; i < itemCount; i++) {
            totalAmount += items[i].getTotalPrice();
        }
        return totalAmount;
    }
}

class Item {
    private String name;
    private int price;
    private int quantity;

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getTotalPrice() {
        return price * quantity;
    }
}

public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("마늘", 2000, 2);
        Item item2 = new Item("상추", 3000, 4);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.displayItems();
    }
}
