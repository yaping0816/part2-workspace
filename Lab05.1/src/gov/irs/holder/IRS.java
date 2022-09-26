/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package gov.irs.holder;

import java.util.ArrayList;
import java.util.Collection;
import gov.irs.TaxPayer;

public class IRS {
  // SINGLETON CODE
  // so we can see when IRS class is loaded
  static {
    System.out.println("--IRS class loaded");
  }
  
  // BUSINESS CODE
  private Collection<TaxPayer> payers = new ArrayList<>();
  
  // so we can see when the instance is created
  private IRS() {
    System.out.println("--IRS ctor: the instance has been created");
  }
  
  // only access to the instance - truly lazy, and thread-safe
  public static IRS getInstance() { //loading class is a blocking operation, which means only one thread is allowed to do that, the other threads have to wait until the first thread finished
    return IRSHolder.instance;
  }
  
  /*
   * superfluous static method that shouldn't be here
   * if you call it, class is loaded but nested class IRS.IRSHolder is NOT
   * even with superfluous static methods, this solution is lazy (still, best to not have them)
   */
  public static void touch() {
    // no-op
  }
  
  public void collectTaxes() {
    for (TaxPayer payer : payers) {
      payer.payTaxes();
    }
  }
  
  public void register(TaxPayer payer) {
    payers.add(payer);
  }
  
  private static class IRSHolder {
    private static final IRS instance = new IRS(); //when gertInstance is called, this class loaded and initialized, this static with initialization field created, and which means the IRS is always in the memory
    
    // so we can see when IRS.IRSHolder class is loaded
    static {
      System.out.println("--IRS.IRSHolder class loaded");
    }
  }
}