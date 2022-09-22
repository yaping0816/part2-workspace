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
    int oldVolume = tv.getVolume();
    try{
      tv.setVolume(-20);
      fail("Should have thrown exceptions");
    }catch(IllegalArgumentException e){
      assertEquals(oldVolume, tv.getVolume());
    }
  }

  @Test
  public void changeChannel() throws InvalidChannelException {
    int channel = (Television.MAX_CHANNEL+Television.MAX_CHANNEL)/2;
    tv.changeChannel(channel);
    assertEquals(channel, tv.getCurrentChannel());
  }

  @Test
  public void testChangeChannelInvalidChannelException() throws InvalidChannelException{
    int oldChannel = tv.getCurrentChannel();
    try{
      tv.changeChannel(1000);
    }catch(InvalidChannelException e){
      assertEquals(oldChannel, tv.getCurrentChannel());
    }

  }

  @Test
  public void compareTo() {
    Television other1 = new Television();
    other1.setBrand("LG");

    Television other2 = new Television();
    other2.setBrand("Samsung");

    assertEquals(0, tv.compareTo(other1));
    assertTrue(tv.compareTo(other2)<0);

  }

  @Test
  public void testHashCode() {
    Television tv1 = new Television("LG", 25,DisplayType.LED);
    Television tv2 = new Television("Samsung", 50, DisplayType.PLASMA);

    assertEquals(tv.hashCode(), tv1.hashCode());
    assertNotEquals(tv.hashCode(), tv2.hashCode());

  }

  @Test
  public void testEquals() {
    Television tv1 = new Television("LG", 25,DisplayType.LED);
    Television tv2 = new Television("Samsung", 50, DisplayType.PLASMA);

    assertEquals(tv, tv1);
    assertNotEquals(tv,tv2);
  }
}