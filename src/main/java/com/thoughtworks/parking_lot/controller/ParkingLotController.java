package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.dao.ParkingLotRepository;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/parkingLots/{name}")
    public ParkingLot getParkingLotByName(@PathVariable String name){
        return parkingLotService.getParkingLotByName(name);
    }

    @PutMapping("/parkingLots")
    public ParkingLot updateParkingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotService.updateParkingLot(parkingLot);
    }

//    @GetMapping("/parkingLots/{page}")
//    public Page<ParkingLot> getParkingLotByPageQuery(@PathVariable int page){
//        Pageable pageable = PageRequest.of(page - 1, 15);
//        Page<ParkingLot> ParkingLotPage = parkingLotService.findAll(pageable);
//        return ParkingLotPage;
//    }


}
