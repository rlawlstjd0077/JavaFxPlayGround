package com.jinseong.soft.rest;

public class RestServiceLauncher {

  public static void main(String[] args) {
    RestService service = new RestService("127.0.0.1");
    service.start("com.jinseong.soft.rest.domain");
  }
}
