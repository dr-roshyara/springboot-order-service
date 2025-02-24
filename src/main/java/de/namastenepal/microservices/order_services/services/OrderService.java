package de.namastenepal.microservices.order_services.services;

import de.namastenepal.microservices.order_services.dto.OrderRequest;
import de.namastenepal.microservices.order_services.dto.OrderResponse;
import de.namastenepal.microservices.order_services.model.Order;
import de.namastenepal.microservices.order_services.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService (OrderRepository orderRepository){
        this.orderRepository =orderRepository;
    }

    public OrderResponse createOrder( OrderRequest orderRequest){
        //create Order
        Order order =new Order();

        order.setOrderNumber(orderRequest.getOrderNumber());
        order.setSkuCode(orderRequest.getSkuCode());
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());
        Order savedOrder =orderRepository.save(order);

        return new OrderResponse(
                savedOrder.getId(),
                savedOrder.getOrderNumber(),
                savedOrder.getSkuCode(),
                savedOrder.getPrice(),
                savedOrder.getQuantity()
        );


    }
    // get order by Id
    public OrderResponse getOrderById(Long id) {
        Optional<Order> order =orderRepository.findById(id);

        if(order.isPresent()){
            return new OrderResponse(
                    order.get().getId(),
                    order.get().getOrderNumber(),
                    order.get().getSkuCode(),
                    order.get().getPrice(),
                    order.get().getQuantity()
            );
        }else {
            // You can throw an exception or return null depending on your error handling strategy
            throw new RuntimeException("Order not found with ID " + id);
        }
    }

    //all orders
    public List<OrderResponse>  getAllOrders(){
        List<Order> orders =orderRepository.findAll();
        return orders.stream()
                .map(order->new OrderResponse(
                       order.getId(),
                        order.getOrderNumber(),
                        order.getSkuCode(),
                        order.getPrice(),
                        order.getQuantity()
                ))
                .collect(Collectors.toList());
    }
}
