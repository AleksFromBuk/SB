package com.example.demojvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Controller
public class ValidationController {

    @Autowired
    @Qualifier("personValidator")
    private final Validator personValidator;

    public ValidationController(@Qualifier("personValidator") Validator personValidator) {
        this.personValidator = personValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(personValidator);
    }

    @GetMapping("/")
    public String savePersonAction(Model model) {
       model.addAttribute("person", new Person());
       return "personEdit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePersonAction(@Valid @ModelAttribute("person") Person person,
                                   BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "personEdit";
        }

        model.addAttribute("name", person.getName());
        model.addAttribute("age", person.getAge());
        return "saveSuccess";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPersonAction(Model model) {
        model.addAttribute("person", new Person(null, null));
        return "personEdit";
    }


}
