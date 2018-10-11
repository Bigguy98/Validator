package vtt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vtt.demo.domain.Person;
import vtt.demo.validator.PersonValidator;

import javax.validation.Valid;

@Controller
public class MyController {
    @Autowired
    PersonValidator validator;

    @GetMapping("/")
    public String form(Model model){
        model.addAttribute("person",new Person());
        return "form";
    }


    @PostMapping("/")
    public String result(@ModelAttribute(value = "person") @Valid Person person, BindingResult bindingResult){
        validator.validate(person,bindingResult);
        if(bindingResult.hasErrors()){
            return "form";
        }
        return "result";
    }
}
