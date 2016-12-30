package fdesj;


/**
 * Test OccurrenceByTimeComparator.
 */
public class OccurrenceByTimeComparatorTest
  extends AbstractComparatorTest<Occurrence<Object>> {


  public OccurrenceByTimeComparatorTest() {
    super(false /* does not permit null */);
  }


  @Override
  public OccurrenceByTimeComparator<Object> createComparator() {
    return new OccurrenceByTimeComparator<Object>();
  }


  @Override
  public Occurrence<Object> createLowValue() {
    return new Occurrence<Object>(new Time(0),
                                  new DummyEvent());
  }


  @Override
  public Occurrence<Object> createMidValue() {
    return new Occurrence<Object>(new Time(1231),
                                  new DummyEvent());
  }


  @Override
  public Occurrence<Object> createHighValue() {
    return new Occurrence<Object>(new Time(4321123),
                                  new DummyEvent());
  }
}
