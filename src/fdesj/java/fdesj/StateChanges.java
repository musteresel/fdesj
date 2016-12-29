package fdesj;


/**
 * Deferred changes which can be applied to the simulation state.
 *
 * This is used by events as a description of the changes they have on
 * the simulation state.
 *
 * @param <State> Type used to represent the simulation state.
 */
public interface StateChanges<State> {
  /**
   * Apply the changes to the given state, resulting in a new state.
   *
   * Calling this function multiple times with the same argument
   * should produce equal results.
   *
   * @param state State to which the changes will be applied.
   * @return State with the changes applied.
   */
  State applyTo(State state);
}
