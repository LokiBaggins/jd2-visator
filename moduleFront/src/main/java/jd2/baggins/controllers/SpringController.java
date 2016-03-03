package jd2.baggins.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spring")
public class SpringController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String resolveTeamList(ModelMap model) {
        model.addAttribute("msg", "Прывітанне са Спрынговага кантроллера! ;)");
        return "main3";
    }

}
