package com.natapg.point4;

public class Director {

  private SQLConnectionBuilder sqlConnectionBuilder;

  public void setSQLConnectionBuilder(SQLConnectionBuilder sb) {
    sqlConnectionBuilder = sb;
  }

  public SQLConnection getSQLConnection() {
    return sqlConnectionBuilder.getSQLConnection();
  }

  public void constructSQLConnection() {
    sqlConnectionBuilder.createNewSQLConnection();
    sqlConnectionBuilder.buildHost();
    sqlConnectionBuilder.buildPort();
    sqlConnectionBuilder.buildUser();
    sqlConnectionBuilder.buildPassword();
  }
}
