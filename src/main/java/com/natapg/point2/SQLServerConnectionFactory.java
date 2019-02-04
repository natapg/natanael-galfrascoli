package com.natapg.point2;

import com.natapg.inter.ConnectionFactory;
import com.natapg.inter.DBConecction;

public class SQLServerConnectionFactory implements ConnectionFactory {


  @Override
  public DBConecction getConnection() {
    return new SQLServerConnection("localhost",1614,"admin","1234");
  }
}
