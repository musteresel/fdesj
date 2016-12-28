package fdesj;


/**
 * Test comparable implementation of Time class.
 */
public class TimeComparableTest extends AbstractComparableTest<Time> {
  @Override
  public Time createLowValue() {
    return new Time(0);
  }


  @Override
  public Time createMidValue() {
    return new Time(21);
  }


  @Override
  public Time createHighValue() {
    return new Time(42);
  }
}
