package fdesj;


import java.util.Objects;


/**
 * An occurrence of an event at some time.
 *
 * Events themselves are timeless, so this class provides a means to
 * specify the time when an event actually happens (or is scheduled to
 * do so).
 */
public final class Occurrence<State> {
  /**
   * The time of occurrence.
   */
  public final Time time;


  /**
   * The event which is occurring.
   */
  public final Event<State> event;


  /**
   * Construct an occurrence of the given event at the given time.
   *
   * @param time Time the event occurs.
   * @param event Event which occurs.
   * @throws NullPointerException When time or event is null.
   */
  public Occurrence(final Time time, final Event<State> event) {
    this.time = Objects.requireNonNull(time, "time must not be null");
    this.event = Objects.requireNonNull(event,
                                        "event must not be null");
  }


  /**
   * Equality is defined by the equality of both the event and the
   * time.
   *
   * @param object Object to check for equality to this.
   * @return True if the object is an Occurrence with an equal time
   * and event.
   */
  @Override
  public boolean equals(final Object object) {
    if (object == this) {
      return true;
    }
    if (! (object instanceof Occurrence)) {
      return false;
    }
    assert object != null; // Checked by the instanceof above
    final Occurrence other = (Occurrence) object;
    return time.equals(other.time)
      && event.equals(other.event);
  }


  /**
   * Compute a hash code from the hash code of the time and event.
   *
   * @return hash code for this Occurrence.
   */
  @Override
  public int hashCode() {
    return Objects.hash(time, event);
  }
}
