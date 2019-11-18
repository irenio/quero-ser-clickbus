package com.example.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

class PlaceControllerTests extends ChallengeApplicationTests {
		
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGETListPlaces() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/place").requestAttr("name", ""))				
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGETListPlacesWithFilterByName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/place").requestAttr("name", "test"))				
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGETPlaceById() throws Exception {		
		mockMvc.perform(MockMvcRequestBuilders.get("/place").requestAttr("id", 1))				
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testPOSTCreatePlace() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/place").contentType(MediaType.APPLICATION_JSON)
                .content(createPlaceInJson("Place Test","place_test","Salvador","BA")))				
				.andExpect(MockMvcResultMatchers.status().isOk());			
	}
	
	@Test
	public void testPUTEditPlace() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.put("/place").contentType(MediaType.APPLICATION_JSON)
                .content(createPlaceInJson(1, "Place Test","place_test","Salvador","BA")))				
				.andExpect(MockMvcResultMatchers.status().isOk());			
	}
	
	private static String createPlaceInJson (String name, String slug, String city, String state) {
        return "{ \"name\": \"" + name + "\", " +
                  "\"slug\":\"" + slug + "\"," +
                  "\"city\":\"" + city + "\"," +
                  "\"state\":\"" + state + "\"}";
    }
	
	private static String createPlaceInJson (int id, String name, String slug, String city, String state) {
        return "{ \"id\": \"" + id + "\", " +
                  "\"name\":\"" + name + "\"," +
                  "\"slug\":\"" + slug + "\"," +
                  "\"city\":\"" + city + "\"," +
                  "\"state\":\"" + state + "\"}";
    }
	

}
