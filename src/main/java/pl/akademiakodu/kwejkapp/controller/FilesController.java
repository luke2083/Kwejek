package pl.akademiakodu.kwejkapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.kwejkapp.service.FileService;

/**
 * Created by luke on 24.06.2017.
 */

@RequestMapping("/files")
@Controller
public class FilesController {

    @Autowired
    private FileService fileService;

    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable("filename") String filename) {
        Resource file = fileService.getFilesAsResource(filename);

        return ResponseEntity.
                ok().
                header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\" "+file.getFilename()+"\"").
                body(file);
    }

}
