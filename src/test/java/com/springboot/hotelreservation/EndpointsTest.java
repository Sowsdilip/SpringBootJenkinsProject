//package com.springboot.hotelreservation;
//
////import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
////import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.springboot.hotelreservation.controller.ReservationController;
//import com.springboot.hotelreservation.service.ReservationService;
//
//@WebMvcTest(ReservationController.class)
//public class EndpointsTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//	@MockBean
//	private ReservationService service;
//
//	@Test
//	public void welcomeTest() throws Exception {
//
//		RequestBuilder request = MockMvcRequestBuilders.get("/api/wel-come").accept(MediaType.APPLICATION_JSON);
//
//		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
//				.andExpect(MockMvcResultMatchers.content().string("welcome to hotel reservation")).andReturn();
//
//	}
//
////	@Test
////	public void findGuestByIdTest() throws Exception {
////
////		RequestBuilder request = MockMvcRequestBuilders.get("/api/guests/1").accept(MediaType.APPLICATION_JSON);
////
////		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
////				.andExpect(MockMvcResultMatchers.content().json("{\"guestId\":1\"}"))
////				.andReturn();
////
////	}
//
//}
