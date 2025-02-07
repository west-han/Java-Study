package basic.inheritanceex;

public class ShopMain {
    public static void main(String[] args) {
        Book book = new Book("Java", 10000, "han", "12345");
        Album album = new Album("앨범1", 15000, "seo");
        Movie movie = new Movie("영화1", 18000, "감독1", "배우1");

        book.print();
        album.print();
        movie.print();

        int sum = book.getPrice() + album.getPrice() + movie.getPrice();
        System.out.println("sum = " + sum);
    }
}
