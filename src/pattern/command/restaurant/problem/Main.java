package pattern.command.restaurant.problem;

public class Main {

    public static void main(String[] args) {

        Order order = new Order(101);
        OrderController controller = new OrderController(order);

        controller.confirmOrder();
        controller.prepareOrder();

        System.out.println("Current status: " + order.getStatus());
    }
}
