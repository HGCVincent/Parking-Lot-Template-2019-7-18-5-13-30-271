package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.Exception.NoPositionException;
import com.thoughtworks.parking_lot.model.Order;

public interface OrderService {
    Order addOrder(String name, String carNumber) throws NoPositionException;
}
