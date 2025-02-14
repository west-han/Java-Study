package mid1.nested.test.ex1;

import java.util.Arrays;
import java.util.Objects;

public class Library {
    private final Book[] books;
    private int size;

    public Library(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(String title, String author) {
        if (size == books.length) {
            System.out.println("도서관 저장 공간이 부족합니다.");
            return;
        }

        books[size++] = new Book(title, author);
    }

    public void showBooks() {
        System.out.println("== 책 목록 출력 ==");
        for (int i = 0; i < size; i++) {
            System.out.println(books[i].toString());
        }
    }

    private record Book(String title, String author) {

        @Override
            public String toString() {
                return "도서 제목: " + title + ", 저자: " + author;
            }
        }


}
