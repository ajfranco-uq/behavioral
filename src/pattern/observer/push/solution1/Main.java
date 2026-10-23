package pattern.observer.push.solution1;

import pattern.observer.push.solution1.observer.CustomerApp;
import pattern.observer.push.solution1.observer.MobileApp;
import pattern.observer.push.solution1.observer.Observer;
import pattern.observer.push.solution1.subject.Product;

public class Main {

    public static void main(String[] args) {

        Product product = new Product("Laptop", 1200.00, 5);
        System.out.println(product);

        System.out.println("--------------------------");

        Observer customerApp = new CustomerApp("Customer App");
        Observer mobileApp = new MobileApp("Mobile App");

        product.attach(customerApp);
        product.attach(mobileApp);

        System.out.println("--- Changing price ---");
        product.setPrice(1100.00);

        System.out.println();

        System.out.println("--- Changing stock ---");
        product.setStock(10);

        System.out.println();

        System.out.println("--- Changing name ---");
        product.setName("Laptop 2");
    }
}