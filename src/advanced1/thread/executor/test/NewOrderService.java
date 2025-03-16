package advanced1.thread.executor.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static advanced1.util.MyLogger.log;
import static advanced1.util.ThreadUtils.sleep;

public class NewOrderService {
    public void order(String orderNo) {
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        try (ExecutorService es = Executors.newFixedThreadPool(3)) {
            List<Callable<Boolean>> tasks = List.of(inventoryWork, shippingWork, accountingWork);
            List<Future<Boolean>> futures = es.invokeAll(tasks);
            List<Boolean> results = new ArrayList<>();
            for (Future<Boolean> future : futures) {
                Boolean result = future.get();
                results.add(result);
            }
            if (results.contains(false)) {
                log("일부 작업이 실패했습니다.");
            } else {
                log("모든 주문 처리가 성공적으로 완료되었습니다.");
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    static class InventoryWork implements Callable<Boolean> {
        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    private class ShippingWork implements Callable<Boolean> {
        private final String orderNo;
        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    private static class AccountingWork implements Callable<Boolean> {
        private final String orderNo;
        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
}
