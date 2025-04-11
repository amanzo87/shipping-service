package it.interno.shipping.mapper;

import it.interno.common.lib.model.ShippingDto;
import it.interno.shipping.entity.Shipping;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShippingMapper {

    @Mappings(
            @Mapping(target = "tsInserimento",
                    expression = "java(shippingDto.getTsInserimento() != null ? it.interno.common.lib.util.Utility.convertStringToTimestamp(shippingDto.getTsInserimento()) : null)")
    )
    Shipping toEntity(ShippingDto shippingDto) ;

    @InheritInverseConfiguration
    @Mappings(
            @Mapping(target = "tsInserimento",
                    expression = "java(shipping.getTsInserimento() != null ? it.interno.common.lib.util.Utility.convertTimestampToString(shipping.getTsInserimento()) : null)")
    )
    ShippingDto toDto(Shipping shipping);

}
