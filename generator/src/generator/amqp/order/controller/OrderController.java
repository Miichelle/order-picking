package generator.amqp.order.controller;

/**
 * Michelle Beckers
 * Datum: 8-8-2016
 * Time: 23:23
 */
public class OrderController {
    private int nextId;

    public OrderController(int startingId) {
        this.nextId = startingId;
    }

    public int getNextId() { return this.nextId; }
}
