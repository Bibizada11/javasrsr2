package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Phone;
import kz.kaznitu.lessons.reposotories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/phone")
public class PhoneController {
    @Autowired
    private PhoneRepository phoneRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("phone",new Phone());
        return "phone_add_form";
    }


    @PostMapping("/add")
    public String addPhone(@ModelAttribute Phone phone){
        phoneRepository.save(phone) ;
        return "redirect:/phone/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody Iterable<Phone> allPhone(){
        return phoneRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allPhone2(Model model){
        List<Phone> phones = (List<Phone>) phoneRepository.findAll() ;
        model.addAttribute("phones", phones) ;
        return "phones" ;
    }

    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        phoneRepository.deleteById(idd);
        return new ModelAndView("redirect:/phone/all");
    }
    @PostMapping("/editPhonee")
    public String editTeacher(@ModelAttribute Phone phone) {
        Phone phone1 = new Phone();
        phone1.setId(a);
        phone1.setModel(phone.getModel());
        phone1.setCompany(phone.getCompany());
        phone1.setStrana(phone.getStrana());
        phoneRepository.save(phone1);
        return "redirect:/phone/all2";
    }

    @RequestMapping(value = "/editPhone",method = RequestMethod.GET)
    public ModelAndView editPhone(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Phone> phone = (Optional<Phone>) phoneRepository.findById(id);
        model.addAttribute("phone",phone);
        return new ModelAndView("editPhone");
    }
    @RequestMapping("/editPhone")
    public String showForm2(Model model){
        model.addAttribute("phone",new Phone());
        return "editPhone";
    }




}
