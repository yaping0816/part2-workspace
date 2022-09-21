package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {

  private Television tv;


  @Before
  public void setUp(){
    tv = new Television("LG", 25,DisplayType.LED);
  }

  @Test
  public void setVolume() {
    assertEquals(25, tv.getVolume());
  }

  @Test
  public void setVolumeIllegalArgumentsException() {
    try{
      tv.setVolume(-20);
      fail("Should have thrown exceptions");
    }catch(IllegalArgumentException e){
      assertEquals("Invalid volume: -20. Allowed range: [0,100].", e.getMessage());
    }

  }

  @Test
  public void changeChannel() throws InvalidChannelException {
    tv.changeChannel(300);
  }

  @Test
  public void compareTo() {
  }

  @Test
  public void testHashCode() {
  }

  @Test
  public void testEquals() {
  }
}