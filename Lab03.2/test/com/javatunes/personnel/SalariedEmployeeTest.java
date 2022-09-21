package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class SalariedEmployeeTest {

  private SalariedEmployee emp;

  @Before
  public void setUp(){
    emp = new SalariedEmployee("Steven Jobs", new Date(122, 2, 15), 1000.0);
  }

  @Test
  public void testPay() {
    assertEquals(1000, emp.pay(),0.001);
  }

  @Test
  public void testPayTaxes() {
    assertEquals(300, emp.payTaxes(),0.001);
  }
}