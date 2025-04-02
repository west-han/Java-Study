package advanced2.annotation.basic;

import advanced2.util.MyLogger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoElement {
    String value();
    int count() default 0;
    String[] tags() default {};

    // MyLooger data(); // 어노테이션 내에서는 Java가 기본적으로 제공하는 타입만 가능, 다른 타입은 적용 X
    Class<? extends MyLogger> annoData() default MyLogger.class; // 클래스 정보는 가능
}
