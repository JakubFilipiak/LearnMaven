package jakubfilipiak.interntasks.learnmaven;

import org.springframework.stereotype.Service;

@Service
public class PropertiesService {

    public String retrieveOsName() {
        return System.getProperty("os.name");
    }

    public String retrieveJavaHome() {
        return System.getenv("JAVA_HOME");
    }
}
