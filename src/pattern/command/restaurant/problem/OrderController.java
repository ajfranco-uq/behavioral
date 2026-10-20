package pattern.command.restaurant.problem;

// OrderController conoce directamente la clase Order y cada una de sus operaciones.
// Si queremos incorporar acciones como generar una factura o notificar al cliente,
// tendremos que modificar el controlador.
class OrderController {

    private final Order order;

    public OrderController(Order order) {
        this.order = order;
    }

    public void confirmOrder() {
        order.confirm();
    }

    public void cancelOrder() {
        order.cancel();
    }

    public void prepareOrder() {
        order.sendToKitchen();
    }
}