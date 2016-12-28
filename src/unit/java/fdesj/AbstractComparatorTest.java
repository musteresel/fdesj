package fdesj;


import java.util.Comparator;
import java.util.Objects;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


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


  /**
   * Test whether comparing a value with itself returns zero.
   */
  @Test
  public void SelfComparisonShouldReturnZero() {
    final Comparator<Value> comparator = createComparator();
    final Value low = createLowValue();
    final Value mid = createMidValue();
    final Value high = createHighValue();
    assertTrue("Self comparison of low value should return 0.",
               comparator.compare(low, low) == 0);
    assertTrue("Self comparison of mid value should return 0.",
               comparator.compare(mid, mid) == 0);
    assertTrue("Self comparison of high value should return 0.",
               comparator.compare(high, high) == 0);
  }


  /**
   * A comparison (of integer values), used to make testing code more
   * abstract.
   */
  private abstract class Comparison {
    /**
     * Description of the comparison done.
     */
    private final String description;


    /**
     * Construct.
     *
     * @param description Description of the comparison.
     */
    Comparison(final String description) {
      this.description = description;
    }


    /**
     * Describe this comparison.
     *
     * @return Description of the comparison.
     */
    public final String describe() {
      return description;
    }


    /**
     * Actual comparison.
     *
     * @param lhs Left hand side.
     * @param rhs Right hand side.
     * @return Result of comparing lhs and rhs.
     */
    public abstract boolean of(int lhs, int rhs);
  }


  /**
   * Less than comparison.
   */
  private final Comparison LESS = new Comparison("less than") {
      public boolean of(final int lhs, final int rhs) {
        return lhs < rhs;
      }
    };


  /**
   * Equal to comparison.
   */
  private final Comparison EQUAL = new Comparison("equal to") {
      public boolean of(final int lhs, final int rhs) {
        return lhs == rhs;
      }
    };


  /**
   * Greater than comparison.
   */
  private final Comparison GREATER = new Comparison("greater than") {
      public boolean of(final int lhs, final int rhs) {
        return lhs > rhs;
      }
    };


  /**
   * Helper function to do actual comparisons and assert that they're
   * true.
   *
   * Compares the result of the comparison done by the comparator
   * under test using the passed in Comparison against 0.
   *
   * @param lhsDescription Description of the lhs value.
   * @param lhs Left hand side value.
   * @param rhsDescription Description of the rhs value.
   * @param rhs Right hand side value.
   * @param comparison Comparison used.
   */
  private void assertComparison(final String lhsDescription,
                                final Value lhs,
                                final String rhsDescription,
                                final Value rhs,
                                final Comparison comparison) {
    final Comparator<Value> comparator = createComparator();
    final int result = comparator.compare(lhs, rhs);
    assertTrue(lhsDescription + " must be "
               + comparison.describe() + " "
               + rhsDescription + ".",
               comparison.of(result, 0));
  }

  /**
   * A low value should be reported as less than a mid value.
   */
  @Test
  public void LowShouldBeLessThanMid() {
    assertComparison("low", createLowValue(),
                     "mid", createMidValue(),
                     LESS);
  }


  /**
   * A low value should be reported as less than a high value.
   */
  @Test
  public void LowShouldBeLessThanHigh() {
    assertComparison("low", createLowValue(),
                     "high", createHighValue(),
                     LESS);
  }


  /**
   * A mid value should be reported as less than a high value.
   */
  @Test
  public void MidShouldBeLessThanHigh() {
    assertComparison("mid", createMidValue(),
                     "high", createHighValue(),
                     LESS);
  }


  /**
   * A high value should be reported as greater than a low value.
   */
  @Test
  public void HighShouldBeGreaterThanLow() {
    assertComparison("high", createHighValue(),
                     "low", createLowValue(),
                     GREATER);
  }


  /**
   * A high value should be reported as greater than a mid value.
   */
  @Test
  public void HighShouldBeGreaterThanMid() {
    assertComparison("high", createHighValue(),
                     "mid", createMidValue(),
                     GREATER);
  }


  /**
   * A mid value should be reported as greater than a low value.
   */
  @Test
  public void MidShouldBeGreaterThanLow() {
    assertComparison("mid", createMidValue(),
                     "low", createLowValue(),
                     GREATER);
  }
}
