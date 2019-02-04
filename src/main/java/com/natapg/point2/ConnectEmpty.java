package com.natapg.point2;

import com.natapg.inter.DBConecction;

public class ConnectEmpty implements DBConecction {

  @Override
  public boolean connect() {
    System.out.println("no database was specified");
    return true;
  }

  @Override
  public void close() {
    System.out.println("no database was specified");
  }

}
