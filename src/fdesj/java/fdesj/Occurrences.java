package fdesj;


import java.util.Collection;


/**
 * (Future/pending) occurrences of events in the simulation.
 *
 * An immutable collection of event occurrences, which provides access
 * to the next occurrence (as in earliest in time) as well as means to
 * get an altered collection of occurrences with some occurrences
 * added or removed.
 *
 * This interface also enforces implementing classes to be
 * iterable. The intention is to provide a most general means for
 * {@link Occurrences.Changes} implementations to remove occurrences.
 */
public interface Occurrences extends Iterable<Occurrence> {
  /**
   * Deferred changes which can be applied to a collection of
   * occurrences.
   *
   * This is used by events as a description of the changes they have
   * on the global collection of event occurrences.
   */
  interface Changes {
    /**
     * Apply the changes to the given occurrences, resulting in a new
     * {@linkplain Occurrences collection of occurrences}.
     *
     * Calling this function multiple times with the same argument
     * should produce equal results.
     *
     * @param occurrences The occurrences to which the changes will be
     * applied.
     * @return {@link Occurrences} with the changes applied.
     */
    Occurrences applyTo(Occurrences occurrences);
  }


  /**
   * Get the next occurrence (the earliest one).
   *
   * An implementation must ensure that calling this method does not
   * change its (externally visible) state. Removing the next
   * occurrence is done with {@link #withoutNextOccurrence()}.
   *
   * @return Next (earliest) occurrence of an event, or null if there
   * is none.
   */
  Occurrence nextOccurrence();


  /**
   * Get a collection of all event occurrences at the specified time.
   *
   * @param time Time for which to return occurrences.
   * @return Collection of event occurrences happening at the
   * specified time.
   */
  Collection<Occurrence> at(Time time);


  /**
   * Get the occurrences of this object as well as the given
   * occurrences.
   *
   * @param occurrences Occurrences to add.
   * @return New Occurrences with both the occurrences from this
   * object as well as the given ones.
   */
  Occurrences withNew(Iterable<Occurrence> occurrences);


  /**
   * Get an {@link Occurrences} object with the occurrences from this
   * object, except those specified as parameter.
   *
   * @param occurrences Occurrences to remove.
   * @return New Occurrences without the occurrences given as
   * parameter.
   */
  Occurrences without(Iterable<Occurrence> occurrences);


  /**
   * Get an {@link Occurrences} object without the (currently) next
   * occurrence.
   *
   * This will probably be faster than calling {@link
   * #without(Iterable)}.
   *
   * @return Occurrences without (current) next occurrence.
   */
  Occurrences withoutNextOccurrence();
}
