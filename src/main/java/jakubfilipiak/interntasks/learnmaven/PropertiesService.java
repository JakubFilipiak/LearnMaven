package jakubfilipiak.interntasks.learnmaven;

import org.springframework.stereotype.Service;

@Service
public class PropertiesService {

    public String retrieveJavaHome() {
        return System.getenv("JAVA_HOME");
    }
}
