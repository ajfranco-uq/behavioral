package pattern.observer.problem;

public class Product {

    private String name;
    private double price;
    private int stock;

    private CustomerApp customerApp;
    private MobileApp mobileApp;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;

        customerApp.update(this);
        mobileApp.update(this);
        // PROBLEMA: Product conoce directamente a CustomerApp y MobileApp.
    }

    // Si mañana agregamos:
    //    EmailService
    //    WebApp
    //    NotificationService
    //    AnalyticsSystem

    // tendríamos que modificar Product:
    //   emailService.update(this);
    //   webApp.update(this);
    //   notificationService.update(this);
    //   analyticsSystem.update(this);

    public void setStock(int stock) {
        this.stock = stock;

        customerApp.update(this);
        mobileApp.update(this);
    }

    public void setCustomerApp(CustomerApp customerApp) {
        this.customerApp = customerApp;
    }

    public void setMobileApp(MobileApp mobileApp) {
        this.mobileApp = mobileApp;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}