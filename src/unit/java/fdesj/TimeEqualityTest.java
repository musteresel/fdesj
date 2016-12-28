package fdesj;


/**
 * Test equality implementation of the {@link Time} class.
 */
public class TimeEqualityTest extends AbstractContentEqualityTest {
  @Override
  public Time createNewInstanceA() {
    return new Time(0);
  }


  @Override
  public Time createNewInstanceB() {
    return new Time(13);
  }


  @Override
  public Time createNewInstanceC() {
    return new Time(4096);
  }
}
