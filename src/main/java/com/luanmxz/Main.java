package com.luanmxz;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import com.luanmxz.web.BankServlet;

public class Main {

  public static void main(String[] args) throws LifecycleException {

    int serverPort = 8080;
    String port = System.getProperty("server.port");
    if (port != null) {
      serverPort = Integer.parseInt(port);
    }

    Tomcat tomcat = new Tomcat();

    tomcat.setPort(serverPort);

    tomcat.getConnector();

    Context ctx = tomcat.addContext("", null);
    Wrapper servlet = Tomcat.addServlet(ctx, "bankServlet", new BankServlet());
    servlet.setLoadOnStartup(1);
    servlet.addMapping("/*");

    tomcat.start();
  }

}
