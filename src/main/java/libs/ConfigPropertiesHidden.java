package libs;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:./src/main/java/resources/HiddenConfig.properties")
public interface ConfigPropertiesHidden extends Config {
        String base_url();
        String DEFAULT_LOGIN();
        String DEFAULT_PASSWORD();

}
