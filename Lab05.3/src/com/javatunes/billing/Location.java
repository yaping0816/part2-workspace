/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

public enum Location {
  USA{  //{}m make usa a subclass of this enum
    //private class UsaSubclass extends Location
    @Override
    public TaxCalculator calculator() {
      return new USATax();
    }

  },
  EUROPE{
    @Override
    public TaxCalculator calculator() {
      return new EuropeTax();
    }
  },
  ONLINE{
    @Override
    public TaxCalculator calculator() {
      return new OnlineTax();
    }
  };

  public abstract TaxCalculator calculator();


}