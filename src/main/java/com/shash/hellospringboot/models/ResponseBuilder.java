package com.shash.hellospringboot.models;

/**
 * Represents a builder for the {@link Response}.
 */
public interface ResponseBuilder {

  /**
   * Sets the status for this request. By default,
   * <var>isOk</var> is {@code true}.
   *
   * @param isOk whether the request was completed successfully.
   *
   * @return this ResponseBuilder.
   */
  ResponseBuilder setIsOk(boolean isOk);

  /**
   * Sets the message associated with the response. By default,
   * <var>message</var> is {@code ""}.
   *
   * @return this ResponseBuilder.
   */
  ResponseBuilder setMessage(String message);

  /**
   * Builds the response Object based on the inputs to this builder.
   *
   * @return a new response.
   *
   */
  Response build();
}
