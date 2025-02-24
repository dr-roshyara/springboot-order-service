package de.namastenepal.microservices.order_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest{
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
