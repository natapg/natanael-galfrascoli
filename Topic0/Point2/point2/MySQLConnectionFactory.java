package com.natapg.point2;

import com.natapg.inter.ConnectionFactory;
import com.natapg.inter.DBConecction;

public class MySQLConnectionFactory implements ConnectionFactory {


  @Override
  public DBConecction getConnection() {
    return new MySQLConnection("localhost",1614,"admin","1234");
  }
}
