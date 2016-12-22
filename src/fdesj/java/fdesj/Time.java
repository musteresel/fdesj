package fdesj;


/**
 * Abstraction over time.
 *
 * Note that for the purpose of this software, time is discrete, there
 * is a smallest step with which time advances.
 */
public final class Time implements Comparable<Time> {
  /**
   * Absolute time value, measured from begin of simulation.
   */
  public final long absoluteValue;


  /**
   * Construct a time object with the given absolute time value.
   *
   * This constructor is package-private as code outside of the
   * simulation library is not supposed to use it.
   *
   * @param absoluteValue Absolute time value.
   */
  /* package-private */ Time(final long absoluteValue) {
    this.absoluteValue = absoluteValue;
  }


  /**
   * Get the absolute time as a long value.
   *
   * @return Absolute time as long value.
   */
  public long getAbsoluteTime() {
    return absoluteValue;
  }


  /**
   * Compare two times, using "earlier" as the order relation.
   *
   * @param other The Time to compare against.
   * @return A value less than 0 if this time is "earlier" than the
   * other time, 0 if neither is "earlier" than the other and a value
   * greater than 0 otherwise.
   */
  @Override
  public int compareTo(Time other) {
    return Long.compare(absoluteValue, other.absoluteValue);
  }


  /**
   * Duration / time span.
   *
   * Used to enforce type safety.
   */
  public static class Duration {
    /**
     * The difference of the absolute time of the start and end time
     * of the duration.
     *
     * For now, this may be negative, too.
     */
    public final long differenceValue;


    /**
     * Construct with the given long value.
     *
     * @param differenceValue Time difference given as long value.
     */
    public Duration(final long differenceValue) {
      this.differenceValue = differenceValue;
    }


    /**
     * Get the time difference as a long value.
     *
     * @return Time difference as long value.
     */
    public final long getTimeDifference() {
      return differenceValue;
    }
  }


  /**
   * Get the time after the given duration passed.
   *
   * @param duration Duration of time which passes between this time
   * and the returned time.
   * @return Time after the given duration.
   */
  public Time after(final Duration duration) {
    return new Time(absoluteValue + duration.getTimeDifference());
  }
}
