package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.Exception.NoPositionException;
import com.thoughtworks.parking_lot.dao.OrderRepository;
import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.service.OrderService;
import com.thoughtworks.parking_lot.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/parkingLots/{name}/orders/{carNumber}")
    public Order addOrder(@PathVariable String name, @PathVariable String carNumber){
        try {
            return orderService.addOrder(name,carNumber);
        } catch (NoPositionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
