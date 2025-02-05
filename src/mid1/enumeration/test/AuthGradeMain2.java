package mid1.enumeration.test;

import java.util.Scanner;

public class AuthGradeMain2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ");
        String input = sc.nextLine();

        AuthGrade authGrade = null;

        try {
            authGrade = AuthGrade.valueOf(input.toUpperCase());
            System.out.println("당신의 등급은 " + authGrade.getDescription() + "입니다.");
        } catch (IllegalArgumentException e) {
            System.err.println("잘못된 입력");
        }

        if (authGrade != null) {
            printMenu(authGrade);
        }
    }

    private static void printMenu(AuthGrade authGrade) {
        final String[] menus = {"메인 화면", "이메일 관리 화면", "회원 정보 조회", "관리자 화면"};

        int limit = authGrade.name().equals("ADMIN") ? menus.length : authGrade.getLevel();
        System.out.println("== 메뉴 목록 ==");
        for (int i = 0; i < limit; i++) {
            System.out.println(menus[i]);
        }
    }
}
