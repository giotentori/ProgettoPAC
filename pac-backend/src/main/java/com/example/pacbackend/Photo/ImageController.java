package com.example.pacbackend.Photo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;

// import java.util.*;

@RestController
@RequestMapping(path = "images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> findByFileName(@PathVariable String fileName) {
        Image image = imageService.findByFileName(fileName);
        ByteArrayResource imageBody = new ByteArrayResource(image.getData());   //Prelevo da Image i byte che
                                                                                //compongono l'immagine
        return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_TYPE, image.getMimeType())
        .body(imageBody);
    }

    @PostMapping("/post")
    public String postImage(@RequestPart MultipartFile file) throws Exception {
        return imageService.postImage(file);

    }


}
