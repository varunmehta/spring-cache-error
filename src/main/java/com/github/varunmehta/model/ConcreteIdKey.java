package com.github.varunmehta.model;

import java.io.Serializable;

public class ConcreteIdKey implements Serializable {

  private static final long serialVersionUID = 7215466727970743133L;
  
  private Integer id;
  private String value;

  public ConcreteIdKey(Integer id, String value) {
    this.id = id;
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public String getValue() {
    return value;
  }

}
