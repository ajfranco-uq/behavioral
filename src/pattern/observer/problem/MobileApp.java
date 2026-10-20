package pattern.observer.problem;

public class MobileApp {

    public void update(Product product) {

        System.out.println(
            "Mobile app updated: "
            + product.getName()
            + " - Stock: "
            + product.getStock()
        );
    }
}