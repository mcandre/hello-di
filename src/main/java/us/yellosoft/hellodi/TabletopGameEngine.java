package us.yellosoft.hellodi;

import javax.inject.Inject;

/**
 * An example class using Dependency Injection for a random number generator-agnostic game engine
 */
public class TabletopGameEngine {
  @Inject
  private RNG rng;

  /**
   * Create a random character sheet
   * @return character statistics
   */
  public int createCharacter() {
    return rng.next();
  }
}
