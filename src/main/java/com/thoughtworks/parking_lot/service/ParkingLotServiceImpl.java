package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.dao.ParkingLotRepository;
import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingLotServiceImpl implements ParkingLotService{

    @Resource
    ParkingLotRepository parkingLotRepository;

    @Override
    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public void deleteParkingLot(ParkingLot parkingLot) {
        parkingLotRepository.delete(parkingLot);
    }

    @Override
    public ParkingLot getParkingLotByName(String name) {
        return parkingLotRepository.findByName(name);
    }


}
