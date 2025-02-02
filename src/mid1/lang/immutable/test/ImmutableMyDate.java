package mid1.lang.immutable.test;

public class ImmutableMyDate {

    private final int year;
    private final int month;
    private final int day;

    public ImmutableMyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // 불변객체에서 특정 값을 변경(한 새로운 인스턴스를 생성해 반환)하는 메서드는 setXXX()보다 withXXX()라는 네이밍 사용
    // cf. coffee with sugar, 변경사항을 새 객체에 포함해서 반환하는 경우
    public ImmutableMyDate withYear(int year) {
        return new ImmutableMyDate(year, this.month, this.day);
    }

    public ImmutableMyDate withMonth(int month) {
        return new ImmutableMyDate(this.year, month, this.day);
    }

    public ImmutableMyDate withDay(int day) {
        return new ImmutableMyDate(this.year, this.month, day);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
