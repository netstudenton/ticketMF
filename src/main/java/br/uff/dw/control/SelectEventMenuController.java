/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dw.control;

import br.uff.dw.Constant;
import br.uff.dw.model.Event;
import br.uff.dw.model.User;
import br.uff.dw.persistence.EventDAO;
import java.util.ArrayList;
import java.util.Calendar;
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
public class SelectEventMenuController {

    //jcombobox de ordenação por ranking , pelo mais novos , por preço
    //metodo de exibir uma lista paginada dado um tipo , cinema,show ..
    //metodo exibe lista do resultado de uma busca por titulo ou descricao
    @Autowired
    private EventDAO eventDAO;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String showEvents(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "type", defaultValue = Constant.ALL) String type,
            @RequestParam(value = "place") String place,
            Model model) {
        System.out.println(place);
        List<Event> eventos = new ArrayList<>();
        if (place != null) {
            eventos = eventDAO.findByPlaceAndTypeOrderByPriceAsc(place, type);
        }
        List<String> pages = new ArrayList<>();
        int n = eventos.size() / 6;
        if ((eventos.size() % 6) != 0) {
            n++;
        }
        for (int i = 0; i < n; i++) {
            pages.add(i + "");
        }
        int p = Integer.parseInt(page);
        model.addAttribute("atual", page);
        model.addAttribute("pages", pages);
        if (n > 0) {
            model.addAttribute("listEvents", eventos.subList(p * 6, p * 6 + 6));
        } else {
            model.addAttribute("listEvents", eventos);
        }
        model.addAttribute("view", "selectEvent");
        return "template";
    }
}
