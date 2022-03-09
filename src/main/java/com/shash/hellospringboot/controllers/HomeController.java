package com.shash.hellospringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Defines various operations on the / endpoint.
 */
@RestController
public class HomeController {

  @GetMapping("/")
  public String index() {
    return "Hello, world!";
  }
}
