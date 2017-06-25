package pl.akademiakodu.kwejkapp.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.kwejkapp.entity.Comment;
import pl.akademiakodu.kwejkapp.entity.Mem;
import pl.akademiakodu.kwejkapp.service.FileService;
import pl.akademiakodu.kwejkapp.service.MemService;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by luke on 24.06.2017.
 */
@RequestMapping("/mem")
@Controller
public class AddMemController {

    @Autowired
    private FileService fileService;

    @Autowired
    private MemService memService;

    @GetMapping("/add")
    public ModelAndView addForm() {
        ModelAndView view = new ModelAndView();
        Mem m = new Mem();
        view.addObject("mem", m);
        view.addObject("comment", new Comment());
        view.setViewName("/mem/addmem");
        return view;
    }

    @PostMapping("/add")
    public ModelAndView saveForm(@RequestParam("file") MultipartFile file, Mem mem) {

        try {
            String uploadedFile = fileService.store(file);
            mem.setImagePath(uploadedFile);
            mem.setTimestamp(LocalDateTime.now());
            memService.save(mem);
            return new ModelAndView("redirect:/");

        } catch (IOException e) {
            e.printStackTrace();
        }
        ModelAndView view = new ModelAndView();
        view.addObject("mem", mem);
        view.setViewName("mem/list");
        return view;

    }

}
