package pattern.observer.pull.solution1;

import pattern.observer.pull.solution1.observer.CustomerObserver;
import pattern.observer.pull.solution1.observer.MobileAppObserver;
import pattern.observer.pull.solution1.observer.Observer;
import pattern.observer.pull.solution1.subject.Product;

public class Main {

    public static void main(String[] args) {

        Product product = new Product("PlayStation 5", 499.99, 0);

        Observer customer = new CustomerObserver("John");
        Observer mobileApp = new MobileAppObserver("Shopping App");

        product.attach(customer);
        product.attach(mobileApp);

        product.setStock(10);

        //product.setPrice(449.99);

        //product.detach(customer);

        //product.setPrice(429.99);
    }

    //Podemos agregar nuevos observers sin necesidad de modificar. OCP
}