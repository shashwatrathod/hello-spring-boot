package com.shash.hellospringboot.models;

/**
 * Represents a generic response template for requests to the web service.
 */
public interface Response {

  /**
   * Returns the builder for Response. Builder can be used to set different
   * parameters that the response returns.
   */
  static ResponseBuilder builder() {
    return null;
  }

  /**
   * Returns whether the request was completed successfully.
   */
  boolean isOk();

  /**
   * Returns the message associated with this response.
   */
  String message();
}
