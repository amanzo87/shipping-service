package it.interno.shipping.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.interno.common.lib.model.OrderDto;
import it.interno.shipping.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {

    @Autowired
    private it.interno.shipping.service.ShippingService shippingService;

    @Operation(summary = "Gestisce la procedura di spedizione")
    @PostMapping(path = "/genera")
    public ResponseEntity<ResponseDto<OrderDto>> generaSpedizione(@RequestBody OrderDto orderDto) {

        OrderDto dto = shippingService.generaSpedizione(orderDto);

        ResponseDto<OrderDto> response = new ResponseDto<>(
                HttpStatus.OK.value(), dto, null, null
        );

        return ResponseEntity.ok(response);
    }

}
