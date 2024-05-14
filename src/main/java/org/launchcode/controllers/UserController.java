package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserController {

    // /user/add
    @GetMapping("add")
    public String displayAddUserForm(){
        return"user/add";

    }


    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, Errors errors, String verify) {
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);

        if(errors.hasErrors()){
            model.addAttribute("error" , "Validation error");
            return"user/add";

        }

        if (user.getPassword().equals(verify)) {
            return "user/index";
        }
        else {
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }

    }


}
