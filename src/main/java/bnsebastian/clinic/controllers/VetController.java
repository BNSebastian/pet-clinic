package bnsebastian.clinic.controllers;

import bnsebastian.clinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/vets", "/vets.html"})
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/",})
    public String getView(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/vetList";
    }
}
