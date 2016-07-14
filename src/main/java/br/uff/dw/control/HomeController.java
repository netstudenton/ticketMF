/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dw.control;

import br.uff.dw.model.LoginModel;
import br.uff.dw.model.User;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author fabio
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("view","index");
        return "template";
    }
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("loginmodel",new LoginModel());
        model.addAttribute("view","login");
        return "template";
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginResult(@ModelAttribute LoginModel loginmodel, Model model) {
        model.addAttribute("view", "index");
        System.out.println(loginmodel.getUsername());
        return "template";
    }
    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("view","signup");
        return "template";
    }
    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public String loginResult(@ModelAttribute User novo, Model model) {
        model.addAttribute("view", "index");
        System.out.println(novo.getUsername());
        return "template";
    }
}
