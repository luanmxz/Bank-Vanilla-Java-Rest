package com.luanmxz.domain.model;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Transaction {

  private String id;
  private Integer amount;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmZ")
  private ZonedDateTime timestamp;
  private String reference;

  public Transaction() {
  }

  public Transaction(Integer amount, String reference) {
    this.id = UUID.randomUUID().toString();
    this.amount = amount;
    this.timestamp = ZonedDateTime.now();
    this.reference = reference;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(ZonedDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

}