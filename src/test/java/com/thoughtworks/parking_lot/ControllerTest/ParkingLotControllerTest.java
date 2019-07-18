package com.thoughtworks.parking_lot.ControllerTest;

import com.thoughtworks.parking_lot.controller.ParkingLotController;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ParkingLotController.class)
public class ParkingLotControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    ParkingLotService parkingLotService;

    @Test
    public void should_add_parkingLot() throws Exception {
        ParkingLot parkingLot =new ParkingLot();
        parkingLot.setName("zhuhai");
        parkingLot.setAddress("zh");
        parkingLot.setCapacity(1);

        when(parkingLotService.addParkingLot(any())).thenReturn(parkingLot);
        ResultActions result = mvc.perform(post("/parkingLots").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "\"name\": \"zhuhai\",\n" +
                "\"capacity\": 1,\n" +
                "\"address\": \"zh\"\n" +
                "}"));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.name",is("zhuhai"))).andExpect(jsonPath("$.address",is("zh")));

        verify(parkingLotService).addParkingLot(any());
    }

    @Test
    public void should_delete_parkingLot() throws Exception {
        String parkingLotJson = "{\n" +
                "\"name\": \"zhuhai\",\n" +
                "\"capacity\": 1,\n" +
                "\"address\": \"zh\"\n" +
                "}";

        doNothing().when(parkingLotService).deleteParkingLot(any());
        mvc.perform(post("/parkingLots").contentType(MediaType.APPLICATION_JSON).content(parkingLotJson));
        mvc.perform(delete("/parkingLots").contentType(MediaType.APPLICATION_JSON).content(parkingLotJson));

        verify(parkingLotService).deleteParkingLot(any());
    }

    @Test
    public void should_find_parkingLot_by_name() throws Exception {
        ParkingLot parkingLot =new ParkingLot();
        parkingLot.setName("zhuhai");
        parkingLot.setAddress("zh");
        parkingLot.setCapacity(1);

        String parkingLotJson = "{\n" +
                "\"name\": \"zhuhai\",\n" +
                "\"capacity\": 1,\n" +
                "\"address\": \"zh\"\n" +
                "}";
        when(parkingLotService.getParkingLotByName(any())).thenReturn(parkingLot);

        mvc.perform(post("/parkingLots").contentType(MediaType.APPLICATION_JSON).content(parkingLotJson));
        ResultActions result = mvc.perform(get("/parkingLots/{name}","zhuhai"));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.address",is("zh")));

        verify(parkingLotService).getParkingLotByName(any());
    }

    @Test
    public void should_update_parkingLot() throws Exception {
        String parkingLotJson = "{\n" +
                "\"name\": \"zhuhai\",\n" +
                "\"capacity\": 1,\n" +
                "\"address\": \"zh\"\n" +
                "}";

        String parkingLotJson1 = "{\n" +
                "\"name\": \"zhuhai1\",\n" +
                "\"capacity\": 1,\n" +
                "\"address\": \"zh\"\n" +
                "}";
        when(parkingLotService.updateParkingLot(any())).thenReturn(any());

        mvc.perform(post("/parkingLots").contentType(MediaType.APPLICATION_JSON).content(parkingLotJson));
        ResultActions result = mvc.perform(put("/parkingLots").contentType(MediaType.APPLICATION_JSON).content(parkingLotJson1));

        result.andExpect(status().isOk());

        verify(parkingLotService).updateParkingLot(any());
    }

}
