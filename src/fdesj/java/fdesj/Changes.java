package fdesj;


/**
 * Sum of the changes which can be induced by an event.
 */
public final class Changes<State> {
  /**
   * Changes that act on the simulation state.
   */
  public final StateChanges<State> toState;


  /**
   * Changes that act on the event list of the simulation.
   */
  public final Occurrences.Changes<State> toOccurrences;


  /**
   * Construct with the given changes to parts of the simulation.
   *
   * @param toState Changes which apply to the simulation state.
   * @param toOccurrences Changes to the event list.
   */
  public Changes(final StateChanges<State> toState,
                 final Occurrences.Changes<State> toOccurrences) {
    // TODO: Decide whether null should be banned.
    this.toState = toState;
    this.toOccurrences = toOccurrences;
  }
}
