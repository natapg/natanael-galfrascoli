package com.natapg.point1;

/**
 * A Singleton Database connection.
 */
public class MockedConnection {

  private static MockedConnection connection = new MockedConnection();

  private MockedConnection() {
  }

  public static MockedConnection getInstance() {
    if (connection == null) {
      connection = new MockedConnection();
    }
    return connection;
  }

  public boolean connect() {
    System.out.println("Connecting to the database...");
    return true;
  }

  public void close() {
  }
}