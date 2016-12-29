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
 * {@link OccurrencesChanges} implementations to remove occurrences.
 */
public interface Occurrences<State>
  extends Iterable<Occurrence<State>> {
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
  Occurrence<State> nextOccurrence();


  /**
   * Get a collection of all event occurrences at the specified time.
   *
   * @param time Time for which to return occurrences.
   * @return Collection of event occurrences happening at the
   * specified time.
   */
  Collection<Occurrence<State>> at(Time time);


  /**
   * Get the occurrences of this object as well as the given
   * occurrences.
   *
   * @param occurrences Occurrences to add.
   * @return New Occurrences with both the occurrences from this
   * object as well as the given ones.
   */
  Occurrences<State> withNew(Iterable<Occurrence<State>> occurrences);


  /**
   * Get an {@link Occurrences} object with the occurrences from this
   * object, except those specified as parameter.
   *
   * @param occurrences Occurrences to remove.
   * @return New Occurrences without the occurrences given as
   * parameter.
   */
  Occurrences<State> without(Iterable<Occurrence<State>> occurrences);


  /**
   * Get an {@link Occurrences} object without the (currently) next
   * occurrence.
   *
   * This will probably be faster than calling {@link
   * #without(Iterable)}.
   *
   * @return Occurrences without (current) next occurrence.
   */
  Occurrences<State> withoutNextOccurrence();
}
