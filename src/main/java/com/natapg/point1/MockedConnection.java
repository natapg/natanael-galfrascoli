package com.natapg.point1;

import com.natapg.inter.DBConecction;

/**
 * A Singleton Database connection.
 */
public class MockedConnection implements DBConecction {

  private static MockedConnection connection = new MockedConnection();

  private MockedConnection() {
  }

  public static MockedConnection getInstance() {
    if (connection == null) {
      connection = new MockedConnection();
    }
    return connection;
  }

  @Override
  public boolean connect() {
    System.out.println("Connecting to the database...");
    return true;
  }

  @Override
  public void close() {
    System.out.println("Closing connection...");
  }

}