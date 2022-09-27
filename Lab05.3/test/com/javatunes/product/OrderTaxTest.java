/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.javatunes.billing.Location;

public class OrderTaxTest {
  private ShoppingCart<Product> cart1;
  private ShoppingCart<Product> cart2;
  
  @Before
  public void init() {
    cart1 = new ShoppingCart<Product>();  // $20.00
    cart1.addItem(new MusicItem("CD-501"));
    cart1.addItem(new MusicItem("CD-519"));
    
    cart2 = new ShoppingCart<Product>();  // $120.00 
    cart2.addItem(new MusicItem("CD-511"));
    cart2.addItem(new MusicItem("CD-512"));
    cart2.addItem(new MediaPlayer("MP3-LP150"));
    cart2.addItem(new MediaPlayer("MP4-JR1205"));
  }
  
  /**
   * TODO: (for each of the test cases below)
   * 1. Create an order for *each* cart in the setup, e.g., Order order1 = new Order(...)
   * 2. Remember to call order1.processCart(cart1) -> that method computes the order's total cost.
   * 3. DEPENDING ON YOUR IMPLEMENTATION, initialize somehow the Order's TaxCalculator strategy.
   *     - For example, if you wrote a factory for TaxCalculator (option 1), make sure the Order has a Location set,
   *       since the factory (most likely) is using this to determine which strategy to provide.
   *     - If you are injecting the TaxCalculator into the Order (option 2, perhaps from an OrderFactory), use that 
   *       factory to create the Orders.
   *     - If you're injecting the TaxCalculator from the client, do so here.
   * 4. Verify that the order's tax is as expected.
   * 
   * TEST NOTE: you can split the two orders per location into two test cases, if desired.
   */
  @Test
  public void testTaxOnlineOrder() {
    Order order1 = new Order("online-1", Location.ONLINE);
    order1.processCart(cart1);
    assertEquals(0, order1.getTax(), 0.001);

    Order order2 = new Order("online-2", Location.ONLINE);
    order2.processCart(cart2);
    assertEquals(0, order2.getTax(), 0.001);
  }
  
  @Test
  public void testTaxEuropeOrder() {
    Order order1 = new Order("europe-1", Location.EUROPE);
    order1.processCart(cart1);
    assertEquals(3.4, order1.getTax(), 0.001);

    Order order2 = new Order("europe-2", Location.EUROPE);
    order2.processCart(cart2);
    assertEquals(25.4, order2.getTax(), 0.001);
  }
  
  @Test
  public void testTaxUSAOrder() {
    Order order1 = new Order("usa-1", Location.USA);
    order1.processCart(cart1);
    assertEquals(0, order1.getTax(), 0.001);

    Order order2 = new Order("usa-2", Location.USA);
    order2.processCart(cart2);
    assertEquals(10, order2.getTax(), 0.001);
  }
}