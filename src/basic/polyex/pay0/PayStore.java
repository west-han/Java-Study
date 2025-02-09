package basic.polyex.pay0;

import java.util.Arrays;

public abstract class PayStore {
    public static Pay findPay(PayTypes option) {
        return switch (option) {
            case PayTypes.NAVER -> new NaverPay();
            case PayTypes.KAKAO -> new KakaoPay();
            default -> new DefaultPay();
        };
    }
}
