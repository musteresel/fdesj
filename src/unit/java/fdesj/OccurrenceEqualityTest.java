package fdesj;


/**
 * Test equality implementation of the {@link Occurrence} class.
 *
 * This class uses the tests defined in {@link
 * AbstactContentEqualityTest}.
 */
public class OccurrenceEqualityTest
  extends AbstractContentEqualityTest {
  /**
   * One time object.
   */
  public final Time timeOne = new Time(0);


  /**
   * Another time object, different from the first.
   */
  public final Time timeTwo = new Time(42);


  /**
   * One event object.
   */
  public final Event eventOne = new Event() {};


  /**
   * Another event object.
   */
  public final Event eventTwo = new Event() {};


  /**
   * Provide an instance of kind A, with time one and event one.
   */
  @Override
  public Occurrence createNewInstanceA() {
    return new Occurrence(timeOne, eventOne);
  }


  /**
   * Provide an instance of kind B, with time two and event one.
   */
  @Override
  public Occurrence createNewInstanceB() {
    return new Occurrence(timeTwo, eventOne);
  }


  /**
   * Provide an instance of kind C, with time one and event two.
   */
  @Override
  public Occurrence createNewInstanceC() {
    return new Occurrence(timeOne, eventTwo);
  }
}
