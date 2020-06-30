package io.getstarted.spring;

public class GreetingRequest {

  private String name;

  public GreetingRequest(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
