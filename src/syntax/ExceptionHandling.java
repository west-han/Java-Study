package syntax;

class Example {
    public void tryCatch(int index) {
        try {
            int[] arr = new int[] {1, 2, 3};
            System.out.print("input: " + index);
            System.out.println(" => " + arr[index]);
            System.out.println("end of try{}");
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        } finally {
            System.out.println("성공하든 예외 발생하든 실행");
        }
    }
}

class MyException extends Exception {
    private String msg;
    public MyException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

public class ExceptionHandling {
    public static void checkedTest() throws MyException {
        int input = 110;
        if (input < 0 || input > 100) {
            throw new MyException("[MyException] input is out of range");
        }
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.tryCatch(0);
        example.tryCatch(4);

        // 예외 처리 필수
        // checkedTest();

        try {
            checkedTest();
        } catch (MyException e) {
            System.out.println(e.getMsg());
        }
    }
}
