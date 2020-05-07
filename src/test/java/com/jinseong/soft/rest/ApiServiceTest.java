package com.jinseong.soft.rest;

import org.junit.Test;

public class ApiServiceTest {

  @Test
  public void startApiService() {
    ApiService service = new ApiService("127.0.0.1");
    service.requestGetData("/main/hello");
  }
}
