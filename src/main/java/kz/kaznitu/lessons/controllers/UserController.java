package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.User;
import kz.kaznitu.lessons.reposotories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "user_add_form";
    }


    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/user/all";
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<User> allUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/all")
    public String allUsers2(Model model) {
        List<User> users = (List<User>) userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd) {
        userRepository.deleteById(idd);
        return new ModelAndView("redirect:/user/all");

    }

    @PostMapping("/editUserr")
    public String editUser(@ModelAttribute User user) {
        User user1 = new User();
        user1.setId(a);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setNumber(user.getNumber());
        user1.setCity(user.getCity());
        user1.setStreet(user.getStreet());
        userRepository.save(user1);
        return "redirect:/user/all2";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(Model model, @RequestParam("id") long id) {
        a = id;
        Optional<User> user = (Optional<User>) userRepository.findById(id);
        model.addAttribute("user", user);
        return new ModelAndView("editUser");
    }

    @RequestMapping("/editUser")
    public String showForm2(Model model) {
        model.addAttribute("user", new User());
        return "editUser";
    }
}

