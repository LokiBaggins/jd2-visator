package jd2.baggins.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main2")
public class SpringController {

    @RequestMapping(name = "", method = {RequestMethod.GET, RequestMethod.POST})
    public String resolveTeamList(ModelMap model) {
        model.addAttribute("msg", "Прывітанне са Спрынговага кантроллера! ;)");
        return "main3";
    }

}
