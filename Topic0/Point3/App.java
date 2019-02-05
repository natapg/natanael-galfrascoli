package com.natapg;

import com.natapg.inter.DBConecction;
import com.natapg.point1.MockedConnection;
import com.natapg.point2.FactoryConnect;
import com.natapg.point3.ProxyConnection;

public class App {

  public static void main(String[] args) {
    //point1
    MockedConnection c = MockedConnection.getInstance();
    c.connect();
    c.close();
    //point2
    FactoryConnect connectFactory1 = new FactoryConnect();
    DBConecction mySQL = connectFactory1.getConnectionFactory("MySQL").getConnection();
    mySQL.connect();
    mySQL.close();
    //point3
    ProxyConnection connectProxy = new ProxyConnection();
    connectProxy.connect();
    connectProxy.close();

  }
}
