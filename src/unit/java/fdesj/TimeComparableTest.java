package fdesj;


/**
 * Test comparable implementation of Time class.
 */
public class TimeComparableTest extends AbstractComparableTest<Time> {
  public Time createLowValue() {
    return new Time(0);
  }


  public Time createMidValue() {
    return new Time(21);
  }


  public Time createHighValue() {
    return new Time(42);
  }
}
