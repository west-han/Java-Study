package basic.inheritanceex;

public class Movie extends Item{
    private String producer;
    private String actor;

    public Movie(String name, int price, String producer, String actor) {
        super(name, price);
        this.producer = producer;
        this.actor = actor;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- 감독 : " + producer + ", 배우: " + actor);
    }
}
