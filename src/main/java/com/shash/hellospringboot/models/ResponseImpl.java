package com.shash.hellospringboot.models;

/**
 * Represents the body of generic response to a request.
 */
public class ResponseImpl implements Response {

  private final String message;
  private final boolean isOk;

  protected ResponseImpl(String message, boolean isOk) {
    this.message = message;
    this.isOk = isOk;
  }

  @Override
  public boolean isOk() {
    return this.isOk;
  }

  @Override
  public String message() {
    return this.message;
  }

  public static ResponseBuilder builder() {
    return new ResponseBuilderImpl();
  }

  protected static class ResponseBuilderImpl implements ResponseBuilder {

    private String message;
    private boolean isOk;

    protected ResponseBuilderImpl() {
      this.message = "";
      this.isOk = true;
    }

    @Override
    public ResponseBuilder setIsOk(boolean isOk) {
      this.isOk = isOk;
      return this;
    }

    @Override
    public ResponseBuilder setMessage(String message) {
      this.message = message;
      return this;
    }

    @Override
    public Response build() {
      return new ResponseImpl(message, isOk);
    }
  }
}
