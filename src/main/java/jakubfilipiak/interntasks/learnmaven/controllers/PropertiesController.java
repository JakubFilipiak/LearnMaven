package jakubfilipiak.interntasks.learnmaven.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PropertiesController {

    @GetMapping("/properties")
    public String getProperties() {
        return "properties";
    }
}
