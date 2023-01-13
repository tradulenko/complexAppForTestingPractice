package libs.properties_files;

import org.aeonbits.owner.ConfigFactory;

public class PropertiesFilesProvider {

    public static final ConfigPropertiesHidden configPropertiesHidden = ConfigFactory.create(ConfigPropertiesHidden.class);
    public static final ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    private PropertiesFilesProvider() {
    }
}
