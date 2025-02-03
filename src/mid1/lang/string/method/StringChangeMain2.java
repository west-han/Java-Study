package mid1.lang.string.method;

public class StringChangeMain2 {
    public static void main(String[] args) {
        String strWithSpace = "   Java Programming  ";
        System.out.println("소문자로 변환: " + strWithSpace.toLowerCase());
        System.out.println("대문자로 변환: " + strWithSpace.toUpperCase());

        // 단순 White space만 제거
        System.out.println("공백 제거(trim): '" + strWithSpace.trim() + "'");
        // 유니코드 공백까지 제거
        System.out.println("공백 제거(strip): '" + strWithSpace.strip() + "'");
        System.out.println("앞 공백 제거(strip): '" + strWithSpace.stripLeading() + "'");
        System.out.println("뒤 공백 제거(strip): '" + strWithSpace.stripTrailing() + "'");
    }
}
