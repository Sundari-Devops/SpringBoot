package com.altimetrik;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.altimetrik.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class RestfulApicrudApplicationTests {

	//@Test
	//void contextLoads() {
	//}

	@Autowired
	private MockMvc mockmvc;
	
	protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, clazz);
         }
  protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
     }
	
	
	/*@Test
	public void testGetName() throws Exception {
		mockmvc.perform(get("/getName")).
		andExpect(status().isOk()).
		andExpect(jsonPath("$.name").value("AnuRadha"));
		
		//perform(get("/getName")).
		
	}*/
  @Test
	public void testCreateStudent() throws Exception {
		
		String uri = "/saveStudent";
		Student s = new Student();
		s.setName("Sundari");
		s.setCollegeName("SSN");
		s.setCgpa(8.56);
		String inputJson = mapToJson(s) ;
		MvcResult  mvcResult = mockmvc.perform(MockMvcRequestBuilders.post(uri).
				contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		System.out.println("Staus===>"+status);
		assertEquals(200, status);
		String msg = JsonPath.read(mvcResult.getResponse().getContentAsString(),"$.msg");
		System.out.println(msg);
		assertEquals(msg, "Success");

		
		
	}
	
	
	
}
