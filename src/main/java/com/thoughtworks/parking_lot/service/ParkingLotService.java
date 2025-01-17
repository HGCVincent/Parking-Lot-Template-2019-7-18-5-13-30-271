package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ParkingLotService {
    ParkingLot addParkingLot(ParkingLot parkingLot);

    void deleteParkingLot(ParkingLot parkingLot);


    ParkingLot getParkingLotByName(String name);

    ParkingLot updateParkingLot(ParkingLot parkingLot);

//    Page<ParkingLot> findAll(Pageable pageable);
}
