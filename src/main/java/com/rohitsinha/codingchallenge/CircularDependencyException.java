package com.rohitsinha.codingchallenge;

/**
 * Exception class for circular dependency
 *
 * @author Rohit Sinha
 */
public class CircularDependencyException extends Exception {
  public CircularDependencyException() {
  }

  public CircularDependencyException(String message) {
    super(message);
  }
}
