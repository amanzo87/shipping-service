package it.interno.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<it.interno.shipping.entity.Shipping, it.interno.shipping.entity.key.ShippingKey> {

    @Query(value =
            "SELECT COALESCE(MAX(ID_SHIPPING), 0) + 1 AS ID_SHIPPING " +
            "FROM SHOP1.SHIPPING ", nativeQuery = true)
    int getMaxIdSpedizione();

}
