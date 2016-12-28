package fdesj;


import java.util.Comparator;


/**
 * Compare occurrences by time.
 *
 * Note that the events are completely ignored. This also means that
 * this comparator does not comply with Occurrence.equals().
 */
public final class OccurrenceByTimeComparator
  implements Comparator<Occurrence> {
  /**
   * Compare the two occurrences based on their time.
   *
   * @param lhs Left hand side.
   * @param rhs Right hand side.
   * @return Result of comparing times of the occurrences.
   */
  @Override
  public int compare(final Occurrence lhs, final Occurrence rhs) {
    return lhs.time.compareTo(rhs.time);
  }
}
