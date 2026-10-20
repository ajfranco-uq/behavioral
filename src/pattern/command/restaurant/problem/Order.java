package pattern.command.restaurant.problem;

class Order {

    private final int orderId;
    private String status;

    public Order(int orderId) {
        this.orderId = orderId;
        this.status = "CREATED";
    }

    public void confirm() {
        status = "CONFIRMED";
        System.out.println("Order " + orderId + " confirmed.");
    }

    public void cancel() {
        status = "CANCELLED";
        System.out.println("Order " + orderId + " cancelled.");
    }

    public void sendToKitchen() {
        status = "IN_PREPARATION";
        System.out.println("Order " + orderId + " sent to kitchen.");
    }

    public String getStatus() {
        return status;
    }
}