package syntax;

enum Week {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Enum {
    public static void main(String[] args) {
        Week week = Week.SUNDAY;
        System.out.println(Week.valueOf("MONDAY").ordinal()); // 순서
        System.out.println(week.name());
        System.out.println(week.ordinal());
    }
}
