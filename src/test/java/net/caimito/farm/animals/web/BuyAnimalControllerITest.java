package net.caimito.farm.animals.web;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableMongoRepositories(basePackages = "net.caimito.farm.animals.db")
@ActiveProfiles({"test", "localmongo"})
public class BuyAnimalControllerITest {

    private MockMvc mockMvc;

    @Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}

    @Test @WithMockUser
    public void showForm() throws Exception {
        MockHttpServletRequestBuilder buyAnimal = get("/ui/buy");

        mockMvc.perform(buyAnimal)
            .andExpect(model().hasNoErrors());
    	
    }
    
    @Test @WithMockUser
    public void emptyForm() throws Exception {
        MockHttpServletRequestBuilder buyAnimal = post("/ui/buy");

        mockMvc.perform(buyAnimal)
            .andExpect(model().hasErrors());
    }

}
