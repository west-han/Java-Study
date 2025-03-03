package mid2.collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private static final Map<Product, Integer> products = new HashMap<>();

    public void add(Product product, int quantity) {
        if (products.containsKey(product)) {
            quantity += products.get(product);
        }
        products.put(product, quantity);
    }

    public void minus(Product product, int quantity) {
        if (products.containsKey(product)) {
            quantity -= products.get(product);
        }

        if (quantity <= 0) {
            products.remove(product);
        } else {
            products.put(product, quantity);
        }
    }

    public void printAll() {
        System.out.println("==모든 상품 출력==");
        for (Product product : products.keySet()) {
            System.out.println("상품: " + product + " 수량: " + products.get(product));
        }
    }
}
