package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.TelePhone;
import kz.kaznitu.lessons.reposotories.TelePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/phone")
public class Telephone {
    @Autowired
    private TelePhoneRepository telePhoneRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("phone",new TelePhone());
        return "phone_add_form";
    }


    @PostMapping("/add")
    public String addPhone(@ModelAttribute TelePhone phone){
        telePhoneRepository.save(phone) ;
        return "redirect:/phone/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody Iterable<TelePhone> allPhone(){
        return telePhoneRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allPhone2(Model model){
        List<TelePhone> phones = (List<TelePhone>) telePhoneRepository.findAll() ;
        model.addAttribute("phones", phones) ;
        return "phones" ;
    }

    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
         telePhoneRepository.deleteById(idd);
        return new ModelAndView("redirect:/phone/all");
    }
    @PostMapping("/editPhonee")
    public String editTeacher(@ModelAttribute TelePhone phone) {
        TelePhone telePhone = new TelePhone();
        telePhone.setId(a);
        telePhone.setModel(phone.getModel());
        telePhone.setCompany(phone.getCompany());
        telePhone.setStrana(phone.getStrana());
        telePhoneRepository.save(telePhone);
        return "redirect:/phone/all2";
    }

    @RequestMapping(value = "/editPhone",method = RequestMethod.GET)
    public ModelAndView editPhone(Model model,@RequestParam("id") long id){
        a=id;
        Optional<TelePhone> phone = (Optional<TelePhone>) telePhoneRepository.findById(id);
        model.addAttribute("phone",phone);
        return new ModelAndView("editPhone");
    }
    @RequestMapping("/editPhone")
    public String showForm2(Model model){
        model.addAttribute("phone",new TelePhone());
        return "editPhone";
    }




}
