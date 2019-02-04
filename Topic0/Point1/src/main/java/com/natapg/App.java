package com.natapg;

import com.natapg.inter.DBConecction;
import com.natapg.point1.MockedConnection;
import com.natapg.point2.FactoryConnect;

public class App {

  public static void main(String[] args) {
    MockedConnection c = MockedConnection.getInstance();
    c.connect();
    c.close();
    FactoryConnect conectFactory1 = new FactoryConnect();
    DBConecction mySQL = conectFactory1.getConnectionFactory("MySQL").getConnection();

  }
}
