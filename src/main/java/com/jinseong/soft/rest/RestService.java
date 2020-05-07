package com.jinseong.soft.rest;

import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class RestService {
  public static final int REST_API_PORT = 19080;

  private final String ip;

  private HttpServer rest;

  public RestService(String ip) {
    this.ip = ip;
  }

  /**
   * REST API 서버를 시작.
   */
  public void start(String packageName) {
    start(packageName, REST_API_PORT);
  }

  /**
   * REST API 서버를 특정 포트로 시작.
   */
  public void start(String packageName, int restApiPort) {
    final String baseUri = "http://" + ip + ":" + restApiPort + "/api/";
    final ResourceConfig rc = new ResourceConfig().packages(packageName); // REST API 제공 패키지 명칭을 반드시 작성
    rest = GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUri), rc);
  }

  /**
   * REST API 서버를 종료.
   */
  public void close() {
    if (rest != null) {
      rest.shutdown();
    }
  }
}
