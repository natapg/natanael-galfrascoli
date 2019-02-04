package com.natapg.point2;

import com.natapg.inter.DBConecction;

public class PostgreSQLConnection implements DBConecction {

  private String host;
  private int port;
  private String user;
  private String password;

  public PostgreSQLConnection(String host, int port, String user, String password) {
    this.host = host;
    this.port = port;
    this.user = user;
    this.password = password;
  }

  @Override
  public boolean connect() {
    System.out.println("Connecting to the database PostgreSQL...");
    return true;
  }

  @Override
  public void close() {
    System.out.println("Closing connection PostgreSQL...");
  }

}
