package generator.consumation;

import generator.models.domain.Order;
import generator.models.dto.OrderDto;
import generator.models.mapping.Mapper;
import generator.sending.Sender;
import generator.sending.SenderException;
import org.apache.log4j.Logger;

/**
 * Michelle Beckers
 * Datum: 12-8-2016
 * Time: 22:30
 */
//todo generator genereert, consumer pickt dat op en stuurt door naar 3 partij ( = sender in dit geval)
public class OrderSendingConsumer implements Consumer<Order> {
    private final Logger logger = Logger.getLogger(OrderSendingConsumer.class);

    private Sender<OrderDto> sender;

    public OrderSendingConsumer(Sender<OrderDto> sender) {
        this.sender = sender;
    }

    @Override
    public void consume(Order target) {
        OrderDto dto = Mapper.map(target);

       try {
            this.sender.send(dto);
        } catch (SenderException e) {
            // do something
            logger.error("Something went wrong while consuming an order");
        }
    }
}
