package com.natapg.point3;

import com.natapg.inter.DBConecction;

public class ProxyConnection implements DBConecction {

  private ConnectDB realConnection;

  @Override
  public boolean connect() {
    if (realConnection == null) {
      realConnection = new ConnectDB();
      return realConnection.connect();
    } else {
      return realConnection.connect();
    }
  }

  @Override
  public void close()
     try{
    realConnection.close();
  } catch(NullPointerException npe)
}