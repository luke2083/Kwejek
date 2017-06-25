package pl.akademiakodu.kwejkapp.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.kwejkapp.entity.Comment;
import pl.akademiakodu.kwejkapp.entity.Mem;
import pl.akademiakodu.kwejkapp.service.CommentService;
import pl.akademiakodu.kwejkapp.service.MemService;

import javax.validation.Valid;

/**
 * Created by luke on 25.06.2017.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private MemService memServiceImpl;

    @Autowired
    private CommentService commentServiceImpl;

    @PostMapping()
    public ModelAndView saveComment(@RequestParam("memId") Long memId,
                                    @Valid Comment comment,
                                    BindingResult bindingResult) {

        Mem mem = memServiceImpl.findById(memId);

        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("mem/details");
            mav.addObject("mem", mem);
            mav.addObject("comment", comment);
            return mav;
        } else {
            comment.setMem(mem);
            commentServiceImpl.save(comment);
            return new ModelAndView("redirect:mem/" + memId);
        }

    }

}
