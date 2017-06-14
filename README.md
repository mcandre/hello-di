# hello-di - an example of Dependency Injection

# EXAMPLE

```
$ gradle shadowJar
$ bin/tabletop-server
Nov 03, 2015 11:36:04 AM org.springframework.context.annotation.AnnotationConfigApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@4fca772d: startup date [Tue Nov 03 11:36:04 CST 2015]; root of context hierarchy
Nov 03, 2015 11:36:05 AM org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor <init>
INFO: JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
Goblin: 42
```

# ABOUT

Dependency Injection is a convention of avoiding hardcoding specific implementations/dependencies, and instead exposing these as configurable attributes.

Bad (hardcoded class dependence):

```
public class TabletopGameEngine {
  private RNG rng = new SlowRNGAlgorithm();

  ...
}
```

This is bad, because TabletopGameEngine's code must be changed whenever a different random number generator algorithm is desired. This also makes testing more difficult.

Better (constructor parameter):

```
public class TabletopGameEngine {
  private RNG rng;

  public TabletopGameEngine(RNG rng) {
    this.rng = rng;
  }

  ...
}
```

Now, anything that uses TabletopGameEngine should pass an implementation into the constructor.

Even Better (bean convention):

```
public class TabletopGameEngine {
  private RNG rng;

  public void setRNG(RNG rng) {
    this.rng = rng;
  }

  ...
}
```

A game engine can be instantiated, and later configured with a particular algorithm.

Better Still (dependency injection)

```
import javax.inject.Inject;

public class TabletopGameEngine {
  @Inject
  private RNG rng;

  ...
}
```

This allows a dependency injection container, such as Spring, to entirely manage the wiring of RNG implementations to the `rng` attribute, without requiring direct users of TabletopGameEngine to worry about passing around references to RNG implementations.

# REQUIREMENTS

* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 1.7+
* [gradle](http://gradle.org/) 2.1+

## Optional

* [Sonar](http://www.sonarqube.org/)
* [Infer](http://fbinfer.com/)
* [editorconfig-cli](https://github.com/amyboyd/editorconfig-cli) (e.g. `go get github.com/amyboyd/editorconfig-cli`)
* [flcl](https://github.com/mcandre/flcl) (e.g. `go get github.com/mcandre/flcl/...`)
