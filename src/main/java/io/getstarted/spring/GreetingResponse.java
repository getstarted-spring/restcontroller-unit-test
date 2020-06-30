package io.getstarted.spring;

public class GreetingResponse {

  private String message;

  public GreetingResponse(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setText(String message) {
    this.message = message;
  }
}
