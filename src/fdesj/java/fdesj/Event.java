package fdesj;


/**
 * An event in the simulation.
 */
public interface Event<State> {
  /**
   * Describe how the event affects the simulation.
   *
   * Calling this function multiple times with equal arguments must
   * return equal results.
   *
   * @param state Simulation state.
   * @param at Time at which the event has its effect.
   * @return Description of the changes to the simulation induced by
   * the event.
   */
  Changes<State> affect(State state, Time at);
}
