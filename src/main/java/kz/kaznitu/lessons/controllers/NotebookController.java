package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Notebook;
import kz.kaznitu.lessons.models.Phone;
import kz.kaznitu.lessons.reposotories.NotebookRepository;
import kz.kaznitu.lessons.reposotories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/notebook")
public class NotebookController {
    @Autowired
    private NotebookRepository notebookRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("notebook",new Notebook());
        return "notebook_add_form";
    }


    @PostMapping("/add")
    public String addNotebook(@ModelAttribute Notebook notebook){
        notebookRepository.save(notebook) ;
        return "redirect:/notebook/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Notebook> allNotebook(){
        return notebookRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allNotebook2(Model model){
        List<Notebook> notebooks = (List<Notebook>) notebookRepository.findAll() ;
        model.addAttribute("notebooks", notebooks) ;
        return "notebooks" ;
    }

    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        notebookRepository.deleteById(idd);
        return new ModelAndView("redirect:/notebook/all");
    }
    @PostMapping("/editNotebookk")
    public String editNotebook(@ModelAttribute Notebook notebook) {
        Notebook notebook1 = new Notebook();
        notebook1.setId(a);
        notebook1.setModel(notebook.getModel());
        notebook1.setCompany(notebook.getCompany());
        notebook1.setStrana(notebook.getStrana());
        notebookRepository.save(notebook);
        return "redirect:/notebook/all2";
    }

    @RequestMapping(value = "/editNotebook",method = RequestMethod.GET)
    public ModelAndView editNotebook(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Notebook> notebook = (Optional<Notebook>) notebookRepository.findById(id);
        model.addAttribute("notebook",notebook);
        return new ModelAndView("editNotebook");
    }
    @RequestMapping("/editNotebook")
    public String showForm2(Model model){
        model.addAttribute("notebook",new Notebook());
        return "editNotebook";
    }




}

