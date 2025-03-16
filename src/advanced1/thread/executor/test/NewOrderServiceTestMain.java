package advanced1.thread.executor.test;

public class NewOrderServiceTestMain {
    public static void main(String[] args) {
        String orderNo = "Order#1234";
        NewOrderService orderService = new NewOrderService();
        orderService.order(orderNo);
    }
}
