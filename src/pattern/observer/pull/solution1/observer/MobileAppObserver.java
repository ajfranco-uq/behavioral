package pattern.observer.pull.solution1.observer;

import pattern.observer.pull.solution1.subject.Product;

public class MobileAppObserver implements Observer {

    private final String appName;

    public MobileAppObserver(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(Product product) {
        System.out.println(appName + " received an update about " + product.getName() + " - $" + product.getPrice());
        //System.out.println(appName + " updated: " + product.getName() + " - $" + product.getPrice());
    }
}