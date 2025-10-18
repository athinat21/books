package com.example.Database.connection.controller;

import com.example.Database.connection.model.dto.OrderDTO;
import com.example.Database.connection.model.entity.Order;
import com.example.Database.connection.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId){
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO dto){
        Order order = orderService.createOrder(dto);
        return ResponseEntity.ok(order);
    }
}
