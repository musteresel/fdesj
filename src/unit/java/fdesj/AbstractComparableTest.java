package fdesj;


import java.util.Comparator;


/**
 * Test any comparable value whether it correctly implements a total
 * order.
 *
 * Internally a comparator is used, forwarding comparisons to the
 * comparable.
 */
public abstract class
  AbstractComparableTest<Value extends Comparable<? super Value>>
  extends AbstractComparatorTest<Value> {
  /**
   * Comparator forwarding comparisons to the values being compared.
   */
  private static class
    ComparableComparator<T extends Comparable<? super T>>
    implements Comparator<T> {
    /**
     * Compare two values, by using their compareTo method.
     *
     * @param lhs Left hand side, compareTo is called on this.
     * @param rhs Right hand side, passed as argument to compareTo.
     * @return Comparison result.
     */
    public int compare(final T lhs, final T rhs) {
      return lhs.compareTo(rhs);
    }
  }


  /**
   * Create a new comparator to compare values.
   *
   * @return New comparator to compare values.
   */
  public Comparator<Value> createComparator() {
    return new ComparableComparator<Value>();
  }


  /**
   * Construct.
   */
  public AbstractComparableTest() {
    super(false);
  }
}
