package generator.consumation;

import generator.models.domain.Order;
import generator.models.dto.OrderDto;
import generator.models.mapping.Mapper;
import generator.sending.Sender;
import generator.sending.SenderException;

/**
 * Michelle Beckers
 * Datum: 12-8-2016
 * Time: 22:30
 */
public class OrderSendingConsumer implements Consumer<Order> {
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
        }
    }
}
