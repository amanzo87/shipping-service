package it.interno.shipping.service.impl;

import it.interno.common.lib.model.OrderDto;
import it.interno.common.lib.model.ShippingDto;
import it.interno.common.lib.util.Utility;
import it.interno.shipping.entity.Shipping;
import it.interno.shipping.exception.ShippingFallbackException;
import it.interno.shipping.mapper.ShippingMapper;
import it.interno.shipping.repository.ShippingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class ShippingServiceImpl implements it.interno.shipping.service.ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private ShippingMapper shippingMapper;

    @Transactional
    @Override
    public OrderDto generaSpedizione(OrderDto orderDto) {

        try{

            Random random = new Random();
            if(!random.nextBoolean()) {
                return null;
            }

            Shipping shipping = new Shipping();

            shipping.setIdSpedizione( shippingRepository.getMaxIdSpedizione() );
            shipping.setTsInserimento(Utility.getTimestamp());
            shipping.setIdUtenteInserimento(orderDto.getIdUteIns());
            //shipping.setTrackingNumber( generaTrackNumber() );
            shipping.setStatoSpedizione(1);
            shipping.setIdOrdine(orderDto.getIdOrdine());
            shipping.setTsInserimentoOrdine( Utility.convertStringToTimestamp(orderDto.getTsInserimento()) );

            shippingRepository.save(shipping);

            ShippingDto dto = shippingMapper.toDto(shipping);

            orderDto.setShippingDto(dto);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ShippingFallbackException(e.getMessage());
        }

        return orderDto;
    }

    private String generaTrackNumber() {
        return UUID.randomUUID().toString();
    }

}
