package libs.global_parameters;

import static libs.properties_files.PropertiesFilesProvider.configPropertiesHidden;

import libs.custom_exceptions.NotSpecifiedGlobalParameterException;
import libs.properties_files.PropertiesFilesProvider;

public class GlobalParametersProvider {

    private static final String BASE_URL_LAST_PART = System.getProperty("url", configPropertiesHidden.BASE_URL()) ;

    private static final String FULL_BASE_URL = "https://" + System.getProperty("env", "qa") + "-" + BASE_URL_LAST_PART;

    private static final String DEFAULT_VALID_LOGIN = System.getProperty("login", PropertiesFilesProvider.configPropertiesHidden.DEFAULT_LOGIN());
    private static final String DEFAULT_VALID_PASSWORD = System.getProperty("password", PropertiesFilesProvider.configPropertiesHidden.DEFAULT_PASSWORD());

    private GlobalParametersProvider() {
    }

    public static String getFullBaseUrl() {
        if ((BASE_URL_LAST_PART == null) || BASE_URL_LAST_PART.isEmpty())
            throw new NotSpecifiedGlobalParameterException("Add params 'url' to the command line or load HiddenConfig with valid value");
        return FULL_BASE_URL;
    }

    public static String getDefaultValidLogin() throws NotSpecifiedGlobalParameterException {
        if ((DEFAULT_VALID_LOGIN == null) || DEFAULT_VALID_LOGIN.isEmpty()) {
            throw new NotSpecifiedGlobalParameterException("Add params 'login' to the command line or load HiddenConfig with valid value");
        }
        return DEFAULT_VALID_LOGIN;
    }

    public static String getDefaultValidPassword() throws NotSpecifiedGlobalParameterException{
        if ((DEFAULT_VALID_PASSWORD == null) || DEFAULT_VALID_PASSWORD.isEmpty())
            throw new NotSpecifiedGlobalParameterException("Add params 'password' to the command line or load HiddenConfig with valid value");
        return DEFAULT_VALID_PASSWORD;
    }
}
