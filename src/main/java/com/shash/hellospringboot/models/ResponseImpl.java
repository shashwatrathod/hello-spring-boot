package com.shash.hellospringboot.models;

/**
 * Represents the body of generic response to a request.
 */
public class ResponseImpl implements Response {

  private String message;
  private boolean isOk;

  public ResponseImpl() {}

  public ResponseImpl(String message, boolean isOk) {
    this.message = message;
    this.isOk = isOk;
  }

  @Override
  public boolean getIsOk() {
    return this.isOk;
  }

  @Override
  public String getMessage() {
    return this.message;
  }

  @Override
  public void setIsOk(boolean isOk) {
    this.isOk = isOk;
  }

  @Override
  public void setMessage(String message) {
    this.message = message;
  }
}
