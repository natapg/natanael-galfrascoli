package com.natapg.point2;

import com.natapg.inter.ConnectionFactory;

public class FactoryConnect {

  public ConnectionFactory getConnectionFactory(String dataBase) {

    if (dataBase == null) {
      throw new IllegalArgumentException("database cant be null");
    }

    if (dataBase.equals("MySQL")) {
      return new MySQLConnectionFactory();
    } else if (dataBase.equals("PostgreSQL")) {
      return new PostgreSQLConnectionFactory();
    } else if (dataBase.equals("SQLServer")) {
      return new SQLServerConnectionFactory();
    }
    throw new IllegalArgumentException("No matching factory to" + dataBase);
  }

}
