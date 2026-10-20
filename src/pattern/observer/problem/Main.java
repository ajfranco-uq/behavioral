package pattern.observer.problem;

public class Main {

    public static void main(String[] args) {

        Product product = new Product("Laptop", 1200.00, 5);

        CustomerApp customerApp = new CustomerApp();

        MobileApp mobileApp = new MobileApp();

        product.setCustomerApp(customerApp);
        product.setMobileApp(mobileApp);

        product.setPrice(1100.00);

        product.setStock(10);
    }
}