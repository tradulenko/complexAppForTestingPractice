package pages;

import libs.ConfigProperties;
import libs.ConfigPropertiesHidden;
import org.aeonbits.owner.ConfigFactory;

public class PropertiesProvider {

    public final static ConfigPropertiesHidden configPropertiesHidden = ConfigFactory.create(ConfigPropertiesHidden.class);

    public final static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
}
