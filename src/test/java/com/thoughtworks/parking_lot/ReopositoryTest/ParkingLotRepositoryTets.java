package com.thoughtworks.parking_lot.ReopositoryTest;


import com.thoughtworks.parking_lot.dao.ParkingLotRepository;
import com.thoughtworks.parking_lot.model.ParkingLot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ParkingLotRepositoryTets {
    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Test
    public void should_add_a_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("zh parkingLot");
        parkingLot.setAddress("zh");
        parkingLot.setCapacity(1);

        ParkingLot result = parkingLotRepository.save(parkingLot);

        assertEquals("zh parkingLot",result.getName());
    }

    @Test
    public void should_delete_a_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("zh parkingLot");
        parkingLot.setAddress("zh");
        parkingLot.setCapacity(1);

        ParkingLot result = parkingLotRepository.save(parkingLot);
        parkingLotRepository.delete(result);

        assertEquals(0,parkingLotRepository.findAll().size());
    }

    @Test
    public void should_find_all_parking_lot(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("zh parkingLot");
        parkingLot.setAddress("zh");
        parkingLot.setCapacity(1);

        ParkingLot parkingLot1 = new ParkingLot();
        parkingLot1.setName("gz parkingLot");
        parkingLot1.setAddress("gz");
        parkingLot1.setCapacity(1);

        parkingLotRepository.save(parkingLot);
        parkingLotRepository.save(parkingLot1);

        assertEquals(2,parkingLotRepository.findAll().size());
    }


}
