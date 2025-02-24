package de.namastenepal.microservices.order_services.model;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "t_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment primary key
    private Long id;
    @Column(name= "order_number", nullable = false,unique = true)
    private String orderNumber;
    @Column(name="sku_code", nullable = false)
    private String skuCode;
    @Column (name= "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Column (name="quantity", nullable = false)
    private Integer quantity;
}
