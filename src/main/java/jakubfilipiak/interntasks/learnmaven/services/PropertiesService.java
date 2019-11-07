package jakubfilipiak.interntasks.learnmaven.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService {

    private Environment environment;
    private static final String DEV_PROFILE = "dev";
    private static final String TEST_PROFILE = "test";
    private static final String PROD_PROFILE = "prod";
    private static final String DEV_PROFILE_NAME = "development";
    private static final String TEST_PROFILE_NAME = "test";
    private static final String PROD_PROFILE_NAME = "production";

    @Value("${pom.spring.version:undefined}")
    private String springVersion;

    @Value("${project.version:undefined}")
    private String version;

    @Value("${filter.filtered.property:undefined}")
    private String myFilteredPropertyValue;

    public PropertiesService(Environment environment) {
        this.environment = environment;
    }

    public String retrieveActiveProfileName() {
        String[] activeProfiles = environment.getActiveProfiles();
        if (isNoActiveProfile(activeProfiles)) return "none";
        if (isMoreThanOneActiveProfile(activeProfiles)) return "more than one";
        String activeProfile = activeProfiles[0];
        return retrieveProfileNameFromProfile(activeProfile);
    }

    private boolean isNoActiveProfile(String[] activeProfiles) {
        return activeProfiles == null || activeProfiles.length == 0;
    }

    private boolean isMoreThanOneActiveProfile(String[] activeProfiles) {
        return activeProfiles.length > 1;
    }

    private String retrieveProfileNameFromProfile(String profileName) {
        switch (profileName) {
            case DEV_PROFILE:
                return DEV_PROFILE_NAME;
            case TEST_PROFILE:
                return TEST_PROFILE_NAME;
            case PROD_PROFILE:
                return PROD_PROFILE_NAME;
            default:
                return "unknown";
        }
    }

    public String retrieveOsName() {
        return System.getProperty("os.name");
    }

    public String retrieveJavaHome() {
        return System.getenv("JAVA_HOME");
    }

    public String retrieveSpringVersion() {
        return springVersion;
    }

    public String retrieveVersion() {
        return version;
    }

    public String retrieveMyFilteredPropertyValue() {
        return myFilteredPropertyValue;
    }
}
