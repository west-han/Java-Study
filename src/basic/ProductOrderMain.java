package basic;

import java.util.Scanner;

class ProductOrder {
    private String productName;
    private int quantity;
    private int price;

    public ProductOrder() {
    }

    public ProductOrder(String productName, int quantity, int price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


public class ProductOrderMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("주문 수량 입력: ");
        int numOrders = scanner.nextInt();
        ProductOrder[] orders = new ProductOrder[numOrders];
        for (int i = 0; i < numOrders; i++) {
            System.out.printf("%d번째 주문 정보를 입력하세요.\n", i + 1);
            scanner.nextLine();

            System.out.print("상품명: ");
            String productName = scanner.nextLine();
            System.out.print("가격: ");
            int price = scanner.nextInt();
            System.out.print("수량: ");
            int quantity = scanner.nextInt();

            orders[i] = createOrder(productName, quantity, price);
        }
        printOrders(orders);
        int total = getTotalAmount(orders);

        System.out.println("총 결제 금액: " + total);
    }

    static ProductOrder createOrder(String productName, int quantity, int price) {
        return new ProductOrder(productName, quantity, price);
    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            int quantity = order.getQuantity();
            int price = order.getPrice();
            System.out.println("상품명:" + order.getProductName() + ", 가격: " + price + ", 수량: " + quantity);
        }
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int total = 0;
        for (ProductOrder order : orders) {
            total += order.getQuantity() * order.getPrice();
        }
        return total;
    }
}
