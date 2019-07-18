package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ParkingLotController {
    @Autowired
    ParkingLotService parkingLotService;

    @PostMapping(value = "/parkingLots")
    public ParkingLot addParkingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotService.addParkingLot(parkingLot);
    }

    @DeleteMapping("/parkingLots")
    public void deleteParkingLot(@RequestBody ParkingLot parkingLot){
        parkingLotService.deleteParkingLot(parkingLot);
    }


}