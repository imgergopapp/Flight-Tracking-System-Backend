package com.irems.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.irems.entity.Flight;
import com.irems.service.FlightService;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightRestController.class)
public class FlightRestControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private FlightService flightService;

	@Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
      throws Exception {
         
        Flight flight = new Flight(
				"TestCompany",
				LocalDateTime.of(2019, 05, 05, 10, 0, 5),
				LocalDateTime.of(2019, 05, 05, 10, 0, 5),
				LocalDateTime.of(2019, 05, 05, 11, 0, 0)
		);
        flightService.save(flight);
        List<Flight> flights = Arrays.asList(flight);

        mvc.perform(get("/flights")
         .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().contentType("application/json;charset=UTF-8"))
          .andExpect(jsonPath("$[0].company").value("TestCompany")
        );
        }
}