/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dw.control;

import br.uff.dw.Constant;
import br.uff.dw.model.BuyModel;
import br.uff.dw.model.Event;
import br.uff.dw.model.FindModel;
import br.uff.dw.model.LoginModel;
import br.uff.dw.model.Purchase;
import br.uff.dw.model.User;
import br.uff.dw.persistence.EventDAO;
import br.uff.dw.persistence.PurchaseDAO;
import br.uff.dw.persistence.UserDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author fabio
 */
@Controller
@Scope("session")
public class HomeController {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private EventDAO eventDAO;
    @Autowired
    private PurchaseDAO purchaseDAO;
    private User user;
    private String local = "Rio de Janeiro";

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("view", "index");
        model.addAttribute("user", user);
        model.addAttribute("local", local);
        model.addAttribute("findModel", new FindModel());
        return "template";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("loginmodel", new LoginModel());
        model.addAttribute("view", "login");
        model.addAttribute("user", user);
        model.addAttribute("findModel", new FindModel());
        model.addAttribute("local", local);
        return "template";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginResult(@ModelAttribute LoginModel loginmodel, Model model) {

        user = userDAO.findByUsernameAndPassword(loginmodel.getUsername(), loginmodel.getPassword());
        if (user == null) {
            model.addAttribute("view", "error");
            model.addAttribute("message", "usuario não existe");
        } else {
            model.addAttribute("view", "index");
        }
        model.addAttribute("user", user);
        model.addAttribute("findModel", new FindModel());
        model.addAttribute("local", local);
        return "template";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("view", "signup");
        model.addAttribute("user", user);
        model.addAttribute("findModel", new FindModel());
        model.addAttribute("local", local);
        return "template";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupResult(@ModelAttribute User novo, Model model) {

        User test = userDAO.findByEmail(novo.getEmail());
        if (test == null) {
            user = userDAO.save(novo);
            model.addAttribute("view", "index");
        } else {
            model.addAttribute("view", "error");
            model.addAttribute("message", "usuario Ja existe");
        }
        model.addAttribute("user", user);
        model.addAttribute("findModel", new FindModel());
        model.addAttribute("local", local);
        return "template";
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String showEvents(
            @RequestParam(value = "type", defaultValue = Constant.ALL) String type,
            Model model) {
        List<Event> eventos = new ArrayList<>();
        eventos = eventDAO.findByPlaceAndTypeOrderByPriceAsc(local, type);
        model.addAttribute("listEvents", eventos);
        model.addAttribute("view", "selectEvent");
        model.addAttribute("findModel", new FindModel());
        model.addAttribute("user", user);
        model.addAttribute("local", local);
        return "template";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String buscarEvents(
            @ModelAttribute FindModel novo,
            Model model) {
        List<Event> eventos = new ArrayList<>();
        eventos = eventDAO.findByTitleContainingOrDescriptionContaining(novo.getName(), novo.getName());
        model.addAttribute("listEvents", eventos);
        model.addAttribute("view", "selectEvent");
        model.addAttribute("findModel", new FindModel());
        model.addAttribute("user", user);
        model.addAttribute("local", local);
        return "template";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public String buyEvent(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "id") String id,
            Model model) {

        model.addAttribute("view", "purchase");
        model.addAttribute("findModel", new FindModel());
        model.addAttribute("user", user);
        model.addAttribute("buyModel", new BuyModel(title, id));
        model.addAttribute("local", local);
        return "template";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String buyEventResult(@ModelAttribute BuyModel novo, Model model) {
        Event e = eventDAO.findOne(Long.parseLong(novo.getEventID()));
        Purchase pu = purchaseDAO.findByUserAndEvent(user, e);
        if (user == null) {
            model.addAttribute("view", "error");
            model.addAttribute("message", "não ha usuario logado");
        } else if (e.getAmount() > 0) {
            if (pu != null) {
                if (pu.getAmount() < 4) {
                    e.setAmount(e.getAmount() - 1);
                    e = eventDAO.save(e);
                    pu.setAmount(pu.getAmount() + 1);
                    pu = purchaseDAO.save(pu);
                    model.addAttribute("view", "print");
                    model.addAttribute("purchase", pu);
                } else {
                    model.addAttribute("view", "error");
                    model.addAttribute("message", "você alcançou limite de tickets para este evento");
                }
            } else {
                e.setAmount(e.getAmount() - 1);
                e = eventDAO.save(e);
                pu = new Purchase(1, user, e);
                pu = purchaseDAO.save(pu);

                model.addAttribute("view", "print");
                model.addAttribute("purchase", pu);
            }
        } else {
            model.addAttribute("view", "error");
            model.addAttribute("message", "não ha mais ingressos");
        }
        model.addAttribute("findModel", new FindModel());
        model.addAttribute("user", user);
        model.addAttribute("local", local);
        return "template";
    }

    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String changeLocal(
            @RequestParam(value = "p") String place,
            Model model) {
        local = place;
        model.addAttribute("view", "index");
        model.addAttribute("user", user);
        model.addAttribute("local", local);
        model.addAttribute("findModel", new FindModel());
        return "template";
    }
}
