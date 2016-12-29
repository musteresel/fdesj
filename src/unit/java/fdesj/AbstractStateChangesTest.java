package fdesj;


import org.junit.Test;
import static org.junit.Assert.assertTrue;


/**
 * Test whether some StateChanges adhere to the general idea of them
 * being an immutable description of changes.
 */
public abstract class AbstractStateChangesTest<State> {
  /**
   * Create some state, used to test the state changes.
   *
   * The created state may vary when calling this function multiple
   * times.
   *
   * @return Some state.
   */
  public abstract State createSomeState();


  /**
   * Create the StateChanges under test.
   */
  public abstract StateChanges<State> createStateChanges();


  /**
   * Determine whether two states are equal.
   *
   * Override if the states are not using Object.equals(Object) to
   * determine equality.
   */
  public boolean statesAreEqual(final State one, final State two) {
    return one.equals(two);
  }


  /**
   * Check whether applying changes twice influences the result.
   */
  @Test
  public void ApplyingTwiceShouldNotChangeResult() {
    final State initialState = createSomeState();
    final StateChanges<State> changesUnderTest = createStateChanges();
    assertTrue("Results should be equal when applying changes twice.",
               statesAreEqual(changesUnderTest.applyTo(initialState),
                              changesUnderTest.applyTo(initialState)));
  }
}
