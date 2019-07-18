package com.thoughtworks.parking_lot.dao;

import com.thoughtworks.parking_lot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByParkingLotIdAndAndStatus(int id,String status);

}
