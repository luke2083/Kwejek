package pl.akademiakodu.kwejkapp.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.kwejkapp.service.MemService;

/**
 * Created by luke on 24.06.2017.
 */

@RequestMapping("/")
@Controller
public class MainController {

    @Autowired
    MemService memService;

    @GetMapping
    public ModelAndView list() {
        ModelAndView view = new ModelAndView();
        view.setViewName("mem/list");
        view.addObject("list", memService.getList());
        return view;
    }

}
