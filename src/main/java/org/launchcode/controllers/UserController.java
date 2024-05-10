package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
       if(verify.equals(user.getPassword( ))){
            return "user/index";
       }
       else{
           model.addAttribute("username", user.getUsername());
           model.addAttribute("email",user.getEmail());
           model.addAttribute("error", "Incorrect Password");
           return "user/add";
       }
    }

}
