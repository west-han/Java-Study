package mid2.collection.list.test.ex2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        for (Item item : items) {
            System.out.println("상품명:" + item.getName() + ", 합계:" + item.getTotalPrice());
        }
        int sum = calculateTotalPrice();
        System.out.println("전체 가격 합:" + sum);
    }

    public int calculateTotalPrice() {
        return items.stream().mapToInt(Item::getTotalPrice).sum();
    }
}
