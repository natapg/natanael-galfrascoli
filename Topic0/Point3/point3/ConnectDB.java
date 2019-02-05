package com.natapg.point3;

import com.natapg.inter.DBConecction;

public class ConnectDB implements DBConecction {

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

