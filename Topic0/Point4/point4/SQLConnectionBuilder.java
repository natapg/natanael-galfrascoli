package com.natapg.point4;

/*"abstract builder"*/
public abstract class SQLConnectionBuilder {

  protected SQLConnection sqlConnection;

  public SQLConnection getSQLConnection() {
    return sqlConnection;
  }

  public void createNewSQLConnection() {
    sqlConnection = new SQLConnection();
  }

  public abstract void buildHost();

  public abstract void buildPort();

  public abstract void buildUser();

  public abstract void buildPassword();
}