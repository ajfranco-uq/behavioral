package pattern.observer.push.solution1.observer;

public class CustomerApp implements Observer {

    private final String name;

    public CustomerApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String name, double price, int stock) {

        System.out.println("CustomerApp");
        System.out.println("Product: " + name);
        System.out.println("Product price: " + price);
        System.out.println("Current stock: " + stock);
    }
}