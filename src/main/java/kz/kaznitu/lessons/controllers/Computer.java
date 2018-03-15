package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.reposotories.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/notebook")
public class Computer {
    @Autowired
    private ComputerRepository computerRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("computer",new kz.kaznitu.lessons.models.Computer());
        return "computer_add_form";
    }


    @PostMapping("/add")
    public String addNotebook(@ModelAttribute kz.kaznitu.lessons.models.Computer notebook){
        computerRepository.save(notebook) ;
        return "redirect:/notebook/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<kz.kaznitu.lessons.models.Computer> allNotebook(){
        return computerRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allNotebook2(Model model){
        List<kz.kaznitu.lessons.models.Computer> notebooks = (List<kz.kaznitu.lessons.models.Computer>) computerRepository.findAll() ;
        model.addAttribute("notebooks", notebooks) ;
        return "notebooks" ;
    }

    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        computerRepository.deleteById(idd);
        return new ModelAndView("redirect:/notebook/all");
    }
    @PostMapping("/editNotebookk")
    public String editNotebook(@ModelAttribute kz.kaznitu.lessons.models.Computer notebook) {
        kz.kaznitu.lessons.models.Computer computer = new kz.kaznitu.lessons.models.Computer();
        computer.setId(a);
        computer.setModel(notebook.getModel());
        computer.setCompany(notebook.getCompany());
        computer.setStrana(notebook.getStrana());
        computerRepository.save(notebook);
        return "redirect:/notebook/all2";
    }

    @RequestMapping(value = "/editNotebook",method = RequestMethod.GET)
    public ModelAndView editNotebook(Model model,@RequestParam("id") long id){
        a=id;
        Optional<kz.kaznitu.lessons.models.Computer> notebook = (Optional<kz.kaznitu.lessons.models.Computer>) computerRepository.findById(id);
        model.addAttribute("notebook",notebook);
        return new ModelAndView("editNotebook");
    }
    @RequestMapping("/editNotebook")
    public String showForm2(Model model){
        model.addAttribute("notebook",new kz.kaznitu.lessons.models.Computer());
        return "editNotebook";
    }




}

