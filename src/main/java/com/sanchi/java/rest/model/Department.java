package com.sanchi.java.rest.model;

public class Department {

  private int id;
  private String name;

  public Department() {

  }

  /**
   * Creates an instance of Department.o
   */
  public Department(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
