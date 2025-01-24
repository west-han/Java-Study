public class MyString {
    private byte[] string;
    private static int count = 0;

    private MyString() {
        count++;
    }

    private MyString(byte[] string) {
        this();
        this.string = string;
    }

    private MyString(String string) {
        this();
        this.string = string.getBytes();
    }

    private MyString(int num) {
        this();
        this.string = String.valueOf(num).getBytes();
    }

    public MyString(MyString myString) {
        this();
        // 복사 생성자
        this.deepCopy(myString);
    }

    public static MyString newString() {
        return new MyString();
    }

    public static MyString newString(byte[] string) {
        return new MyString(string);
    }

    public static MyString newString(int num) {
        return new MyString(num);
    }

    public static MyString newString(String string) {
        return new MyString(string);
    }

    public static int getCount() {
        return count;
    }

    private void deepCopy(MyString rhs) {
        System.arraycopy(rhs.string, 0, this.string, 0, rhs.string.length);
    }

    public void setString(String string) {
        this.string = new byte[string.length()];
        for (int i = 0; i < string.length(); i++) {
            this.string[i] = (byte) string.charAt(i);
        }
    }

    public String getString() {
        StringBuilder str = new StringBuilder();
        if (string != null) {
            for (byte b : string) {
                str.append((char) b);
            }
        }  else {
            str.append("(null)");
        }
        return str.toString();
    }

    int length() {
        if (string == null) {
            return 0;
        }
        return string.length;
    }

    int compareTo(String param) {
        if (string == null || param == null) {
            return -1;
        }
        int length = Math.min(string.length, param.length());
        for (int i = 0; i < length; i++) {
            int diff = (char) string[i] - param.charAt(i);
            if (diff != 0) {
                return diff;
            }
        }

        return Integer.compare(string.length, param.length());
    }

    public static void main(String[] args) {
        /*MyString str = new MyString("Test");
        System.out.println(str.getString());
        MyString str2 = new MyString(512);
        System.out.println(str2.getString());*/

        MyString s1 = MyString.newString(10);
        MyString s2 = MyString.newString("Test");
        System.out.println(s1.getString());
        System.out.println(s2.getString());
        System.out.println(MyString.getCount());
    }
}
