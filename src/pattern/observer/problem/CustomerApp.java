package pattern.observer.problem;

public class CustomerApp {

    public void update(Product product) {

        System.out.println(
            "Customer app updated: "
            + product.getName()
            + " - Price: $"
            + product.getPrice()
        );
    }
}