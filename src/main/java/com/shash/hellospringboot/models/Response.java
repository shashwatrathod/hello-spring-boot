package com.shash.hellospringboot.models;

/**
 * Represents a generic response template for requests to the web service.
 */
public interface Response {

  /**
   * Returns whether the request was completed successfully.
   */
  boolean getIsOk();

  /**
   * Returns the getMessage associated with this response.
   */
  String getMessage();

  /**
   * Sets the status of this request.
   */
  void setIsOk(boolean isOk);

  /**
   * Sets the message to be returned.
   */
  void setMessage(String message);
}
