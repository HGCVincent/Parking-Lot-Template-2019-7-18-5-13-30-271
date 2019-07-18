package com.thoughtworks.parking_lot.dao;

import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot,Integer> {
    public ParkingLot findByName(String name);
}
