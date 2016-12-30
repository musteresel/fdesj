package fdesj;


/**
 * Dummy event class used by testing code.
 */
public final class DummyEvent implements Event<Object> {
  @Override
  public Changes<Object> affect(final Object state, final Time at) {
    // TODO: This is ugly, provide a way to say "no changes".
    return new Changes<Object>(null, null);
  }
}
