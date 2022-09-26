/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package gov.irs.enumtype;

import java.util.ArrayList;
import java.util.Collection;
import gov.irs.TaxPayer;

enum IRSEnum implements IRS {

  INSTANCE; //public static final IRSEnum INSTANCE = new IRSEnum();
  
  // so we can see when IRSEnum class is loaded, this INSTANCE is created
  static {
    System.out.println("--IRSEnum class loaded");
  }
  
  // BUSINESS CODE
  private Collection<TaxPayer> payers = new ArrayList<>();
  
  // so we can see when INSTANCE is created
  IRSEnum() {
    System.out.println("--IRSEnum ctor: the instance has been created");
  }
  
  // not needed � just makes enum look more like regular singleton
  public static IRSEnum getInstance() {
    return INSTANCE;
  }

  /*
   * superfluous static method that shouldn't be here
   * if you call it, class is loaded and INSTANCE is created (prematurely)
   * so just don't have superfluous static methods and your enum solution is indeed lazy
   */
  public static void touch() {
    // no-op
  }
  
  @Override
  public void collectTaxes() {
    for (TaxPayer payer : payers) {
      payer.payTaxes();
    }
  }
  
  @Override
  public void register(TaxPayer payer) {
    payers.add(payer);
  }
}