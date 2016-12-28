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
   * Equality is defined by the absolute value of time.
   *
   * @param object Object to check for equality to this.
   * @return True if the object is a Time with same absolute value.
   */
  @Override
  public boolean equals(final Object object) {
    if (object == this) {
      return true;
    }
    if (! (object instanceof Time)) {
      return false;
    }
    assert object != null; // Checked by the instanceof above
    final Time other = (Time) object;
    return absoluteValue == other.absoluteValue;
  }


  /**
   * Compute a hash code from the absolute value of time.
   *
   * @return Hash code based on absolute value of time.
   */
  @Override
  public int hashCode() {
    // Note: This is for backwards compability, in Java 8 this could
    // be written as Long.hashCode(absoluteValue) and would then not
    // require an object allocation as the current solution does. The
    // current solution *might* be optimized properly when compiled
    // with the -XX:+DoEscapeAnalysis flag, though. As long as this is
    // not a profiled bottleneck we won't care much about all of that
    // here, though.
    return Long.valueOf(absoluteValue).hashCode();
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
