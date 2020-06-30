package io.getstarted.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestService {

  @GetMapping(path = "/welcome")
  public GreetingResponse getWelcomeMessage() {
    return new GreetingResponse("Welcome");
  }

  @GetMapping(
      path = "/welcome",
      params = {"name"})
  public GreetingResponse getWelcomeMessage(final GreetingRequest greetingRequest) {
    return new GreetingResponse(String.format("Welcome %s", greetingRequest.getName()));
  }
}
