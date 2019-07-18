package com.thoughtworks.parking_lot.ControllerTest;

import com.thoughtworks.parking_lot.controller.OrderController;
import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.OrderService;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.xml.ws.Service;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    OrderService orderService;

    @MockBean
    ParkingLotService parkingLotService;


    @Test
    public void should_be_park_car_when_parkinglot_is_not_full() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCapacity(2);
        parkingLot.setName("一号");
        parkingLot.setAddress("珠海");
        parkingLotService.addParkingLot(parkingLot);

        when(orderService.addOrder(any(),any())).thenReturn(any());

        ResultActions result = mvc.perform(post("/parkingLots/{name}/orders/{carNumber}","一号","粤B 134564"));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.id",is(1231)));

        verify(orderService).addOrder(any(),any());
    }

    @Test
    public void should_be_close_the_order_when_fetch_Car() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCapacity(2);
        parkingLot.setName("一号");
        parkingLot.setAddress("珠海");
        parkingLotService.addParkingLot(parkingLot);

        when(orderService.updateOrderByCarNumber(any())).thenReturn(any());

        mvc.perform(post("/parkingLots/{name}/orders/{carNumber}","一号","粤B 134564"));

        ResultActions result = mvc.perform(delete("/orders/{carNumber}","粤B 134564"));
        result.andExpect(status().isOk()).andExpect(jsonPath("$.status",is("close")));

        verify(orderService).updateOrderByCarNumber(any());
    }
}
