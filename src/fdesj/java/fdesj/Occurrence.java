package fdesj;


/**
 * An occurrence of an event at some time.
 *
 * Events themselves are timeless, so this class provides a means to
 * specify the time when an event actually happens (or is scheduled to
 * do so).
 */
public final class Occurrence {
  /**
   * The time of occurrence.
   */
  public final Time time;


  /**
   * The event which is occurring.
   */
  public final Event event;


  /**
   * Construct an occurrence of the given event at the given time.
   *
   * @param time Time the event occurs.
   * @param event Event which occurs.
   */
  public Occurrence(final Time time, final Event event) {
    this.time = time;
    this.event = event;
  }
}
