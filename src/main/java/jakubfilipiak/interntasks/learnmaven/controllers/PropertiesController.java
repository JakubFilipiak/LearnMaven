package jakubfilipiak.interntasks.learnmaven.controllers;

import jakubfilipiak.interntasks.learnmaven.PropertiesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PropertiesController {

    private PropertiesService propertiesService;

    public PropertiesController(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @GetMapping("/properties")
    public String getProperties(Model model) {
        model.addAttribute("osName", propertiesService.retrieveOsName());
        model.addAttribute("javaHome", propertiesService.retrieveJavaHome());
        return "properties";
    }
}
