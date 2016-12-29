package fdesj;


/**
 * Deferred changes which can be applied to a collection of
 * occurrences.
 *
 * This is used by events as a description of the changes they have
 * on the global collection of event occurrences.
 */
public interface OccurrencesChanges<State> {
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
  Occurrences<State> applyTo(Occurrences<State> occurrences);
}
