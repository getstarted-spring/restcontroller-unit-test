package io.getstarted.spring;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(controllers = {MessagingRestService.class})
class MessagingRestServiceMvcTests {

  @Autowired private MockMvc mvc;

  @Test
  void getMessage() throws Exception {
    final ResultActions result =
        mvc.perform(
            get("/message").queryParam("name", "Foo").contentType(MediaType.APPLICATION_JSON));
    result
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.text", is("Hello Foo")));
  }

  @Test
  void setMessage() throws Exception {
    final ResultActions result =
        mvc.perform(
            post("/message")
                .content("{ \"text\": \"Hello\" }")
                .contentType(MediaType.APPLICATION_JSON));
    result
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", is(true)));
  }
}
