package us.yellosoft.hellodi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* An example configuration selecting specific implementations for injection
*/
@Configuration
public class TabletopConfiguration {
    /**
    * @return a game engine
    */
    @Bean
    public TabletopGameEngine tabletopGameEngine() {
        return new TabletopGameEngine();
    }
}
