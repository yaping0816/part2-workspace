/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

// DONE: extend the Thread class
public class MessagePrinter implements Runnable {

  private final String message;
  private final String name;
  private int interval = 500;  // default value
  
  public MessagePrinter(String message) {
    this.message = message;
    // DONE: set the thread name [important when debugging]
    name = getClass().getSimpleName();
  }
  
  public MessagePrinter(String message, int interval) {
    this(message);
    this.interval = interval;
  }
  
  /**
   * DONE: implement run() as follows:
   * It should loop 10 times, printing the 'message' field to stdout,
   * then pausing for some interval (in millis) that you choose.
   * 
   * Use a try/catch to call Thread.sleep(interval) for the pause.
   * The sleep() method throws InterruptedException, which you need to catch.
   * You can either leave the catch block empty, or print the exception to stdout.
   */
  @Override
  public void run() {
    Thread currentThread = Thread.currentThread();
    currentThread.setName(name);
    for (int i = 0; i < 10; i++) {
      System.out.println(currentThread.getName() + ": " + message);
      try {
        Thread.sleep(interval);
      }
      catch (InterruptedException ignored) {
      }
    }
  }
}