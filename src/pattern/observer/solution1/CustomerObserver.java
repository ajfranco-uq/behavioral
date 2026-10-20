package pattern.observer.solution1;

public class CustomerObserver implements Observer {

    private final String name;

    public CustomerObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Product product) {
        System.out.println(name + " received an update about " + product.getName());
    }
}