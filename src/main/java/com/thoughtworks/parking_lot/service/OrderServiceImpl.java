package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.Exception.NoPositionException;
import com.thoughtworks.parking_lot.dao.OrderRepository;
import com.thoughtworks.parking_lot.dao.ParkingLotRepository;
import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Override
    public Order addOrder(String parkingLotName, String carNumber) throws NoPositionException{
        ParkingLot parkingLot = parkingLotRepository.findByName(parkingLotName);
        int usedPosition = orderRepository.findByParkingLotIdAndAndStatus(parkingLot.getId(),"open").size();
        if (usedPosition >= parkingLot.getCapacity()){
            throw new NoPositionException();
        }
        else {
            Order order =new Order();
            order.setStartTime(new Timestamp(System.currentTimeMillis()));
            order.setCarNumber(carNumber);
            order.setStatus("open");
            return orderRepository.save(order);
        }
    }

    @Override
    public Order updateOrderByCarNumber(String carNumber) {
        Order order = orderRepository.findByCarNumber(carNumber);
        order.setEndTime(new Timestamp(System.currentTimeMillis()));
        order.setStatus("close");
        return order;
    }
}
