package it.interno.shipping.service;

import it.interno.common.lib.model.OrderDto;

public interface ShippingService {

    OrderDto generaSpedizione(OrderDto orderDto);

}
