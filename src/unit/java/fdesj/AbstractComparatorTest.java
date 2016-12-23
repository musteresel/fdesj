package fdesj;


import java.util.Comparator;
import java.util.Objects;
import org.junit.Test;


/**
 * Abstract class implementing tests to verify that a comparator for
 * the given Value class correctly implements a total order.
 */
public abstract class AbstractComparatorTest<Value> {
  /**
   * Create some value that can be considered "low".
   *
   * @return "low" value.
   */
  public abstract Value createLowValue();


  /**
   * Create some value that can be considered between "low" and "high"
   * ("mid").
   *
   * @return "mid" value.
   */
  public abstract Value createMidValue();


  /**
   * Create some value that can be considered "high".
   *
   * @return "high" value.
   */
  public abstract Value createHighValue();


  /**
   * Create a new instance of the comparator (class) under test.
   *
   * This comparator should be able to compare "low", "mid" and "high"
   * values, obviously.
   *
   * @return Comparator instance to test.
   */
  public abstract Comparator<Value> createComparator();


  /**
   * Flag whether the comparator under test permits null.
   */
  private final boolean permitsNull;


  /**
   * Construct.
   *
   * @param permitsNull Whether the comparator under test permits
   * null.
   */
  public AbstractComparatorTest(final boolean permitsNull) {
    this.permitsNull = permitsNull;
  }


  /**
   * Test whether an exception is thrown when null is not permitted.
   *
   * Tests nothing if null is permitted.
   */
  @Test(expected = NullPointerException.class)
  public void NullShouldThrowIfNotPermitted() {
    final Comparator<Value> comparator = createComparator();
    if (! permitsNull) {
      comparator.compare(null, null);
    }
  }


  /**
   * Test whether no exception is thrown when null is permitted.
   *
   * Tests nothing if null is not permitted.
   */
  @Test
  public void NullShouldNotThrowIfPermitted() {
    final Comparator<Value> comparator = createComparator();
    if (permitsNull) {
      comparator.compare(null, null);
    }
  }
}
