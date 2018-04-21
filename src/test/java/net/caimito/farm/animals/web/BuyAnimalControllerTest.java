package net.caimito.farm.animals.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BuyAnimalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showForm() throws Exception {
        MockHttpServletRequestBuilder buyAnimal = get("/ui/buy");

        mockMvc.perform(buyAnimal)
            .andExpect(model().hasNoErrors());
    	
    }
    
    @Test
    public void emptyForm() throws Exception {
        MockHttpServletRequestBuilder buyAnimal = post("/ui/buy");

        mockMvc.perform(buyAnimal)
            .andExpect(model().hasErrors());
    }

}
