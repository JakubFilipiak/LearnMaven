package jakubfilipiak.interntasks.learnmaven.controllers;

import jakubfilipiak.interntasks.learnmaven.services.PropertiesService;
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
        model.addAttribute("profile", propertiesService.retrieveActiveProfileName());
        model.addAttribute("osName", propertiesService.retrieveOsName());
        model.addAttribute("javaHome", propertiesService.retrieveJavaHome());
        model.addAttribute("springVersion", propertiesService.retrieveSpringVersion());
        model.addAttribute("version", propertiesService.retrieveVersion());
        model.addAttribute("myFilteredProperty", propertiesService.retrieveMyFilteredPropertyValue());
        return "properties";
    }
}
