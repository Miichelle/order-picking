package orderpicker.consumation;

import orderpicker.models.domain.Order;
import orderpicker.models.dto.OrderDto;
import orderpicker.models.mapping.MapToDTO;
import orderpicker.sending.Sender;
import orderpicker.sending.SenderException;
import org.apache.log4j.Logger;

/**
 * Michelle Beckers
 * Datum: 12-8-2016
 * Time: 22:30
 */
public class OrderSendingConsumer implements Consumer<Order> {
    private final Logger logger = Logger.getLogger(OrderSendingConsumer.class);

    private Sender<OrderDto> sender;

    public OrderSendingConsumer(Sender<OrderDto> sender) {
        this.sender = sender;
    }

    @Override
    public void consume(Order target) {
        OrderDto dto = MapToDTO.map(target);
        try {
            this.sender.send(dto);
        } catch (SenderException e) {
            logger.error("Something went wrong while consuming an order");
        }
    }
}
