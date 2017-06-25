package pl.akademiakodu.kwejkapp.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.kwejkapp.entity.Comment;
import pl.akademiakodu.kwejkapp.entity.Mem;
import pl.akademiakodu.kwejkapp.service.MemService;

import javax.jws.WebParam;
import java.util.Random;

/**
 * Created by luke on 24.06.2017.
 */

@RequestMapping("/mem")
@Controller
public class MemDetailsController {

    @Autowired
    private MemService memService;

    @GetMapping("/{id}")
    public ModelAndView getDetails(@PathVariable("id") Long id) {
        if (id == null || id < 0) {
            return redirect();
        } else {

        }

        ModelAndView view = new ModelAndView();
        view.setViewName("mem/details");
        Mem m = memService.findById(id);
        view.addObject("mem", m);
        view.addObject("comment", new Comment());
        return view;

    }

    @GetMapping("/losuj")
    public ModelAndView getRandom() {
        ModelAndView view = new ModelAndView();
        view.setViewName("mem/details");
        Mem mem = memService.getRandom();
        view.addObject("comment", new Comment());
        view.addObject("mem", mem);
        return view;
    }

    private ModelAndView redirect() {
        return new ModelAndView("redirect:/");
    }

}
