package bibleofjava.collectionframework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class ExpValidCheck {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = "";
        try {
             exp = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stack<String> stack = new Stack<>();
        try {
            for (int i = 0; i < exp.length(); i++) {
                char ch = exp.charAt(i);
                if (ch == '(') {
                    stack.push(String.valueOf(ch));
                } else if (ch == ')') {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        } catch (EmptyStackException e) {
            System.out.println("invalid");
        }
    }
}
