package mid2.collection.deque.test.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    private static final Deque<String> history = new ArrayDeque<>();
    private String currentPage = null;

    public void visitPage(String url) {
        if (currentPage != null) {
            history.push(url);
        }
        currentPage = url;
        System.out.println("방문: " + url);
    }

    public String goBack() {
        if (!history.isEmpty()) {
            currentPage = history.pop();
            System.out.println("뒤로 가기: " + currentPage);
            return currentPage;
        }
        return null;
    }
}
