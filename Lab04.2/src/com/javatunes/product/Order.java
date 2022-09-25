/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.Collection;

public class Order {
  private String id;
  
  public Order(String id) {
    this.id = id;
  }
  
  /**
   * TODO:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public void processCart(ShoppingCart<? extends Product> cart) {  //if ShoppingCart<Product>, it only pass Product, not subclass of Product, because compile doesn't know you want super class of Product or subclass of Product, not knpw which direction of IS-A is

    for(Product items: cart.allItems()){
      System.out.println(items.getCode());

    }
    System.out.println(cart.total());
    System.out.println(getId());
  }
  
  public String getId() {
    return id;
  }
}