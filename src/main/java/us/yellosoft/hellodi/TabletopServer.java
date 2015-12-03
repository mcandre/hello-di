package us.yellosoft.hellodi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
   An example bootstrap of a Dependency Injected game engine
 */
public final class TabletopServer {
  /** Utility class */
  private TabletopServer() {}

  /**
     CLI entry point
     @param args CLI flags
   */
  public static void main(final String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(TabletopConfiguration.class);
    context.register(DeepThoughtRNG.class);
    context.refresh();

    TabletopGameEngine tabletopGameEngine = context.getBean(TabletopGameEngine.class);
    int goblin = tabletopGameEngine.createCharacter();
    System.out.println("Goblin: " + goblin);

    context.close();
  }
}
