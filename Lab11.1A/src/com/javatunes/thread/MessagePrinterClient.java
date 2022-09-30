/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

  public static void main(String[] args) {
    // TODO: create two instances of your thread subclass and start them up
    MessagePrinter printer1 = new MessagePrinter("Thread 1");
    printer1.start();
    MessagePrinter printer2 = new MessagePrinter("Thread 2");
    printer2.start();
    MessagePrinter printer3 = new MessagePrinter("Thread3", 2000);
    printer3.start();
  }
}