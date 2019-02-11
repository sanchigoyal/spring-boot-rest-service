package com.sanchi.java.rest.exception;

public class RecordNotFoundException extends Exception {

  private int id;
  private String entity;

  public RecordNotFoundException(int id, String entity) {
    this.id = id;
    this.entity = entity;
  }

  public int getId() {
    return id;
  }

  public String getEntity() {
    return entity;
  }
}
