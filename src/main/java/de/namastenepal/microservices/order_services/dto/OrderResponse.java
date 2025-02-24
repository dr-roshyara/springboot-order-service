package de.namastenepal.microservices.order_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse{
    private Long id;             // Order ID
    private String orderNumber;  // Unique order identifier
    private String skuCode;      // Product SKU code
    private BigDecimal price;    // Price per unit
    private Integer quantity;    // Quantity ordered
}
