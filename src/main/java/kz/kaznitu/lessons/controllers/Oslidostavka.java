package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Dostavka;
import kz.kaznitu.lessons.reposotories.DostavkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/delivery")
public class Oslidostavka {
    @Autowired
    private DostavkaRepository dostavkaRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("delivery", new Dostavka());
        return "delivery_add_form";
    }


    @PostMapping("/add")
    public String addDelivery(@ModelAttribute Dostavka delivery) {
        dostavkaRepository.save(delivery);
        return "redirect:/delivery/all";
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Dostavka> allDeliveries() {
        return dostavkaRepository.findAll();
    }

    @GetMapping("/all")
    public String allDeliveries2(Model model) {
        List<Dostavka> deliveries = (List<Dostavka>) dostavkaRepository.findAll();
        model.addAttribute("deliveries", deliveries);
        return "deliveries";
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd) {
        dostavkaRepository.deleteById(idd);
        return new ModelAndView("redirect:/delivery/all");

    }

    @PostMapping("/editDeliveryy")
    public String editDelivery(@ModelAttribute Dostavka delivery) {
        Dostavka dostavka = new Dostavka();
        dostavka.setId(a);
        dostavka.setCity(delivery.getCity());
        dostavka.setMagazin(delivery.getMagazin());
        return "redirect:/delivery/all2";
    }

    @RequestMapping(value = "/editDelivery", method = RequestMethod.GET)
    public ModelAndView editDelivery(Model model, @RequestParam("id") long id) {
        a = id;
        Optional<Dostavka> delivery = (Optional<Dostavka>) dostavkaRepository.findById(id);
        model.addAttribute("delivery", delivery);
        return new ModelAndView("editDelivery");
    }

    @RequestMapping("/editDelivery")
    public String showForm2(Model model) {
        model.addAttribute("delivery", new Dostavka());
        return "editDelivery";
    }
}

