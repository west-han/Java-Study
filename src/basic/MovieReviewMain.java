package basic;

class MovieReview {
    private String title;
    private String review;

    public MovieReview() {
    }

    public MovieReview(String title, String review) {
        this.title = title;
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}


public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview review1 = new MovieReview("디워", "용이다");
        MovieReview review2 = new MovieReview("라스트갓파더", "한국의 대부");

        System.out.println(review1.getTitle() + ": " + review1.getReview());
        System.out.println(review2.getTitle() + ": " + review2.getReview());

        System.out.println();

        MovieReview[] reviews = {review1, review2};
        for (MovieReview review : reviews) {
            System.out.println(review.getTitle() + ": " + review.getReview());
        }
    }
}
