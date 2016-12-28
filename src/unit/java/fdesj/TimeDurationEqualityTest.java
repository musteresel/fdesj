package fdesj;


/**
 * Test equality implementation of Time.Duration class.
 */
public class TimeDurationEqualityTest
  extends AbstractContentEqualityTest {
  @Override
  public Time.Duration createNewInstanceA() {
    return new Time.Duration(-1);
  }


  @Override
  public Time.Duration createNewInstanceB() {
    return new Time.Duration(0);
  }


  @Override
  public Time.Duration createNewInstanceC() {
    return new Time.Duration(99);
  }
}
