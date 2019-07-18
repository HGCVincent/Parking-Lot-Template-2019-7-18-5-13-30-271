package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.dao.ParkingLotRepository;
import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ParkingLotServiceImpl implements ParkingLotService{

    @Resource
    ParkingLotRepository parkingLotRepository;

    @Override
    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }
}
