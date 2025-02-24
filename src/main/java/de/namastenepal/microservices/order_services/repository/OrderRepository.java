package de.namastenepal.microservices.order_services.repository;

import de.namastenepal.microservices.order_services.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //find order by order number
    Optional<Order> findByOrderNumber(String orderNumber);

    //find order by sku code
    List<Order> findBySkuCode(String skucode);

    //find Order by Price greater than a certain value
    List<Order> findByPriceGreaterThanEqual(BigDecimal price);

    //Find order by Quantity greater than or equal to certain value

    List<Order> findByQuantityGreaterThanEqual(Integer  quantity);
}
