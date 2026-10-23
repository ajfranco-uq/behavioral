package pattern.observer.push.solution1.observer;

public class MobileApp implements Observer {

    private final String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String name, double price, int stock) {

        System.out.println("MobileApp");
        System.out.println("Product: " + name);
        System.out.println("Product price: " + price);
        System.out.println("Current stock: " + stock);
    }
}