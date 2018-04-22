package net.caimito.farm.animals.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableMongoRepositories(basePackages = "net.caimito.farm.animals.db")
public class ApiControllerITest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void deleteFromCollection() throws Exception {
        MockHttpServletRequestBuilder ops = delete("/api/animals")
        		.contentType(MediaType.APPLICATION_JSON_UTF8);

        mockMvc.perform(ops)
            .andExpect(status().isOk());
    }

	@Test
	public void putEmptyPayload() throws Exception {
        MockHttpServletRequestBuilder ops = put("/api/animals")
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
        		.content("");

        mockMvc.perform(ops)
            .andExpect(status().isBadRequest());
	}

	@Test
	public void addToCollection() throws Exception {
        MockHttpServletRequestBuilder ops = put("/api/animals")
        		.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        		.content("{ \"species\": \"SHEEP\", \"eid\": \"abc\" }");

        mockMvc.perform(ops)
            .andExpect(status().isCreated())
            .andExpect(header().exists("location"));
	}
}
