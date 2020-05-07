package com.jinseong.soft.rest;

import org.junit.Test;

public class RestServiceTest {
  @Test
  public void startRestService() {
    RestService service = new RestService("127.0.0.1");
    service.start("com.jinseong.soft.rest.domain");
    while(true);
  }
}
