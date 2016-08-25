package orderpicker.buffer;

import orderpicker.models.domain.Order;

import java.util.*;

/**
 * Michelle Beckers
 * Datum: 25-8-2016
 * Time: 02:23
 */
public class OrderBuffer implements Buffer<Order> {
    private long duration;
    private boolean allowRetrieval;
    private List<Order> orders;
    private Timer timer;

    public OrderBuffer(long duration) {
        this.duration = duration;
        this.allowRetrieval = false;
        this.orders = new ArrayList<>();
        this.startTimer();
    }

    private void startTimer() {
        this.allowRetrieval = false;

        this.timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                OrderBuffer.this.allowRetrieval = true;
            }
        };

        timer.schedule(task, duration);
    }

    @Override
    public void buffer(Order target) {
        this.orders.add(target);
    }

    @Override
    public void clear() {
        this.orders.clear();
    }

    @Override
    public List<Order> getBufferedItems() {
        List<Order> copies = new ArrayList<>();

        if (this.allowRetrieval) {
            copies = new ArrayList<>(this.orders);
            this.clear();
            this.startTimer();
        }

        return copies;
    }
}
