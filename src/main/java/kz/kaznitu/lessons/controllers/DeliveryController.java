package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Delivery;
import kz.kaznitu.lessons.models.User;
import kz.kaznitu.lessons.reposotories.DeliveryRepository;
import kz.kaznitu.lessons.reposotories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryRepository deliveryRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("delivery", new Delivery());
        return "delivery_add_form";
    }


    @PostMapping("/add")
    public String addDelivery(@ModelAttribute Delivery delivery) {
        deliveryRepository.save(delivery);
        return "redirect:/delivery/all";
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Delivery> allDeliveries() {
        return deliveryRepository.findAll();
    }

    @GetMapping("/all")
    public String allDeliveries2(Model model) {
        List<Delivery> deliveries = (List<Delivery>) deliveryRepository.findAll();
        model.addAttribute("deliveries", deliveries);
        return "deliveries";
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd) {
        deliveryRepository.deleteById(idd);
        return new ModelAndView("redirect:/delivery/all");

    }

    @PostMapping("/editDeliveryy")
    public String editDelivery(@ModelAttribute Delivery delivery) {
        Delivery delivery1 = new Delivery();
        delivery1.setId(a);
        delivery1.setCity(delivery.getCity());
        delivery1.setMagazin(delivery.getMagazin());
        return "redirect:/delivery/all2";
    }

    @RequestMapping(value = "/editDelivery", method = RequestMethod.GET)
    public ModelAndView editDelivery(Model model, @RequestParam("id") long id) {
        a = id;
        Optional<Delivery> delivery = (Optional<Delivery>) deliveryRepository.findById(id);
        model.addAttribute("delivery", delivery);
        return new ModelAndView("editDelivery");
    }

    @RequestMapping("/editDelivery")
    public String showForm2(Model model) {
        model.addAttribute("delivery", new Delivery());
        return "editDelivery";
    }
}

