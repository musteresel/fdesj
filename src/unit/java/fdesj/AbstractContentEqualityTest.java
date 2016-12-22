package fdesj;


import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Abstract class implementing tests to ensure that equality of an
 * class is defined in terms of its contents and not by the object
 * identity.
 *
 * Implementing (test) classes should be able to provide three "kinds"
 * of instances (A, B, C) through the abstract methods of this
 * class. Each call to such a method should return a new (freshly
 * created) instance.
 */
public abstract class AbstractContentEqualityTest {
  /**
   * Create an instance of "kind" A.
   *
   * Each call should return a new instance.
   *
   * @return Instance of "kind" A.
   */
  public abstract Object createNewInstanceA();


  /**
   * Create an instance of "kind" B.
   *
   * Each call should return a new instance.
   *
   * @return Instance of "kind" B.
   */
  public abstract Object createNewInstanceB();


  /**
   * Create an instance of "kind" C.
   *
   * Each call should return a new instance.
   *
   * @return Instance of "kind" C.
   */
  public abstract Object createNewInstanceC();


  /**
   * Instances of the same "kind" should be equal.
   */
  @Test
  public void SameShouldBeEqual()
  {
    assertEquals("Two A instances should be equal",
                 createNewInstanceA(), createNewInstanceA());
    assertEquals("Two B instances should be equal",
                 createNewInstanceB(), createNewInstanceB());
    assertEquals("Two C instances should be equal",
                 createNewInstanceC(), createNewInstanceC());
  }
}
