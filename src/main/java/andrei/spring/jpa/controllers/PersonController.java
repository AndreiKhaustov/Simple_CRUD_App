package andrei.spring.jpa.controllers;

import andrei.spring.jpa.models.Person;
import andrei.spring.jpa.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {
     private PersonService personService;
@Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping
    public String index(Model model){
    model.addAttribute("people", personService.index());
    return "people/index";
    }
    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id")int id){
    Person person = personService.show(id);
    model.addAttribute("person", person);
    model.addAttribute("items", person.getItems());

    return "people/show";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
    model.addAttribute("person", personService.show(id));
    return "people/edit";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public String update(@PathVariable("id")int id, @ModelAttribute("person") Person person) {
      personService.update(person, id);
      return "redirect:/people";
    }
    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id")int id){
    personService.delete(id);
    return "redirect:/people";
    }

    @GetMapping("/create")
    public String createPerson(@ModelAttribute("person")Person person) {
    return "people/create";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("person")Person person){
    personService.save(person);
    return "redirect:/people";
    }
    }

