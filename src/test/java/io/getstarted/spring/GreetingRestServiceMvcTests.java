package io.getstarted.spring;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {GreetingRestService.class})
class GreetingRestServiceMvcTests {

  @Autowired private MockMvc mvc;

  @Test
  void getWelcomeMessage() throws Exception {
    mvc.perform(get("/welcome").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message", is("Welcome")));
  }

  @Test
  void getWelcomeMessage_givenName() throws Exception {
    mvc.perform(get("/welcome").queryParam("name", "abc").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message", is("Welcome abc")));
  }
}
