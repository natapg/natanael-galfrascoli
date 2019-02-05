package com.natapg.point4;

/*"concrete builder inherit abstract builder"*/
public class ConcreteBuilder extends SQLConnectionBuilder {

  public void buildHost() {
    sqlConnection.setHost("Host1");
  }

  public void buildPort() {
    sqlConnection.setPort(1600);

  }

  public void buildUser() {
    sqlConnection.setUser("Admin");
  }

  public void buildPassword() {
    sqlConnection.setPassword("123");
  }
}
