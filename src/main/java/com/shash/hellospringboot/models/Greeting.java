package com.shash.hellospringboot.models;

public class Greeting {
  private final long id;
  private final String content;

  public Greeting(long id, String content) {
    if (id <= 0) {
      throw new IllegalArgumentException("The id is zero.");
    }

    if (content == null || content.length() == 0) {
      throw new IllegalArgumentException("The content is invalid");
    }

    this.id = id;
    this.content = content;
  }

  public long getId() {
    return this.id;
  }

  public String getContent() {
    return content;
  }
}
