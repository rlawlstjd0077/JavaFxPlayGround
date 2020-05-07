package com.jinseong.soft.rest;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ApiService {
  public static final int REST_API_PORT = 19080;

  protected final String ip;
  protected Client client;
  protected WebTarget target;

  public ApiService(String ip)  {
    this.ip = ip;
  }

  public void start() {
    client = ClientBuilder.newClient();
    target = client.target("http://" + ip + ":" + REST_API_PORT + "/api");
  }

  public void start(int restApiPort) {
    client = ClientBuilder.newClient();
    target = client.target("http://" + ip + ":" + restApiPort + "/api");
  }

  public void close() {
    if (client != null) {
      client.close();
      client = null;
    }
  }

  protected String requestGetData(String path) {
    final Response response = target.path(path).request().get();
    if (response.getStatus() == Response.Status.OK.getStatusCode()) {
      return response.readEntity(String.class);
    } else {
      throw new InternalServerErrorException(response.readEntity(String.class));
    }
  }
}
