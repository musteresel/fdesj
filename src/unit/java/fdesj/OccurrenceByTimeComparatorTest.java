package fdesj;


/**
 * Test OccurrenceByTimeComparator.
 */
public class OccurrenceByTimeComparatorTest
  extends AbstractComparatorTest<Occurrence> {


  public OccurrenceByTimeComparatorTest() {
    super(false /* does not permit null */);
  }


  @Override
  public OccurrenceByTimeComparator createComparator() {
    return new OccurrenceByTimeComparator();
  }


  @Override
  public Occurrence createLowValue() {
    return new Occurrence(new Time(0), new Event() {});
  }


  @Override
  public Occurrence createMidValue() {
    return new Occurrence(new Time(1231), new Event() {});
  }


  @Override
  public Occurrence createHighValue() {
    return new Occurrence(new Time(4321123), new Event() {});
  }
}
