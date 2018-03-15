package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.reposotories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/client")
public class Client {
    @Autowired
    private ClientRepository clientRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("client", new kz.kaznitu.lessons.models.Client());
        return "client_add_form";
    }


    @PostMapping("/add")
    public String addUser(@ModelAttribute kz.kaznitu.lessons.models.Client user) {
        clientRepository.save(user);
        return "redirect:/user/all";
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<kz.kaznitu.lessons.models.Client> allUsers() {
        return clientRepository.findAll();
    }

    @GetMapping("/all")
    public String allUsers2(Model model) {
        List<kz.kaznitu.lessons.models.Client> users = (List<kz.kaznitu.lessons.models.Client>) clientRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd) {
        clientRepository.deleteById(idd);
        return new ModelAndView("redirect:/user/all");

    }

    @PostMapping("/editUserr")
    public String editUser(@ModelAttribute kz.kaznitu.lessons.models.Client user) {
        kz.kaznitu.lessons.models.Client client = new kz.kaznitu.lessons.models.Client();
        client.setId(a);
        client.setFirstName(user.getFirstName());
        client.setLastName(user.getLastName());
        client.setNumber(user.getNumber());
        client.setCity(user.getCity());
        client.setStreet(user.getStreet());
        clientRepository.save(client);
        return "redirect:/user/all2";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(Model model, @RequestParam("id") long id) {
        a = id;
        Optional<kz.kaznitu.lessons.models.Client> user = (Optional<kz.kaznitu.lessons.models.Client>) clientRepository.findById(id);
        model.addAttribute("user", user);
        return new ModelAndView("editUser");
    }

    @RequestMapping("/editUser")
    public String showForm2(Model model) {
        model.addAttribute("user", new kz.kaznitu.lessons.models.Client());
        return "editUser";
    }
}

