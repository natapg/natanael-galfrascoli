package com.natapg.point2;

import com.natapg.inter.ConnectionFactory;
import com.natapg.inter.DBConecction;

public class PostgreSQLConnectionFactory implements ConnectionFactory {


  @Override
  public DBConecction getConnection() {
    return new PostgreSQLConnection("localhost",1614,"admin","1234");
  }
}
