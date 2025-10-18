package com.example.Database.connection.service;

import com.example.Database.connection.model.dto.OrderDTO;
import com.example.Database.connection.model.entity.Order;
import com.example.Database.connection.model.entity.User;
import com.example.Database.connection.repository.OrderRepository;
import com.example.Database.connection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository){
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public List<Order> getOrdersByUserId(Long userId){
        return orderRepository.findByUserId(userId);
    }

    public Order createOrder(OrderDTO dto){
        //krijo nje objekt bosh Order, qe do te plotesohet me te dhena
        Order order = new Order();
        //merr total price nga dto dhe vendose ne objektin order
        order.setPrice(dto.getTotalPrice());
        //vendos daten aktuale si daten e krijimit te porosise
        order.setOrderDate(LocalDate.now());
        //kerkojme ne databaze per nje user me id qe vjen nga dto
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(()-> new RuntimeException("User nk u gjet"));

        //vendos perdoruesin e gjetur si owner te kesaj porosie
        //(@ManyToOne) ktu perdoret
        order.setUser(user);
        //ruhet porosia ne databaze
        return orderRepository.save(order);
    }
}
